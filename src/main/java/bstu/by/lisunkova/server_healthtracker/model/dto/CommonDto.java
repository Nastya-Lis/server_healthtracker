package bstu.by.lisunkova.server_healthtracker.model.dto;

import lombok.Data;

import java.io.Serializable;


@Data
public abstract class CommonDto implements Serializable {
    private String id;
}
