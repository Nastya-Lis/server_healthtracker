package bstu.by.lisunkova.server_healthtracker.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "water_level", schema = "dbo", catalog = "Steps")
@IdClass(WaterLevelPK.class)
public class WaterLevel extends CommonEntity{
    @Id
    @Column(name = "data_id")
    private Date dataId;

    @Id
    @Column(name = "user_id")
    private String userId;

    @Basic
    @Column(name = "amount_plan")
    private Integer amountPlan;

    @Basic
    @Column(name = "amount_fact")
    private Integer amountFact;

    @Basic
    @Column(name = "measure")
    private String measure;


   // @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id",
            insertable = false,updatable = false,nullable = false)
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WaterLevel that = (WaterLevel) o;
        return Objects.equals(dataId, that.dataId) && Objects.equals(userId, that.userId) && Objects.equals(amountPlan, that.amountPlan) && Objects.equals(amountFact, that.amountFact) && Objects.equals(measure, that.measure);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dataId, userId, amountPlan, amountFact, measure);
    }

   /*
    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }*/
}
