package cl.proyecto.inventario.crud.cliente.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.proyecto.inventario.crud.cliente.dto.ClienteDTO;

@Repository
public interface ClienteRepository extends CrudRepository<ClienteDTO, Integer> {

}

