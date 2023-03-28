package bstu.by.lisunkova.server_healthtracker.model.repository;


import bstu.by.lisunkova.server_healthtracker.model.entity.WaterLevel;
import bstu.by.lisunkova.server_healthtracker.model.entity.WaterLevelPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WaterRepository extends JpaRepository<WaterLevel, WaterLevelPK> {
    @Override
    List<WaterLevel> findAll();


    //amount of water that user has in concrete date
    @Query(value = "select * from water_level \n" +
            "  join user_profile us on us.id = water_level.user_id\n" +
            "  where water_level.data_id =:date and water_level.user_id =:user_id ",
            nativeQuery = true)
    List<WaterLevel> findWaterLevelByUserAndDate(String user_id, String date);
}
