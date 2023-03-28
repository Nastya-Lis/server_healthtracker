package bstu.by.lisunkova.server_healthtracker.controller_layer.controller;


import bstu.by.lisunkova.server_healthtracker.controller_layer.mapping.AchievementMapping;
import bstu.by.lisunkova.server_healthtracker.controller_layer.mapping.UserMapping;
import bstu.by.lisunkova.server_healthtracker.model.dto.UserDto;
import bstu.by.lisunkova.server_healthtracker.model.entity.User;
import bstu.by.lisunkova.server_healthtracker.model.repository.UserRepository;
import bstu.by.lisunkova.server_healthtracker.model.service.AchievementService;
import bstu.by.lisunkova.server_healthtracker.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("user")
public class UserController extends CommonController<User, UserRepository,
        UserDto, UserService, UserMapping>{

    @Autowired
    UserMapping userMapping;

    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;

    @Autowired
    AchievementMapping achievementMapping;

    @Autowired
    AchievementService achievementService;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    public UserController(UserMapping mapping, UserService service) {
        super(mapping, service);
    }

    @GetMapping("/byAchieve")
    public Collection<UserDto> getUsersByAchieve(@RequestParam String title){
        return userMapping.entitiesToDtoes(userService.getUsersByAchieveTitle(title));
    }

    @GetMapping("/byStatus")
    public Collection<UserDto> getUsersByStatus(@RequestParam String status){
        return userMapping.entitiesToDtoes(userService.getUsersByStatusWalk(status));
    }

 //   @PutMapping("/update")
 //   public Collection<UserDto>

}
