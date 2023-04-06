package bstu.by.lisunkova.server_healthtracker.model.repository;

import bstu.by.lisunkova.server_healthtracker.model.entity.CommonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.domain.Pageable;

import java.util.List;

@NoRepositoryBean
public interface IRepository<E extends CommonEntity> extends JpaRepository<E,String>
        ,PagingAndSortingRepository<E, String>
{
    @Override
    List<E> findAll();

 /*   default List<E> findAllPageable(Pageable pageable){
        return findAllPageable(pageable);
    };*/
}
