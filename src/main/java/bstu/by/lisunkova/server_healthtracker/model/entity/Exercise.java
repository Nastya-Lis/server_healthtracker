package bstu.by.lisunkova.server_healthtracker.model.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;


@Setter
@Getter
@Entity
public class Exercise extends CommonEntity {
    @Id
    @Column(name = "id")
    private String id;
    @Basic
    @Column(name = "calories")
    private int calories;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(
            name = "favorite_exercise",
            joinColumns = @JoinColumn(name = "exercise_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")

    )
    private Set<User> users;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Exercise exercise = (Exercise) o;
        return calories == exercise.calories && id.equals(exercise.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, calories);
    }
}
