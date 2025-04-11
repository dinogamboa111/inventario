package cl.proyecto.inventario.crud.tipomovimiento.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.proyecto.inventario.crud.tipomovimiento.dto.TipoMovimientoDTO;

@Repository
public interface TipoMovimientoRepository extends CrudRepository<TipoMovimientoDTO,Integer> {

}
