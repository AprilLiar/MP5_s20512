package pja.edu.pl.mp5_s20512.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.util.Assert;
import pja.edu.pl.mp5_s20512.model.Building;
import pja.edu.pl.mp5_s20512.model.Person;
import pja.edu.pl.mp5_s20512.model.Worker;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.Arrays;
import java.util.HashSet;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class AssociationTest {
    @Autowired
    private WorkerRepository workerRepository;
    @Autowired
    private BuildingRepository buildingRepository;

    @PersistenceContext
    private EntityManager entityManager;

    Building b1;
    Worker w1;

    @Test
    public void testRequiredDependencies(){
        assertNotNull(workerRepository);
        assertNotNull(buildingRepository);
    }

    @BeforeEach
    public void initData() {
        b1 = Building.builder()
                .name("Weapon Shop")
                .location("Bank Street")
                .type("Shop")
                .build();

        w1 = Worker.builder()
                .firstName("Spec")
                .lastName("Jensen")
                .skills(new HashSet<>(Arrays.asList("Handling demon clients", "Identifying weapons")))
                .pocketMoney(14)
                .wage(124)
                .build();
    }

    @Test
    public void testSave() {
        b1.getPersons().add(w1);
        w1.getBuildings().add(b1);
        workerRepository.save(w1);
        buildingRepository.save(b1);

        assertTrue(workerRepository.findById(w1.getPerson_id()).isPresent());
        System.out.println(workerRepository.findById(w1.getPerson_id()));
        System.out.println(buildingRepository.findAll());
        System.out.println("Person from building id is: " + b1.getPersons() + ", whereas the real id is: " + w1.getPerson_id());
    }

}
