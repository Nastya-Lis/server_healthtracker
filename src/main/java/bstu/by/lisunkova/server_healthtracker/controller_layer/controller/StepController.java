package bstu.by.lisunkova.server_healthtracker.controller_layer.controller;


import bstu.by.lisunkova.server_healthtracker.controller_layer.mapping.StepMapping;
import bstu.by.lisunkova.server_healthtracker.controller_layer.mapping.TermMapping;
import bstu.by.lisunkova.server_healthtracker.controller_layer.mapping.UserMapping;
import bstu.by.lisunkova.server_healthtracker.model.dto.StepDto;
import bstu.by.lisunkova.server_healthtracker.model.entity.Step;
import bstu.by.lisunkova.server_healthtracker.model.repository.StepRepository;
import bstu.by.lisunkova.server_healthtracker.model.service.StepService;
import bstu.by.lisunkova.server_healthtracker.model.service.TermService;
import bstu.by.lisunkova.server_healthtracker.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("steps")
public class StepController {
    @Autowired
    StepMapping stepMapping;
    @Autowired
    StepService stepService;
    @Autowired
    StepRepository stepRepository;
    @Autowired
    UserMapping userMapping;
    @Autowired
    UserService userService;
    @Autowired
    TermMapping termMapping;
    @Autowired
    TermService termService;

    @GetMapping("/all")
    public List<StepDto> getAll(){
        Step d = new Step();
        return stepMapping.entitiesToDtoes(stepService.viewAll());
    }

    @GetMapping("/user_and_date")
    public List<StepDto> getByUserIdAndDate(@RequestParam String user, @RequestParam String date){
        return stepMapping.entitiesToDtoes(stepService.getStepsByUserIdAndDate(user, date));
    }

    @GetMapping("/comparison")
    public List<StepDto> getByTwoUsersInDate(@RequestParam String user1, @RequestParam String user2 ,@RequestParam String date){
        return stepMapping.entitiesToDtoes(stepService
                .getStepsForComparisonBetweenTwoUsersInDate(user1,user2, date));
    }

}
