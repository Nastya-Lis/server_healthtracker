package bstu.by.lisunkova.server_healthtracker.model.entity;

import javax.persistence.*;
import java.util.Objects;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Friend extends CommonEntity {

    @Id
    @GeneratedValue
    private int id_but_deleted;

    private int friendStatus;


    //TODO как-то захардкодить значения статуса, мб сделать enum значений
    @Basic
    @Column(name = "friend_status")
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
        Friend friend = (Friend) o;
        return friendStatus == friend.friendStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(friendStatus);
    }
}
