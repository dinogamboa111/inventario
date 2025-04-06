package cl.proyecto.inventario.crud.bodega.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.proyecto.inventario.crud.bodega.dto.BodegaDTO;
import cl.proyecto.inventario.crud.bodega.service.impl.BodegaServiceImpl;

/*


 */
@RestController
@RequestMapping
public class BodegaController {
    @Autowired
    private BodegaServiceImpl bodegaService;

    //crear nueva bodega
    @PostMapping
    public ResponseEntity<BodegaDTO> create(@RequestBody BodegaDTO bodega) {
        BodegaDTO bodegaCreado = bodegaService.insert(bodega);
        return new ResponseEntity<>(bodegaCreado, HttpStatus.CREATED);
    }
    // obtener  producto por ID
    @GetMapping("/{id}")
    public ResponseEntity<BodegaDTO> getById(@PathVariable int id) {
    BodegaDTO bodega = bodegaService.getById(id);
    if (bodega != null) {
        return new ResponseEntity<>(bodega, HttpStatus.OK);
    } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

    // bbtener todos los productos (listar)
    @GetMapping
    public ResponseEntity<List<BodegaDTO>> getAll() {
      List<BodegaDTO> bodegas = bodegaService.getAll();
      return new ResponseEntity<>(bodegas, HttpStatus.OK);
  }

     //actualizar 
    @PutMapping("/{id}")
    //response entiti leva info de una repuesta http 
    //el body q te paso es una clase objeto bodegadto almacenasdo en una variable bodega
    public ResponseEntity<BodegaDTO> update(@PathVariable int id, @RequestBody BodegaDTO bodegas) {
    BodegaDTO bodegaActualizado = bodegaService.update(id, bodegas);
    if (bodegaActualizado != null) {
        return new ResponseEntity<>(bodegaActualizado, HttpStatus.OK);
    } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}


}

/*
 
    public class BodegaController {
    
 

    
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
 */