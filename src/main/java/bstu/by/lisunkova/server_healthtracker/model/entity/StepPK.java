package bstu.by.lisunkova.server_healthtracker.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class StepPK implements Serializable {

    @Column(name = "user_id")
    @Id
    private String userId;
    @Column(name = "step_id_aka_date")
    @Id
    private Date dateId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StepPK stepPK = (StepPK) o;
        return userId.equals(stepPK.userId) && dateId.equals(stepPK.dateId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, dateId);
    }
}
