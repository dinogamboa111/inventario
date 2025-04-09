package cl.proyecto.inventario.crud.categoria.controller;

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

import cl.proyecto.inventario.crud.categoria.dto.CategoriaDTO;
import cl.proyecto.inventario.crud.categoria.service.impl.CategoriaServiceImpl;

@RestController
@RequestMapping("api/categoria")
public class CategoriaController {
    @Autowired
    private CategoriaServiceImpl categoriaService;

    //crear nueva categoria
    @PostMapping
    public ResponseEntity<CategoriaDTO> create(@RequestBody CategoriaDTO categoria) {
        CategoriaDTO categoriaCreado = categoriaService.insert(categoria);
        return new ResponseEntity<>(categoriaCreado, HttpStatus.CREATED);
    }

    // obtener  categoria por ID
    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDTO> getById(@PathVariable int id) {
        CategoriaDTO categoria = categoriaService.getById(id);
        if (categoria != null) {
            return new ResponseEntity<>(categoria, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    
    // bbtener todos las categorias (listar)
    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> getAll() {
        List<CategoriaDTO> categorias = categoriaService.getAll();
        return new ResponseEntity<>(categorias, HttpStatus.OK);
    }

    //actualizar 
    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDTO> update(@PathVariable int id, @RequestBody CategoriaDTO categoria) {
        CategoriaDTO categoriaActualizado = categoriaService.update(id, categoria);
        if (categoriaActualizado != null) {
            return new ResponseEntity<>(categoriaActualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // eliminar 
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        CategoriaDTO categoria = categoriaService.delete(id);
        if (categoria != null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}

