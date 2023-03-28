package bstu.by.lisunkova.server_healthtracker.model.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

@Setter
@Getter
@Entity
public class Achievement extends CommonEntity{

    @Id
    @Column(name = "id")
    private String id;

    @Basic
    @Column(name = "title")
    private String title;

    @Basic
    @Column(name = "emblem")
    private byte[] emblem;

    //TODO скорее всего придется заняться расширением типа, т.е достижение за бег,за время и т.д.
    @Basic
    @Column(name = "type_of_achieve")
    private String typeOfAchieve;


    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL )
    @JoinTable(
            name = "achievement_user",
            joinColumns = @JoinColumn(name = "id_achievement"),
            inverseJoinColumns = @JoinColumn(name = "id_user")

    )
    private Collection<User> users;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Achievement that = (Achievement) o;
        return id.equals(that.id) && Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, title);
    }
}
