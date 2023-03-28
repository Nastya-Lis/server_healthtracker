package bstu.by.lisunkova.server_healthtracker.model.service;


import bstu.by.lisunkova.server_healthtracker.model.entity.Achievement;
import bstu.by.lisunkova.server_healthtracker.model.repository.AchievementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AchievementService extends CommonService<Achievement, AchievementRepository>{

    @Autowired
    AchievementService(AchievementRepository repository){super(repository);}

}
