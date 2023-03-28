package bstu.by.lisunkova.server_healthtracker.controller_layer.mapping;


import bstu.by.lisunkova.server_healthtracker.model.dto.StepDto;
import bstu.by.lisunkova.server_healthtracker.model.dto.UserDto;
import bstu.by.lisunkova.server_healthtracker.model.dto.Water_LevelDto;
import bstu.by.lisunkova.server_healthtracker.model.entity.*;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Mapper(componentModel = "spring", uses = {
        AchievementMapping.class,
        ExerciseMapping.class,
        StatusWalkMapping.class,
        StepMapping.class,
        WaterMapping.class
})
public interface UserMapping extends CommonMapping<User, UserDto>{

    UserMapping INSTANCE = Mappers.getMapper(UserMapping.class);

    @Mappings({
           @Mapping(target = "steps", source = "dto.steps"/*, qualifiedByName = "dtoToStep"*/),
            @Mapping(target = "water_glasses", source = "dto.water_glasses"/*, qualifiedByName = "dtoToWater"*/),
         //   @Mapping(target = "steps", ignore = true),
           // @Mapping(target = "water_glasses", ignore = true),
            @Mapping(target = "statusWalkByStatus", source = "dto.statusWalk"),
            @Mapping(target = "achievements", source = "dto.achievements"),
            @Mapping(target = "exercises", source = "dto.exercises"),
    })
    User dtoToEntity(UserDto dto);

    @Mappings({
            //@Mapping(target = "steps", ignore = true),
            //@Mapping(target = "water_glasses", ignore = true),
            @Mapping(target = "steps", source = "entity.steps"/*, qualifiedByName = "stepToDto"*/),
            @Mapping(target = "water_glasses", source = "entity.water_glasses"/*, qualifiedByName = "waterToDto"*/),
            @Mapping(target = "statusWalk", source = "statusWalkByStatus"),
            @Mapping(target = "achievements", source = "entity.achievements"),
            @Mapping(target = "exercises", source = "entity.exercises"),
    })
    UserDto entityToDto(User entity);

 /*   @Named("dtoToStep")
    default Collection<Step> toStep(Collection<StepDto> dtos){
        Collection<Step> stepsFinal = new ArrayList<>();
        Step step = new Step();
        for (StepDto dto: dtos){
            step.setUserId(dto.getUserId());
            step.setDateId(dto.getDateId());
            step.setPlanSteps(dto.getPlanSteps());
            step.setFactSteps(dto.getFactSteps());
            step.getTerm().setTitle(dto.getTermTitle());
            step.setUser();
            stepsFinal.add(step);
        }
        return stepsFinal;
    }

    @Named("stepToDto")
    default Collection<StepDto> fromStepToDto(Collection<Step> steps){
        Collection<StepDto> dtoes = new ArrayList<>();
        StepDto dto = new StepDto();
        for(Step step: steps){
            dto.setUserId(step.getUserId());
            dto.setDateId(step.getDateId());
            dto.setFactSteps(step.getFactSteps());
            dto.setPlanSteps(step.getPlanSteps());
            dto.setTermTitle(step.getTerm().getTitle());
            dtoes.add(dto);
        }
        return dtoes;
    }

    @Named("dtoToWater")
    default Set<WaterLevel> toWater(Set<Water_LevelDto> dtos){
        Set<WaterLevel> glasses = new HashSet<>();
        WaterLevel glass = new WaterLevel();
        for (Water_LevelDto dto: dtos){
            glass.setUserId(dto.getUserId());
            glass.setDataId(dto.getDataId());
            glass.setAmountFact(dto.getAmountFact());
            glass.setAmountPlan(dto.getAmountPlan());
            glass.setMeasure(dto.getMeasure());
            glasses.add(glass);
        }
        return glasses;
    }

    @Named("waterToDto")
    default Set<Water_LevelDto> fromStepToDto(Set<WaterLevel> glasses){
        Set<Water_LevelDto> dtoes = new HashSet<>();
        Water_LevelDto dto = new Water_LevelDto();
        for(WaterLevel glass: glasses){
            dto.setUserId(glass.getUserId());
            dto.setDataId(glass.getDataId());
            dto.setAmountFact(glass.getAmountFact());
            dto.setAmountPlan(glass.getAmountPlan());
            dto.setMeasure(glass.getMeasure());
            dtoes.add(dto);
        }
        return dtoes;
    }*/



}
