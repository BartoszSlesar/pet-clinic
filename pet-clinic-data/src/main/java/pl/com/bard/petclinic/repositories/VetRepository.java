package pl.com.bard.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.com.bard.petclinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
