
package cl.proyecto.inventario.crud.detallepedido.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.proyecto.inventario.crud.detallepedido.dto.DetallePedidoDTO;

@Repository
public interface DetallePedidoRepository extends CrudRepository<DetallePedidoDTO, Integer> {

}




