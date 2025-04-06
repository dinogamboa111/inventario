package cl.proyecto.inventario.crud.detalleproducto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import cl.proyecto.inventario.crud.detalleproducto.dto.DetalleProductoDTO;
import cl.proyecto.inventario.crud.detalleproducto.service.IDetalleProductoService;

@RestController
@RequestMapping("/detalleproducto")
public class DetalleProductoController {

    @Autowired
    private IDetalleProductoService service;

    @PutMapping("/{id}")
    public ResponseEntity<DetalleProductoDTO> update(@PathVariable Long id, @RequestBody DetalleProductoDTO detalleProducto) {
        DetalleProductoDTO detalleActualizado = service.update(id, detalleProducto);
        if (detalleActualizado != null) {
            return new ResponseEntity<>(detalleActualizado, HttpStatus.OK); 
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
        }
    }

    @PostMapping
    public ResponseEntity<DetalleProductoDTO> create(@RequestBody DetalleProductoDTO detalleProducto) {
        DetalleProductoDTO nuevoDetalle = service.insert(detalleProducto);
        return new ResponseEntity<>(nuevoDetalle, HttpStatus.CREATED); 
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        DetalleProductoDTO detalleProducto = service.delete(id);
        if (detalleProducto != null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleProductoDTO> getById(@PathVariable Long id) {
        DetalleProductoDTO detalleProducto = service.getById(id);
        if (detalleProducto != null) {
            return new ResponseEntity<>(detalleProducto, HttpStatus.OK); 
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
        }
    }

    @GetMapping
    public ResponseEntity<List<DetalleProductoDTO>> getAll() {
        List<DetalleProductoDTO> detalles = service.getAll();
        return new ResponseEntity<>(detalles, HttpStatus.OK); 
    }
}
