package cl.proyecto.inventario.crud.proveedor.repository;

import cl.proyecto.inventario.crud.proveedor.dto.ProveedorDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepository extends CrudRepository<ProveedorDTO, Integer> {
}