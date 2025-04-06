package cl.proyecto.inventario.crud.producto.service;

import java.util.List;

import cl.proyecto.inventario.crud.producto.dto.ProductoDTO;

public interface IProductoService {

    ProductoDTO insert(ProductoDTO producto); // Inserta un nuevo producto
    ProductoDTO update(int id, ProductoDTO producto); // Actualiza un producto por su ID
    ProductoDTO delete(int id); // Elimina un producto por su ID
    ProductoDTO getById(int id); // Obtiene un producto por su ID
    List<ProductoDTO> getAll(); // Obtiene todos los productos
}