package bstu.by.lisunkova.server_healthtracker.controller_layer.controller;

import bstu.by.lisunkova.server_healthtracker.controller_layer.mapping.UserMapping;
import bstu.by.lisunkova.server_healthtracker.controller_layer.mapping.WaterMapping;
import bstu.by.lisunkova.server_healthtracker.model.dto.Water_LevelDto;
import bstu.by.lisunkova.server_healthtracker.model.repository.WaterRepository;
import bstu.by.lisunkova.server_healthtracker.model.service.UserService;
import bstu.by.lisunkova.server_healthtracker.model.service.WaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("water")
public class WaterController {

    @Autowired
    WaterMapping waterMapping;
    @Autowired
    WaterService waterService;
    @Autowired
    WaterRepository waterRepository;
    @Autowired
    UserMapping userMapping;
    @Autowired
    UserService userService;

    @GetMapping("/all")
    public List<Water_LevelDto> getAll(){
        return waterMapping.entitiesToDtoes(waterService.viewAll());
    }

    @GetMapping("/user_and_water")
    public List<Water_LevelDto> getByUserIdAndDate(@RequestParam String user, @RequestParam String date){
        return waterMapping.entitiesToDtoes(waterService.viewWaterGlassesByUserAndDate(user, date));
    }

}
