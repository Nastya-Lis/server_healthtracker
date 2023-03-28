package bstu.by.lisunkova.server_healthtracker.model.dto;

import bstu.by.lisunkova.server_healthtracker.model.entity.User;
import lombok.Data;
import java.sql.Date;


@Data
public class Water_LevelDto extends ParticularDto{
    private String userId;
    private Date dataId;
    private Integer amountPlan;
    private Integer amountFact;
    private String measure;
   private String user;
}
