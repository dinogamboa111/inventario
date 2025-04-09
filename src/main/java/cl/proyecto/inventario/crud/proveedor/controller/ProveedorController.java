package cl.proyecto.inventario.crud.proveedor.controller;


import cl.proyecto.inventario.crud.proveedor.service.impl.ProveedorServiceImpl;

import cl.proyecto.inventario.crud.proveedor.dto.ProveedorDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/proveedores")
public class ProveedorController {

    @Autowired
    private ProveedorServiceImpl proveedorService;

  
    @PostMapping
    public ResponseEntity<ProveedorDTO> create(@RequestBody ProveedorDTO proveedor) {
        ProveedorDTO creado = proveedorService.insert(proveedor);
        return new ResponseEntity<>(creado, HttpStatus.CREATED);
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<ProveedorDTO> getById(@PathVariable int id) {
        ProveedorDTO proveedor = proveedorService.getById(id);
        if (proveedor != null) {
            return new ResponseEntity<>(proveedor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    
    @GetMapping
    public ResponseEntity<List<ProveedorDTO>> getAll() {
        List<ProveedorDTO> proveedores = proveedorService.getAll();
        return new ResponseEntity<>(proveedores, HttpStatus.OK);
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<ProveedorDTO> update(@PathVariable int id, @RequestBody ProveedorDTO proveedor) {
        ProveedorDTO actualizado = proveedorService.update(id, proveedor);
        if (actualizado != null) {
            return new ResponseEntity<>(actualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        ProveedorDTO eliminado = proveedorService.delete(id);
        if (eliminado != null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
