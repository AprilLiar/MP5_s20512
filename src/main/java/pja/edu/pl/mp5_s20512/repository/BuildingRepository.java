package pja.edu.pl.mp5_s20512.repository;

import org.springframework.data.repository.CrudRepository;
import pja.edu.pl.mp5_s20512.model.Building;

import java.util.List;

public interface BuildingRepository extends CrudRepository<Building, Long>{
    public List<Building> findByName(String name);
    public List<Building> findByNameAndLocation(String name, String location);

}
