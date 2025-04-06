package cl.proyecto.inventario.crud.detalleproducto.service;

import java.util.List;
import cl.proyecto.inventario.crud.detalleproducto.dto.DetalleProductoDTO;

public interface IDetalleProductoService {

    DetalleProductoDTO insert(DetalleProductoDTO detalleProducto); 
    DetalleProductoDTO update(Long id, DetalleProductoDTO detalleProducto); 
    DetalleProductoDTO delete(Long id); 
    DetalleProductoDTO getById(Long id); 
    List<DetalleProductoDTO> getAll(); 
}