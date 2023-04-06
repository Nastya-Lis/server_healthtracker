package bstu.by.lisunkova.server_healthtracker.model.repository;


import bstu.by.lisunkova.server_healthtracker.model.entity.Step;
import bstu.by.lisunkova.server_healthtracker.model.entity.StepPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StepRepository extends JpaRepository<Step, StepPK>, PagingAndSortingRepository<Step,StepPK> {
    @Override
    List<Step> findAll();

    //steps which have same user and concrete date
    @Query(value = "select * from step\n" +
            "  join user_profile us on us.id = step.user_id\n" +
            "  where step.step_id_aka_date =:date and step.user_id =:user_id",
            nativeQuery = true)
    List<Step> findStepsByUserIdAndAndDateId(String user_id, String date);

    //steps for comparison between two users in concrete date
    @Query(value = "select * from step " +
            "join user_profile us on us.id = step.user_id " +
            "where step.step_id_aka_date =:date  " +
            "and (step.user_id =:user1 or step.user_id =:user2)", nativeQuery = true)
    List<Step> findStepsWithTwoUsersByDate(String user1, String user2, String date);
}
