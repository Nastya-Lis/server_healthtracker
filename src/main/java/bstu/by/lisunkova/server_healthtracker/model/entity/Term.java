package bstu.by.lisunkova.server_healthtracker.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Objects;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Term extends CommonEntity{

    @Id
    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "term")
    private Set<Step> steps;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Term term = (Term) o;
        return title.equals(term.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), title);
    }
}
