package io.swagger.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.swagger.entity.TruckEntity;

@Repository
public interface TrucksApiRepository extends CrudRepository<TruckEntity, Long>{

}
