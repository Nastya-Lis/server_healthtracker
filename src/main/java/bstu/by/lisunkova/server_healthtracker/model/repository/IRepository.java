package bstu.by.lisunkova.server_healthtracker.model.repository;

import bstu.by.lisunkova.server_healthtracker.model.entity.CommonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface IRepository <E extends CommonEntity> extends JpaRepository<E,String> {
    @Override
    List<E> findAll();
}
