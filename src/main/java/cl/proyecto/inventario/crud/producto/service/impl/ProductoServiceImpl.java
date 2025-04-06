package cl.proyecto.inventario.crud.producto.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.proyecto.inventario.crud.producto.dto.ProductoDTO;
import cl.proyecto.inventario.crud.producto.repository.ProductoRepository;
import cl.proyecto.inventario.crud.producto.service.IProductoService;

@Service
public class ProductoServiceImpl implements IProductoService {

    @Autowired
    ProductoRepository repo;

    @Override
    public ProductoDTO insert(ProductoDTO producto) {
        
        return repo.save(producto); 
    }

    @Override
    public ProductoDTO update(int id, ProductoDTO producto) {
        
        producto.setIdProducto(id); 
        return repo.save(producto); 
    }

    @Override
    public ProductoDTO delete(int id) {
        
        ProductoDTO producto = repo.findById(id).orElse(null);
        if (producto != null) {
           
            repo.deleteById(id);
        }
        return producto; 
    }

    @Override
    public ProductoDTO getById(int id) {
        
        return repo.findById(id).orElse(null); 
    }

    @Override
    public List<ProductoDTO> getAll() {
        
        return (List<ProductoDTO>) repo.findAll(); 
    }
}
