package cl.proyecto.inventario.crud.comuna.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.proyecto.inventario.crud.comuna.dto.ComunaDTO;
@Repository
public interface ComunaRepository extends CrudRepository<ComunaDTO,Integer> {

}

