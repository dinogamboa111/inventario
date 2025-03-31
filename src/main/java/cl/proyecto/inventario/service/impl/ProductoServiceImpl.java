package cl.proyecto.inventario.service.impl;

import org.springframework.stereotype.Service;

import cl.proyecto.inventario.dto.ProductoDTO;

import cl.proyecto.inventario.service.IProductoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


// aqui esta la implementacion real que mostramos en la interface, estaria la logica real
//para manejar productos, usaremo de momento una lista en memoria para simular la bbdd
    
    
    @Service  //esta clase es un servicio , aqui estaria declarandoce ese hecho
public class ProductoServiceImpl implements IProductoService{

    private List<ProductoDTO> lProductos = new ArrayList<>(); 
    private Long idAutProducto = 1L; //contador para ids automaticas el L despues del 1
                                    // nos dice que es un dato de tipo Long no int
    @Override
    public List<ProductoDTO> obtenerTodos() {
        return lProductos; // retorna todos los productos de una lista
    }

    @Override
    public ProductoDTO obtenerPorId(Long id) {
        return lProductos.stream() // recorre la lista
                .filter(p -> p.getId().equals(id)) // filtra por id
                .findFirst() // bbtiene el primer resultado 
                .orElse(null); // si no hay retorna null
    }
    @Override
    public ProductoDTO guardar(ProductoDTO productoDTO) {
        productoDTO.setId(idAutProducto++); // asigna un id unico al producto
        lProductos.add(productoDTO); // agrega el producto a la lista
        return productoDTO; // retorna el producto q se guardo, apunta al q mencionamos en el metodo
    }
    @Override
    public ProductoDTO actualizar(Long id, ProductoDTO productoDTO) {
        Optional<ProductoDTO> productoExistente = lProductos.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst(); // busca producto por id, da el primer resultado q encuentra

        if (productoExistente.isPresent()) {
            ProductoDTO producto = productoExistente.get();
            producto.setNombre(productoDTO.getNombre());
            producto.setDescripcion(productoDTO.getDescripcion());
            producto.setStock(productoDTO.getStock());
            producto.setPrecioCompra(productoDTO.getPrecioCompra());
            producto.setPrecioVenta(productoDTO.getPrecioVenta());
            producto.setEstado(productoDTO.isEstado());
            return producto; // rtorna el producto actualizado
        }
        return null; // retorna null si  no existe
    }
    @Override
    public boolean eliminar(Long id) {
        return lProductos.removeIf(p -> p.getId().equals(id)); // elimina si encuentra el id

}

}//comentario pa q no se me pierda la ultima llave XD