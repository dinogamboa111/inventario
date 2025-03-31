package cl.proyecto.inventario.service;

import java.util.List;

import cl.proyecto.inventario.dto.ProductoDTO;

public interface IProductoService {

    //obtiene todos los productos/lista
    List<ProductoDTO> obtenerTodos();
    
    // oobtiene un producto llamandolo por la id
    ProductoDTO obtenerPorId(Long id);

    //guarda la creacion de un nuevo producto(create)
    ProductoDTO guardar(ProductoDTO productoDTO);

    //actualiza un producto
    ProductoDTO actualizar(Long id, ProductoDTO productoDTO);

    //elimina
    boolean eliminar(Long id);

}
