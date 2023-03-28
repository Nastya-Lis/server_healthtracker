package bstu.by.lisunkova.server_healthtracker.model.dto;


import bstu.by.lisunkova.server_healthtracker.model.entity.User;
import lombok.Data;

import java.util.Collection;

@Data
public class AchievementDto extends CommonDto {
    //private String id;
    private String title;
    private byte[] emblem;
    private String typeOfAchieve;
    private Collection<String> users;
}
