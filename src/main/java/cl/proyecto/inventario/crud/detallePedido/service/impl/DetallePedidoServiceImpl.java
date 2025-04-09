package cl.proyecto.inventario.crud.detallepedido.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.proyecto.inventario.crud.detallepedido.dto.DetallePedidoDTO;
import cl.proyecto.inventario.crud.detallepedido.repository.DetallePedidoRepository;
import cl.proyecto.inventario.crud.detallepedido.service.IDetallePedidoService;


@Service
public class DetallePedidoServiceImpl implements IDetallePedidoService {

    @Autowired
    DetallePedidoRepository repo;
    @Override
    public DetallePedidoDTO insert(DetallePedidoDTO detallePedido) {
         // Inserta o actualiza el detallePedido
         return repo.save(detallePedido); // Guarda el detallePedido (si tiene ID, lo actualiza; si no, lo inserta)
    }
    @Override
    public DetallePedidoDTO getById(int id) {
        // Obtiene un detallePedido por su ID
        return repo.findById(id).orElse(null); // Retorna null si no se encuentra el detallePedido
    }
    @Override
    public List<DetallePedidoDTO> getAll() {
        /// Obtiene todos los detallePedidos
        return (List<DetallePedidoDTO>) repo.findAll(); 
    }
    @Override
    public DetallePedidoDTO update(int id, DetallePedidoDTO detallePedido) {
         // Asigna el ID del detallePedido para actualizar
         detallePedido.setIdPedido(id); // Actualiza el ID del detallePedido
         return repo.save(detallePedido); // Guarda el detallePedido actualizado
    }
    @Override
    public DetallePedidoDTO delete(int id) {
        // Obtiene el detallePedido antes de eliminarlo
        DetallePedidoDTO detallePedido = repo.findById(id).orElse(null);
        if (detallePedido != null) {
            // Elimina el detallePedido
            repo.deleteById(id);
        }
        return detallePedido; // Devuelve el detallePedido eliminado o null si no existía
    }

}
