package bstu.by.lisunkova.server_healthtracker.model.dto;

import bstu.by.lisunkova.server_healthtracker.model.entity.User;
import lombok.Data;


@Data
public class FriendDto extends CommonDto{
    //private int id;
    private int status;
    //появится в будущем
    private UserDto friend1;
    private UserDto friend2;
}
