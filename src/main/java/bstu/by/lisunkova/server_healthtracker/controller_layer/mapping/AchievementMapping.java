package bstu.by.lisunkova.server_healthtracker.controller_layer.mapping;

import bstu.by.lisunkova.server_healthtracker.model.dto.AchievementDto;
import bstu.by.lisunkova.server_healthtracker.model.entity.Achievement;
import bstu.by.lisunkova.server_healthtracker.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = {UserMapping.class})
public interface AchievementMapping extends CommonMapping<Achievement,AchievementDto> {

    @Mapping(target = "users", source = "dto.users", qualifiedByName = "idToEntity")
    Achievement dtoToEntity(AchievementDto dto);

    @Mapping(target = "users", source = "entity.users", qualifiedByName = "entityToId")
    AchievementDto entityToDto(Achievement entity);

    @Named("entityToId")
    default Collection<String> entitiesToId(Collection<User> userSet)
    {
        return userSet.stream().map(User::getId).collect(Collectors.toList());
    }

    //TODO как-то сделать проверку на нулл юзеров по существующему/несуществующему айди
    //todo не уверена, что все будет исправно работать из-за того,
    // что у юзера сосздается только айдишник, а не все оставшиеся поля...
    @Named("idToEntity")
    default Collection<User> idToEntities(Collection<String> ids){
        Collection<User> users = new ArrayList<>();
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
