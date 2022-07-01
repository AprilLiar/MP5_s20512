package pja.edu.pl.mp5_s20512.repository;

import org.springframework.data.repository.CrudRepository;
import pja.edu.pl.mp5_s20512.model.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {

}
