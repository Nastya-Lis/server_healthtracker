package bstu.by.lisunkova.server_healthtracker.controller_layer.mapping;


import bstu.by.lisunkova.server_healthtracker.model.dto.CommonDto;
import bstu.by.lisunkova.server_healthtracker.model.entity.CommonEntity;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;


public interface CommonMapping<E extends CommonEntity, D extends CommonDto> {
    E dtoToEntity(D dto);
    D entityToDto(E entity);

    default List<E> dtoesToEntities(List<D> dtoes) {
        ArrayList<E> entities = new ArrayList<>();
        for (D dto: dtoes) {
            entities.add(dtoToEntity(dto));
        }
        return entities;
    }

    default List<D> entitiesToDtoes(List<E> entities){
        ArrayList<D> dtoes = new ArrayList<>();
        for(E entity: entities){
            dtoes.add(entityToDto(entity));
        }
        return dtoes;
    }
}