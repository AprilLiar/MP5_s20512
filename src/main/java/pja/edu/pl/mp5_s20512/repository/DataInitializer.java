package pja.edu.pl.mp5_s20512.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pja.edu.pl.mp5_s20512.model.Building;

@Component
@RequiredArgsConstructor
public class DataInitializer {

    private final BuildingRepository buildingRepository;


    @EventListener
    public void atStart(ContextRefreshedEvent ev) {
        System.out.println("context refreshed");
        System.out.println(buildingRepository.findAll());
    }

}
