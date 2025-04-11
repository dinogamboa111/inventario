package cl.proyecto.inventario.crud.tipomovimiento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.proyecto.inventario.crud.tipomovimiento.dto.TipoMovimientoDTO;
import cl.proyecto.inventario.crud.tipomovimiento.service.impl.TipoMovimientoServiceImpl;

@RestController
@RequestMapping("api/tipomovimiento")
public class TipoMovimientoController {

    @Autowired
    private TipoMovimientoServiceImpl tipomovimientoService;

    // Crear nuevo tipomovimiento
    @PostMapping
    public ResponseEntity<TipoMovimientoDTO> create(@RequestBody TipoMovimientoDTO tipomovimiento) {
        TipoMovimientoDTO tipomovimientoCreado = tipomovimientoService.insert(tipomovimiento);
        return new ResponseEntity<>(tipomovimientoCreado, HttpStatus.CREATED);
    }

    // obtener  tipomovimiento por ID
    @GetMapping("/{id}")
    public ResponseEntity<TipoMovimientoDTO> getById(@PathVariable int id) {
        TipoMovimientoDTO tipomovimiento = tipomovimientoService.getById(id);
        if (tipomovimiento != null) {
            return new ResponseEntity<>(tipomovimiento, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // bbtener todas las tipomovimientos (listar)
    @GetMapping
    public ResponseEntity<List<TipoMovimientoDTO>> getAll() {
        List<TipoMovimientoDTO> tipomovimientos = tipomovimientoService.getAll();
        return new ResponseEntity<>(tipomovimientos, HttpStatus.OK);
    }

    //actualizar 
    @PutMapping("/{id}")
    public ResponseEntity<TipoMovimientoDTO> update(@PathVariable int id, @RequestBody TipoMovimientoDTO tipomovimiento) {
        TipoMovimientoDTO tipomovimientoActualizado = tipomovimientoService.update(id, tipomovimiento);
        if (tipomovimientoActualizado != null) {
            return new ResponseEntity<>(tipomovimientoActualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // eliminar 
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        TipoMovimientoDTO tipomovimiento = tipomovimientoService.delete(id);
        if (tipomovimiento != null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}