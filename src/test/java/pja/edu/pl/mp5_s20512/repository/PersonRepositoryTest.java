package pja.edu.pl.mp5_s20512.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import pja.edu.pl.mp5_s20512.model.Customer;
import pja.edu.pl.mp5_s20512.model.Worker;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PersonRepositoryTest {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private WorkerRepository workerRepository;

    @PersistenceContext
    private EntityManager entityManager;

    Worker w1, w2;
    Customer c1;

    @BeforeEach
    public void initData() {
        w1 = Worker.builder().
                firstName("Jack")
                .lastName("Hanma")
                .pocketMoney(12)
                .skills(new HashSet<>(Arrays.asList("Handling demon clients", "Identifying weapons")))
                .wage(140)
                .build();
        w2 = Worker.builder().
                firstName("Baki")
                .lastName("Hanma")
                .pocketMoney(22)
                .wage(120)
                .skills(new HashSet<>(Arrays.asList("Being tough", "Negotiating")))
                .build();
        c1 = Customer.builder().firstName("Baki")
                .lastName("Hanma")
                .pocketMoney(22)
                .preferences("Being tough")
                .build();
    }

    @Test
    public void testRequiredDependencies() {
        assertNotNull(personRepository);
        assertNotNull(workerRepository);
        assertNotNull(customerRepository);
    }

    @Test
    public void testSaveAll() {
        workerRepository.saveAll((Arrays.asList(w1, w2)));
        customerRepository.save(c1);
        entityManager.flush();
        assertEquals(3, personRepository.count());
    }
}