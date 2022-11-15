package pl.com.bard.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.com.bard.petclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
