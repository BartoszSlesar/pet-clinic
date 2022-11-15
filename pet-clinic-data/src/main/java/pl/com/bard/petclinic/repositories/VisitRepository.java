package pl.com.bard.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.com.bard.petclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
