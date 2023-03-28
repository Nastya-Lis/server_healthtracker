package bstu.by.lisunkova.server_healthtracker.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "status_walk", schema = "dbo", catalog = "Steps")
public class StatusWalk extends CommonEntity{
//может быть вместо тайтла сделать привычный айдишник
    @Id
    @Column(name = "title")
    private String title;

//OneToMany for users
    //не уверена, что маппинг сработается с методом, но попробовать стоит
    @OneToMany(mappedBy = "statusWalkByStatus", cascade = CascadeType.ALL)
    private Set<User> users;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        StatusWalk that = (StatusWalk) o;
        return title.equals(that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), title);
    }
}
