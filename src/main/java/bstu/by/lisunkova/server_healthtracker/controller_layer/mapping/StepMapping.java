package bstu.by.lisunkova.server_healthtracker.controller_layer.mapping;


import bstu.by.lisunkova.server_healthtracker.model.dto.StepDto;
import bstu.by.lisunkova.server_healthtracker.model.entity.Step;
import bstu.by.lisunkova.server_healthtracker.model.entity.Term;
import bstu.by.lisunkova.server_healthtracker.model.entity.User;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {TermMapping.class, UserMapping.class})
public interface StepMapping extends ParticularMapping<Step, StepDto>{

    @Mappings({
            @Mapping(target = "term", source = "dto.termTitle", qualifiedByName = "dTitleToTerm"),
            @Mapping(target = "user", source = "dto.user", qualifiedByName = "toUser")
    })
    Step dtoToEntity(StepDto dto);

    @Mappings({
            @Mapping(target = "termTitle", source = "term", qualifiedByName = "eTermToTitle"),
            @Mapping(target = "user", source = "entity.user", qualifiedByName = "toUserId")
    })
    StepDto entityToDto(Step entity);

  /*  @AfterMapping
    default void setUsersDto(@MappingTarget StepDto stepDto, Step step) {
        UserDto userDto = UserMapping.INSTANCE.entityToDto(step.getUser());
        stepDto.setUser(userDto);
    }


    @AfterMapping
    default void setUsersEntity(@MappingTarget StepDto stepDto, Step step) {
        User user = UserMapping.INSTANCE.dtoToEntity(stepDto.getUser());
        step.setUser(user);
    }*/
    @Named("toUser")
    default User toEntityUser(String userId){
        User user = new User();
        user.setId(userId);
        return user;
    }

    @Named("toUserId")
    default String toDtoUser(User user){
        return user.getId();
    }

    @Named("dTitleToTerm")
    default Term toTerm(String title){
        Term term = new Term();
        if(title!=null){
            term.setTitle(title);
        }
        return term;
    }

    @Named("eTermToTitle")
    default String toTitle(Term term){
        return term!=null ? term.getTitle() : "";
    }

}
