package cl.proyecto.inventario.crud.detallePedido.service;

import java.util.List;

import cl.proyecto.inventario.crud.detallePedido.dto.DetallePedidoDTO;

public interface IDetallePedidoService {
    DetallePedidoDTO insert(DetallePedidoDTO detallePedido); // Inserta un nuevo detallePedido
    DetallePedidoDTO update(int id, DetallePedidoDTO detallePedido); // Actualiza un detallePedido por su ID
    DetallePedidoDTO delete(int id); // Elimina un detallePedido por su ID
    DetallePedidoDTO getById(int id); // Obtiene un detallePedido por su ID
    List<DetallePedidoDTO> getAll(); // Obtiene todos los detallePedidos

}
