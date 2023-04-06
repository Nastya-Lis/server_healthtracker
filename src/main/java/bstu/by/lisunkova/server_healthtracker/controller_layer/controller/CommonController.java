package bstu.by.lisunkova.server_healthtracker.controller_layer.controller;

import bstu.by.lisunkova.server_healthtracker.controller_layer.mapping.CommonMapping;
import bstu.by.lisunkova.server_healthtracker.model.dto.CommonDto;
import bstu.by.lisunkova.server_healthtracker.model.entity.CommonEntity;
import bstu.by.lisunkova.server_healthtracker.model.repository.IRepository;
import bstu.by.lisunkova.server_healthtracker.model.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

public class CommonController<E extends CommonEntity, R extends IRepository<E>,
        D extends CommonDto, S extends CommonService<E,R>, M extends CommonMapping<E,D>>{

    private final M mapper;
    private final S service;


    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    public CommonController(M mapper, S service){
        this.mapper = mapper;
        this.service = service;
    }

    @GetMapping("/all")
    public List<D> getAll(){
        return mapper.entitiesToDtoes(service.viewAll());
    }

   /* @GetMapping("/all_page")
    public List<D> getAllByPage(@RequestParam Integer page, @RequestParam Integer size){
        Pageable pgRequest = PageRequest.of(page,size);
        return mapper.entitiesToDtoes(service.viewAllByPage(pgRequest));
    }*/


    @GetMapping("/{id}")
    public Optional<D> getById(@PathVariable("id") String id){
        Optional<E> entity= service.findById(id);
        return entity.map(mapper::entityToDto);
    }


    @PostMapping
    public void save(@RequestBody @Valid D dto){
        service.addEntity(mapper.dtoToEntity(dto));
    }


    @PutMapping
    public void update(@RequestBody @Valid D dto){
        service.updateEntity(mapper.dtoToEntity(dto), dto.getId());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id){
        service.deleteEntity(id);
    }
}
