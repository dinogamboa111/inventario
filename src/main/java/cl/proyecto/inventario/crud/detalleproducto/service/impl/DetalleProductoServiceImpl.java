package cl.proyecto.inventario.crud.detalleproducto.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cl.proyecto.inventario.crud.detalleproducto.dto.DetalleProductoDTO;
import cl.proyecto.inventario.crud.detalleproducto.repository.DetalleProductoRepository;
import cl.proyecto.inventario.crud.detalleproducto.service.IDetalleProductoService;

@Service
public class DetalleProductoServiceImpl implements IDetalleProductoService {

    @Autowired
    private DetalleProductoRepository repo;

    @Override
    public DetalleProductoDTO insert(DetalleProductoDTO detalleProducto) {
        return repo.save(detalleProducto);
    }

    @Override
    public DetalleProductoDTO update(Long id, DetalleProductoDTO detalleProducto) {
        detalleProducto.setIdDetalle(id); // Establecer el ID del detalle para asegurarse de que se actualice
        return repo.save(detalleProducto); // Guardar el detalle actualizado
    }

    @Override
    public DetalleProductoDTO delete(Long id) {
        DetalleProductoDTO detalleProducto = repo.findById(id).orElse(null);
        if (detalleProducto != null) {
            repo.deleteById(id); // Eliminar el detalle de producto
        }
        return detalleProducto; // Retornar el detalle eliminado
    }

    @Override
    public DetalleProductoDTO getById(Long id) {
        return repo.findById(id).orElse(null); // Obtener un detalle de producto por ID
    }

    @Override
    public List<DetalleProductoDTO> getAll() {
        return (List<DetalleProductoDTO>) repo.findAll(); // Obtener todos los detalles de productos
    }
}
