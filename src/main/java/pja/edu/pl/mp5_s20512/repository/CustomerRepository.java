package pja.edu.pl.mp5_s20512.repository;

import org.springframework.data.repository.CrudRepository;
import pja.edu.pl.mp5_s20512.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
