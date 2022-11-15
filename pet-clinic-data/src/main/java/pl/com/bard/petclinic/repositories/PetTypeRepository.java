package pl.com.bard.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.com.bard.petclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
