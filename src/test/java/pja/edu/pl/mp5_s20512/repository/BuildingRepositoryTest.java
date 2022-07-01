package pja.edu.pl.mp5_s20512.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import pja.edu.pl.mp5_s20512.model.Building;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolationException;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class BuildingRepositoryTest {
    public enum buildingType {Storage, Store, Home}

    @Autowired
    private BuildingRepository buildingRepository;

    @PersistenceContext
    private EntityManager entityManager;

    Building b1;
    @BeforeEach
    public void initData(){
        b1 = Building.builder()
                .name("Candy Shop")
                .location("Ogre Square")
                .type("Store")
                .build();
    }

    @Test
    public void testRequiredDependencies() {
        assertNotNull(buildingRepository);
    }

    @Test
    public void testFetchBuildings(){
        Iterable<Building> all = buildingRepository.findAll();
        for(Building b : all){
            System.out.println(b);
        }
    }

    @Test
    public void testSaveBuilding(){
        buildingRepository.save(b1);
        entityManager.flush();
        assertEquals(3, buildingRepository.count());
    }

    @Test
    public void testSaveInvalidBuildingType() {
        assertThrows(ConstraintViolationException.class, () -> {
            b1.setType("");
            buildingRepository.save(b1);
            entityManager.flush();
        });

    }

    @Test
    public void testFindByName() {
        assertEquals(1, buildingRepository.findByName("Home Ihn").size());
    }

    @Test
    public void testFindByNameAndLocation() {
        assertEquals(1, buildingRepository.findByNameAndLocation("Home Ihn", "Elf Street").size());
    }
}