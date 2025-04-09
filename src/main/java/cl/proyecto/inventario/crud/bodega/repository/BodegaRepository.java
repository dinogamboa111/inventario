package cl.proyecto.inventario.crud.bodega.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.proyecto.inventario.crud.bodega.dto.BodegaDTO;

@Repository
public interface BodegaRepository extends CrudRepository<BodegaDTO, Integer> {

}


