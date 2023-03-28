package bstu.by.lisunkova.server_healthtracker.model.service;

import bstu.by.lisunkova.server_healthtracker.model.entity.WaterLevel;
import bstu.by.lisunkova.server_healthtracker.model.repository.WaterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WaterService {
    protected final WaterRepository repository;

    public WaterService(WaterRepository repository) {
        this.repository = repository;
    }

    public List<WaterLevel> viewAll(){
        return repository.findAll();
    }

    public List<WaterLevel> viewWaterGlassesByUserAndDate(String user_id, String date){
        return repository.findWaterLevelByUserAndDate(user_id, date);
    }
}
