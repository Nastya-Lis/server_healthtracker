package bstu.by.lisunkova.server_healthtracker.model.service;


import bstu.by.lisunkova.server_healthtracker.model.entity.StatusWalk;
import bstu.by.lisunkova.server_healthtracker.model.repository.AchievementRepository;
import bstu.by.lisunkova.server_healthtracker.model.repository.StatusWalkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusWalkService extends CommonService<StatusWalk, StatusWalkRepository> {

    @Autowired
    StatusWalkService(StatusWalkRepository repository) {
        super(repository);
    }

}


