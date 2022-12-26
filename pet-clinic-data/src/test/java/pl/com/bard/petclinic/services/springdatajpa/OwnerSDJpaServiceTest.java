package pl.com.bard.petclinic.services.springdatajpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.com.bard.petclinic.model.Owner;
import pl.com.bard.petclinic.repositories.OwnerRepository;
import pl.com.bard.petclinic.repositories.PetRepository;
import pl.com.bard.petclinic.repositories.PetTypeRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {


    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSDJpaService service;

    final String lastName = "Smith";
    final Long ownerId = 1L;

    Owner returnOwner;


    @BeforeEach
    void setUp() {
        returnOwner = Owner.builder().id(ownerId).lastName(lastName).build();
    }

    @Test
    void findAll() {
        Set<Owner> returnOwnersSet = new HashSet<>();
        returnOwnersSet.add(Owner.builder().id(1L).build());
        returnOwnersSet.add(Owner.builder().id(2L).build());
        when(ownerRepository.findAll()).thenReturn(returnOwnersSet);

        Set<Owner> owners = service.findAll();

        assertAll("Find all should return set",
                () -> assertNotNull(owners),
                () -> assertEquals(2, owners.size())


        );

    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));
        Owner smith = service.findById(ownerId);
        verify(ownerRepository, times(1)).findById(anyLong());
        assertAll("Should return owner by last name",
                () -> assertNotNull(smith),
                () -> assertEquals(lastName, smith.getLastName()),
                () -> assertEquals(ownerId, smith.getId())

        );

    }

    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
        Owner smith = service.findById(ownerId);
        verify(ownerRepository, times(1)).findById(anyLong());
        assertNull(smith);

    }

    @Test
    void save() {
        when(ownerRepository.save(any())).thenReturn(returnOwner);
        Owner smith = service.save(returnOwner);
        verify(ownerRepository, times(1)).save(any());
        assertAll("Should return owner object found by last name",
                () -> assertNotNull(smith),
                () -> assertEquals(lastName, smith.getLastName()),
                () -> assertEquals(ownerId, smith.getId())

        );
    }

    @Test
    void delete() {
        service.delete(returnOwner);
        verify(ownerRepository,times(1)).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(1L);
        verify(ownerRepository,times(1)).deleteById(anyLong());
    }

    @Test
    void findByLastName() {
        Owner returnOwner = Owner.builder().id(ownerId).lastName(lastName).build();
        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);
        Owner smith = service.findByLastName(lastName);
        verify(ownerRepository, times(1)).findByLastName(any());
        assertAll("Should return owner by last name",
                () -> assertNotNull(smith),
                () -> assertEquals(lastName, smith.getLastName()),
                () -> assertEquals(ownerId, smith.getId())

        );
    }
}