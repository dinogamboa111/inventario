package cl.proyecto.inventario.crud.comuna.controller;

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

import cl.proyecto.inventario.crud.comuna.dto.ComunaDTO;
import cl.proyecto.inventario.crud.comuna.service.impl.ComunaServiceImpl;

@RestController
@RequestMapping("api/comuna")
public class ComunaController {

    @Autowired
    private ComunaServiceImpl comunaService;

    // Crear nuevo comuna
    @PostMapping
    public ResponseEntity<ComunaDTO> create(@RequestBody ComunaDTO comuna) {
        ComunaDTO comunaCreado = comunaService.insert(comuna);
        return new ResponseEntity<>(comunaCreado, HttpStatus.CREATED);
    }

    // obtener  comuna por ID
    @GetMapping("/{id}")
    public ResponseEntity<ComunaDTO> getById(@PathVariable int id) {
        ComunaDTO comuna = comunaService.getById(id);
        if (comuna != null) {
            return new ResponseEntity<>(comuna, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // bbtener todos los comunas (listar)
    @GetMapping
    public ResponseEntity<List<ComunaDTO>> getAll() {
        List<ComunaDTO> comunas = comunaService.getAll();
        return new ResponseEntity<>(comunas, HttpStatus.OK);
    }

    //actualizar 
    @PutMapping("/{id}")
    public ResponseEntity<ComunaDTO> update(@PathVariable int id, @RequestBody ComunaDTO comuna) {
        ComunaDTO comunaActualizado = comunaService.update(id, comuna);
        if (comunaActualizado != null) {
            return new ResponseEntity<>(comunaActualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // eliminar 
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        ComunaDTO comuna = comunaService.delete(id);
        if (comuna != null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

