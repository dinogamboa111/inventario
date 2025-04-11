package cl.proyecto.inventario.crud.provincia.controller;

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

import cl.proyecto.inventario.crud.provincia.dto.ProvinciaDTO;
import cl.proyecto.inventario.crud.provincia.service.impl.ProvinciaServiceImpl;

@RestController
@RequestMapping("api/provincia")
public class ProvinciaController {

    @Autowired
    private ProvinciaServiceImpl provinciaService;

    // Crear nuevo provincia
    @PostMapping
    public ResponseEntity<ProvinciaDTO> create(@RequestBody ProvinciaDTO provincia) {
        ProvinciaDTO provinciaCreado = provinciaService.insert(provincia);
        return new ResponseEntity<>(provinciaCreado, HttpStatus.CREATED);
    }

    // obtener  provincia por ID
    @GetMapping("/{id}")
    public ResponseEntity<ProvinciaDTO> getById(@PathVariable int id) {
        ProvinciaDTO provincia = provinciaService.getById(id);
        if (provincia != null) {
            return new ResponseEntity<>(provincia, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // bbtener todas las provincia (listar)
    @GetMapping
    public ResponseEntity<List<ProvinciaDTO>> getAll() {
        List<ProvinciaDTO> provincias = provinciaService.getAll();
        return new ResponseEntity<>(provincias, HttpStatus.OK);
    }

    //actualizar 
    @PutMapping("/{id}")
    public ResponseEntity<ProvinciaDTO> update(@PathVariable int id, @RequestBody ProvinciaDTO provincia) {
        ProvinciaDTO provinciaActualizado = provinciaService.update(id, provincia);
        if (provinciaActualizado != null) {
            return new ResponseEntity<>(provinciaActualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // eliminar 
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        ProvinciaDTO provincia = provinciaService.delete(id);
        if (provincia != null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

