package cl.proyecto.inventario.crud.provincia.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.proyecto.inventario.crud.provincia.dto.ProvinciaDTO;
@Repository
public interface ProvinciaRepository extends CrudRepository<ProvinciaDTO,Integer> {

}

