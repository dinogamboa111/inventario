package cl.proyecto.inventario.crud.region.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.proyecto.inventario.crud.region.dto.RegionDTO;
@Repository
public interface RegionRepository extends CrudRepository<RegionDTO,Integer> {

}

