package bstu.by.lisunkova.server_healthtracker.model.service;

import bstu.by.lisunkova.server_healthtracker.model.entity.CommonEntity;
import bstu.by.lisunkova.server_healthtracker.model.repository.IRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public abstract class CommonService <E extends CommonEntity, R extends IRepository> {

    protected final R repository;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    public CommonService(R repository){
        this.repository = repository;
    }

    public void addEntity(E entity){
        repository.save(entity);
    }

    public void deleteEntity(String id){
        repository.deleteById(id);
    }

    public List<E> viewAll(){
        return repository.findAll();
    }

    public void updateEntity(E entity,String id){
        repository.findById(id).ifPresent(entityFromDb ->{
            BeanUtils.copyProperties(entity,entityFromDb, id);
            repository.save(entityFromDb);
        });
    }

    public Optional<E> findById(String id){
        return repository.findById(id);
    }
}
