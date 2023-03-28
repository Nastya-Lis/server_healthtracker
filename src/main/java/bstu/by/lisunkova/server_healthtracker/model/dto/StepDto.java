package bstu.by.lisunkova.server_healthtracker.model.dto;

import bstu.by.lisunkova.server_healthtracker.model.entity.Term;
import bstu.by.lisunkova.server_healthtracker.model.entity.User;
import lombok.Data;

import java.sql.Date;


@Data
public class StepDto extends ParticularDto{
    private String userId;
    private Date dateId;
    private Integer factSteps;
    private Integer planSteps;
    private String user;
    private String termTitle;
}
