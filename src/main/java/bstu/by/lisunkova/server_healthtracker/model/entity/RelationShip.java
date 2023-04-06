package bstu.by.lisunkova.server_healthtracker.model.entity;

import javax.persistence.*;
import java.util.Objects;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class RelationShip extends CommonEntity {

    @Id
    @GeneratedValue
    private int id_but_deleted;

    private int friendStatus;


    @Basic
    @Column(name = "relation_status")
    public int getFriendStatus() {
        return friendStatus;
    }

    public void setFriendStatus(int friendStatus) {
        this.friendStatus = friendStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RelationShip friend = (RelationShip) o;
        return friendStatus == friend.friendStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(friendStatus);
    }
}
