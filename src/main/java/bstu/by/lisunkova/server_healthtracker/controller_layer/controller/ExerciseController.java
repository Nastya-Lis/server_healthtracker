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
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

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

  /*  @GetMapping("all_pagination")
    public List<ExerciseDto> getAllExerciseByPage(@RequestParam int page, @RequestParam int size){
        Pageable pgRequest = PageRequest.of(page,size);
        return exerciseMapping.entitiesToDtoes(exerciseService.viewAllByPage(pgRequest));
    }*/

    @PostMapping("add_fav")
    public void addNewFavouriteExercise(@RequestParam String user,@RequestParam String exercise){
        exerciseService.addNewFavExerciseToUser(user, exercise);
    }

}
