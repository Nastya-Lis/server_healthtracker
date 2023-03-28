package bstu.by.lisunkova.server_healthtracker.model.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@IdClass(StepPK.class)
public class Step extends CommonEntity{
    @Id
    @Column(name = "user_id")
    private String userId;

    @Id
    @Column(name = "step_id_aka_date")
    private Date dateId;

    @Basic
    @Column(name = "fact_steps")
    private Integer factSteps;

    @Basic
    @Column(name = "plan_steps")
    private Integer planSteps;

    //@JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id",
            insertable = false,updatable = false, nullable = false)
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "term", referencedColumnName = "title", nullable = true)
    private Term term;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Step step = (Step) o;
        return userId.equals(step.userId) && dateId.equals(step.dateId) && Objects.equals(factSteps, step.factSteps) && Objects.equals(planSteps, step.planSteps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), userId, dateId, factSteps, planSteps);
    }
}
