package bstu.by.lisunkova.server_healthtracker.model.service;


import bstu.by.lisunkova.server_healthtracker.model.entity.Exercise;
import bstu.by.lisunkova.server_healthtracker.model.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseService extends CommonService<Exercise, ExerciseRepository>{

    @Autowired
    ExerciseService(ExerciseRepository repository){super(repository);}

    public List<Exercise> getFavouritesExercisesUser(String user){
        return repository.favouritesUserExercises(user);
    }
}
