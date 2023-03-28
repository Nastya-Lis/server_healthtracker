package bstu.by.lisunkova.server_healthtracker.model.dto;

import bstu.by.lisunkova.server_healthtracker.model.entity.User;
import lombok.Data;

import java.util.Set;


@Data
public class ExerciseDto extends CommonDto{
    //private String id;
    private int calories;
    private Set<String> users;
}
