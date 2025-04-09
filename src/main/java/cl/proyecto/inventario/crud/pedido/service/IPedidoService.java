package cl.proyecto.inventario.crud.pedido.service;

import java.util.List;
import cl.proyecto.inventario.crud.pedido.dto.PedidoDTO;

public interface IPedidoService {

    PedidoDTO insert(PedidoDTO pedido);
    PedidoDTO update(int id, PedidoDTO pedido);
    PedidoDTO delete(int id);
    PedidoDTO getById(int id);
    List<PedidoDTO> getAll();
}
