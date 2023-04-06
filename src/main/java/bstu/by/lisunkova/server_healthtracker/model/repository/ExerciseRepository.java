package bstu.by.lisunkova.server_healthtracker.model.repository;


import bstu.by.lisunkova.server_healthtracker.model.entity.Exercise;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExerciseRepository extends IRepository<Exercise> {
    @Query(value = "select * from exercise \n" +
            " join favorite_exercise fav on fav.exercise_id = exercise.id\n" +
            " join user_profile us on fav.user_id = us.id\n" +
            " where us.id =:user", nativeQuery = true)
    List<Exercise> favouritesUserExercises(String user);


    @Modifying
    @Query(nativeQuery = true, value = "call fav_for_user_add(:user_id,:exercise_id)")
    void addFavouriteExerciseToUser(@Param("user_id") String user,@Param("exercise_id") String exercise);

}
