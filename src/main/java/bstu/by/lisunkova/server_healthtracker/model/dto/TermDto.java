package bstu.by.lisunkova.server_healthtracker.model.dto;

import bstu.by.lisunkova.server_healthtracker.model.entity.Step;
import lombok.Data;

import java.util.Set;

@Data
public class TermDto extends CommonDto{
    private String title;
    private Set<StepDto> steps;
}
