package bstu.by.lisunkova.server_healthtracker.controller_layer.mapping;


import bstu.by.lisunkova.server_healthtracker.model.dto.StatusWalkDto;
import bstu.by.lisunkova.server_healthtracker.model.entity.StatusWalk;
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
public interface StatusWalkMapping extends CommonMapping<StatusWalk, StatusWalkDto> {

    @Mapping(target = "users", source = "dto.users", qualifiedByName = "idToEntity")
    StatusWalk dtoToEntity(StatusWalkDto dto);


    @Mapping(target = "users", source = "entity.users", qualifiedByName = "entityToId")
    StatusWalkDto entityToDto(StatusWalk entity);

    @Named("entityToId")
    default Set<String> entitiesToId(Set<User> userSet)
    {
        return userSet.stream().map(User::getId).collect(Collectors.toSet());
    }

    @Named("idToEntity")
    default Set<User> idToEntities(Set<String> ids){
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
