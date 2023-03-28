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
public class WaterLevelPK implements Serializable {
    @Column(name = "data_id")
    @Id
    private Date dataId;

    @Column(name = "user_id")
    @Id
    private String userId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WaterLevelPK that = (WaterLevelPK) o;
        return Objects.equals(dataId, that.dataId) && Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dataId, userId);
    }
}
