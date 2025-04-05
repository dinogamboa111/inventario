package cl.proyecto.inventario.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.proyecto.inventario.dto.ProductoDTO;
import cl.proyecto.inventario.repository.ProductoRepository;
import cl.proyecto.inventario.service.IProductoService;

@Service
public class ProductoServiceImpl implements IProductoService {

    @Autowired
    ProductoRepository repo;

    @Override
    public ProductoDTO insert(ProductoDTO producto) {
        // Inserta o actualiza el producto
        return repo.save(producto); // Guarda el producto (si tiene ID, lo actualiza; si no, lo inserta)
    }

    @Override
    public ProductoDTO update(int id, ProductoDTO producto) {
        // Asigna el ID del producto para actualizar
        producto.setIdProducto(id); // Actualiza el ID del producto
        return repo.save(producto); // Guarda el producto actualizado
    }

    @Override
    public ProductoDTO delete(int id) {
        // Obtiene el producto antes de eliminarlo
        ProductoDTO producto = repo.findById(id).orElse(null);
        if (producto != null) {
            // Elimina el producto
            repo.deleteById(id);
        }
        return producto; // Devuelve el producto eliminado o null si no existía
    }

    @Override
    public ProductoDTO getById(int id) {
        // Obtiene un producto por su ID
        return repo.findById(id).orElse(null); // Retorna null si no se encuentra el producto
    }

    @Override
    public List<ProductoDTO> getAll() {
        // Obtiene todos los productos
        return (List<ProductoDTO>) repo.findAll(); 
    }
}
