package bstu.by.lisunkova.server_healthtracker.model.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name ="user_profile")
public class User extends CommonEntity{
    @Id
    @Column(name = "id")
    private String id;
    @Basic
    @Column(name = "login")
    private String login;
    @Basic
    @Column(name = "password")
    private String password;

    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "photo")
    private byte[] photo;

    @ManyToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private Set<Achievement> achievements;

    @ManyToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private Set<Exercise> exercises;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Collection<Step> steps;

    @OneToMany(mappedBy = "user")
    private Set<WaterLevel> water_glasses;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "status", referencedColumnName = "title", nullable = false)
    private StatusWalk statusWalkByStatus;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return id.equals(user.id) && login.equals(user.login) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, login, email);
    }
}
