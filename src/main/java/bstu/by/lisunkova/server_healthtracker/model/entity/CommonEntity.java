package bstu.by.lisunkova.server_healthtracker.model.entity;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

//хз нужен ли он вовсе
@Data
@MappedSuperclass
public abstract class CommonEntity implements Serializable {
}
