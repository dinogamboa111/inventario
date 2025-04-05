package cl.proyecto.inventario.crud.producto.controller;

import cl.proyecto.inventario.crud.producto.dto.ProductoDTO;
import cl.proyecto.inventario.crud.producto.service.impl.ProductoServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/productos")
public class ProductoController {

    @Autowired
    private ProductoServiceImpl productoService;

    // Crear nuevo producto
    @PostMapping
    public ResponseEntity<ProductoDTO> create(@RequestBody ProductoDTO producto) {
        ProductoDTO productoCreado = productoService.insert(producto);
        return new ResponseEntity<>(productoCreado, HttpStatus.CREATED);
    }

    // obtener  producto por ID
    @GetMapping("/{id}")
    public ResponseEntity<ProductoDTO> getById(@PathVariable int id) {
        ProductoDTO producto = productoService.getById(id);
        if (producto != null) {
            return new ResponseEntity<>(producto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // bbtener todos los productos (listar)
    @GetMapping
    public ResponseEntity<List<ProductoDTO>> getAll() {
        List<ProductoDTO> productos = productoService.getAll();
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

    //actualizar 
    @PutMapping("/{id}")
    public ResponseEntity<ProductoDTO> update(@PathVariable int id, @RequestBody ProductoDTO producto) {
        ProductoDTO productoActualizado = productoService.update(id, producto);
        if (productoActualizado != null) {
            return new ResponseEntity<>(productoActualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // eliminar 
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        ProductoDTO producto = productoService.delete(id);
        if (producto != null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
