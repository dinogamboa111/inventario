package cl.proyecto.inventario.crud.region.controller;

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

import cl.proyecto.inventario.crud.region.dto.RegionDTO;
import cl.proyecto.inventario.crud.region.service.impl.RegionServiceImpl;

@RestController
@RequestMapping("api/region")
public class RegionController {

    @Autowired
    private RegionServiceImpl regionService;

    // Crear nuevo region
    @PostMapping
    public ResponseEntity<RegionDTO> create(@RequestBody RegionDTO region) {
        RegionDTO regionCreado = regionService.insert(region);
        return new ResponseEntity<>(regionCreado, HttpStatus.CREATED);
    }

    // obtener  region por ID
    @GetMapping("/{id}")
    public ResponseEntity<RegionDTO> getById(@PathVariable int id) {
        RegionDTO region = regionService.getById(id);
        if (region != null) {
            return new ResponseEntity<>(region, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // bbtener todas las regions (listar)
    @GetMapping
    public ResponseEntity<List<RegionDTO>> getAll() {
        List<RegionDTO> regions = regionService.getAll();
        return new ResponseEntity<>(regions, HttpStatus.OK);
    }

    //actualizar 
    @PutMapping("/{id}")
    public ResponseEntity<RegionDTO> update(@PathVariable int id, @RequestBody RegionDTO region) {
        RegionDTO regionActualizado = regionService.update(id, region);
        if (regionActualizado != null) {
            return new ResponseEntity<>(regionActualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // eliminar 
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        RegionDTO region = regionService.delete(id);
        if (region != null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
