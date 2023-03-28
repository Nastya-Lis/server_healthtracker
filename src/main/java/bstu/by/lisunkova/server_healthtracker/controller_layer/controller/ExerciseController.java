package bstu.by.lisunkova.server_healthtracker.controller_layer.controller;


import bstu.by.lisunkova.server_healthtracker.controller_layer.mapping.AchievementMapping;
import bstu.by.lisunkova.server_healthtracker.controller_layer.mapping.ExerciseMapping;
import bstu.by.lisunkova.server_healthtracker.model.dto.AchievementDto;
import bstu.by.lisunkova.server_healthtracker.model.dto.ExerciseDto;
import bstu.by.lisunkova.server_healthtracker.model.entity.Exercise;
import bstu.by.lisunkova.server_healthtracker.model.repository.ExerciseRepository;
import bstu.by.lisunkova.server_healthtracker.model.service.AchievementService;
import bstu.by.lisunkova.server_healthtracker.model.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("exercises")
public class ExerciseController /*extends CommonController<Exercise, ExerciseRepository, ExerciseDto
        , ExerciseService, ExerciseMapping>*/{

    @Autowired
    ExerciseService exerciseService;

    @Autowired
    ExerciseMapping exerciseMapping;

    @GetMapping("favourites")
    public List<ExerciseDto> getFavouritesUserExercises(@RequestParam String user){
        return exerciseMapping.entitiesToDtoes(exerciseService.getFavouritesExercisesUser(user));
    }
}
