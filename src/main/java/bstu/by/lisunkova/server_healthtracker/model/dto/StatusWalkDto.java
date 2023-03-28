package bstu.by.lisunkova.server_healthtracker.model.dto;

import bstu.by.lisunkova.server_healthtracker.model.entity.User;
import lombok.Data;

import java.util.Set;


@Data
public class StatusWalkDto extends CommonDto{
    private String title;
    private Set<String> users;
}
