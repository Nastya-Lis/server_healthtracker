package bstu.by.lisunkova.server_healthtracker.model.repository;


import bstu.by.lisunkova.server_healthtracker.model.entity.Achievement;
import bstu.by.lisunkova.server_healthtracker.model.entity.StatusWalk;
import bstu.by.lisunkova.server_healthtracker.model.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends IRepository<User> {

    User findUserByStatusWalkByStatus(StatusWalk statusWalk);

    Collection<User> findUsersByAchievements(Achievement achievement);

    //users by name of achievement
    @Query(value = "select * from user_profile " +
            "join achievement_user au on au.id_user = user_profile.id " +
            "join achievement on au.id_achievement = achievement.id " +
            "where achievement.title =:title", nativeQuery = true)
    List<User> findUsersByAchievementTitle(String title);

    //user with certain status
    @Query(value = "select * from user_profile " +
            "join status_walk status on status.title = user_profile.status " +
            "where user_profile.status =:status", nativeQuery = true)
    List<User> findUsersByStatusWalkByStatus(String status);

    User findUsersById(String id);


}
