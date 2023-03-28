package bstu.by.lisunkova.server_healthtracker.model.dto;

import bstu.by.lisunkova.server_healthtracker.model.entity.*;
import lombok.Data;

import java.util.Collection;
import java.util.Set;


@Data
public class UserDto extends CommonDto{
   // private String id;
    private String login;
    private String password;
    private String email;
    private byte[] photo;
    private Set<AchievementDto> achievements;
    private Set<ExerciseDto> exercises;
    private Collection<StepDto> steps;
    private Set<Water_LevelDto> water_glasses;
    private StatusWalkDto statusWalk;
}
