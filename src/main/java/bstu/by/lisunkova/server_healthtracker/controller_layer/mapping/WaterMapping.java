package bstu.by.lisunkova.server_healthtracker.controller_layer.mapping;


import bstu.by.lisunkova.server_healthtracker.model.dto.StepDto;
import bstu.by.lisunkova.server_healthtracker.model.dto.UserDto;
import bstu.by.lisunkova.server_healthtracker.model.dto.Water_LevelDto;
import bstu.by.lisunkova.server_healthtracker.model.entity.Step;
import bstu.by.lisunkova.server_healthtracker.model.entity.User;
import bstu.by.lisunkova.server_healthtracker.model.entity.WaterLevel;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {UserMapping.class})
public interface WaterMapping extends ParticularMapping<WaterLevel, Water_LevelDto> {

    WaterMapping INSTANCE = Mappers.getMapper(WaterMapping.class);
    @Mapping(target = "user", source = "dto.user", qualifiedByName = "intoUser")
  // @Mapping(target = "user", ignore = true)
    WaterLevel dtoToEntity(Water_LevelDto dto);

   @Mapping(target = "user", source = "entity.user", qualifiedByName = "intoUserId")
   //@Mapping(target = "user", ignore = true)
    Water_LevelDto entityToDto(WaterLevel entity);


  /*  @AfterMapping
    default void setUsersDto(@MappingTarget Water_LevelDto waterDto, WaterLevel water) {
        UserDto userDto = UserMapping.INSTANCE.entityToDto(water.getUser());
        waterDto.setUser(userDto);
    }


    @AfterMapping
    default void setUsersEntity(@MappingTarget Water_LevelDto waterDto, WaterLevel water) {
        User user = UserMapping.INSTANCE.dtoToEntity(waterDto.getUser());
        water.setUser(user);
    }*/

    @Named("intoUser")
    default User toUserEntity(String userId){
        User user = new User();
        user.setId(userId);
       return user;
    }


    @Named("intoUserId")
   default String toUserDto(User user){
       return user.getId();
}

}
