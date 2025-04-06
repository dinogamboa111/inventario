package cl.proyecto.inventario.crud.pedido.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import cl.proyecto.inventario.crud.pedido.dto.PedidoDTO;

@Repository
public interface PedidoRepository extends CrudRepository<PedidoDTO, Integer> {
}
