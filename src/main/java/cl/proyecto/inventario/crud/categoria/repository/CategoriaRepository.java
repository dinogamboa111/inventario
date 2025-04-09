package cl.proyecto.inventario.crud.categoria.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.proyecto.inventario.crud.categoria.dto.CategoriaDTO;

@Repository
public interface CategoriaRepository extends CrudRepository<CategoriaDTO, Integer>{

}

