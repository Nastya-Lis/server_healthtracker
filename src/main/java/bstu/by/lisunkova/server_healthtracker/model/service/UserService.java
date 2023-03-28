package bstu.by.lisunkova.server_healthtracker.model.service;


import bstu.by.lisunkova.server_healthtracker.controller_layer.mapping.UserMapping;
import bstu.by.lisunkova.server_healthtracker.model.entity.StatusWalk;
import bstu.by.lisunkova.server_healthtracker.model.entity.User;
import bstu.by.lisunkova.server_healthtracker.model.repository.AchievementRepository;
import bstu.by.lisunkova.server_healthtracker.model.repository.StatusWalkRepository;
import bstu.by.lisunkova.server_healthtracker.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class UserService extends CommonService<User, UserRepository> {

    @Autowired
    AchievementRepository achievementRepository;

    @Autowired
    StatusWalkRepository statusWalkRepository;

    @Autowired
    UserService(UserRepository repository){super(repository);}

    public User getUserByStatusWalk(StatusWalk statusWalk){
        return repository.findUserByStatusWalkByStatus(statusWalk);
    }

    public List<User> getUsersByAchieveTitle(String title){
        return repository.findUsersByAchievementTitle(title);
    }

    public List<User> getUsersByStatusWalk(String status){
        return repository.findUsersByStatusWalkByStatus(status);
    }
}
