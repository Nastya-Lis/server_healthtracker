package bstu.by.lisunkova.server_healthtracker.controller_layer.mapping;


import bstu.by.lisunkova.server_healthtracker.model.dto.ExerciseDto;
import bstu.by.lisunkova.server_healthtracker.model.entity.Exercise;
import bstu.by.lisunkova.server_healthtracker.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = {UserMapping.class})
public interface ExerciseMapping extends CommonMapping<Exercise, ExerciseDto>{

    @Mapping(target = "users", source = "dto.users",qualifiedByName = "idToEntity")
    Exercise dtoToEntity(ExerciseDto dto);

    @Mapping(target = "users", source = "entity.users", qualifiedByName = "entityToId")
    ExerciseDto entityToDto(Exercise entity);

    @Named("entityToId")
    default Set<String> entitiesToId(Set<User> userSet)
    {
        return userSet.stream().map(User::getId).collect(Collectors.toSet());
    }

    @Named("idToEntity")
    default Set<User> idsToEntities(Set<String> ids){
        Set<User> users = new HashSet<>();
        for (String id: ids){
            if(id != null){
                User user = new User();
                user.setId(id);
                users.add(user);
            }
        }
        return users;
    }
}
