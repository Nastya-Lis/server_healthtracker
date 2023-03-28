package bstu.by.lisunkova.server_healthtracker.controller_layer.mapping;


import bstu.by.lisunkova.server_healthtracker.model.dto.StepDto;
import bstu.by.lisunkova.server_healthtracker.model.dto.TermDto;
import bstu.by.lisunkova.server_healthtracker.model.entity.Step;
import bstu.by.lisunkova.server_healthtracker.model.entity.Term;
import bstu.by.lisunkova.server_healthtracker.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.HashSet;
import java.util.Set;

@Mapper(componentModel = "spring", uses = {StepMapping.class})
public interface TermMapping extends CommonMapping<Term, TermDto> {

    @Mapping(target = "steps", source = "dto.steps", qualifiedByName = "dToEntity")
    Term dtoToEntity(TermDto dto);

    @Mapping(target = "steps", source = "entity.steps", qualifiedByName = "eToDto")
    TermDto entityToDto(Term entity);

    @Named("dToEntity")
    default Set<Step> dToStep(Set<StepDto> dtos){
        Set<Step> steps = new HashSet<>();
        Step step = new Step();
        for(StepDto dto: dtos){
            Term term = new Term();
            User user = new User();
            term.setTitle(dto.getTermTitle());
            user.setId(dto.getUser());

            step.setUserId(dto.getUserId());
            step.setDateId(dto.getDateId());
            step.setFactSteps(dto.getFactSteps());
            step.setPlanSteps(dto.getPlanSteps());
            step.setTerm(term);
            //step.getTerm().setTitle(dto.getTermTitle());
            step.setUser(user);
            //step.setUser();
            steps.add(step);
        }
        return steps;
    }

    @Named("eToDto")
    default Set<StepDto> eToDto(Set<Step> steps){
        Set<StepDto> dtos = new HashSet<>();
        StepDto dto = new StepDto();
        for(Step step: steps){
            dto.setUserId(step.getUserId());
            dto.setDateId(step.getDateId());
            dto.setFactSteps(step.getFactSteps());
            dto.setPlanSteps(step.getPlanSteps());
            dto.setTermTitle(step.getTerm().getTitle());
            dto.setUser(step.getUser().getId());
            dtos.add(dto);
        }
        return dtos;
    }

}
