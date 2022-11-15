package pl.com.bard.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.com.bard.petclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
