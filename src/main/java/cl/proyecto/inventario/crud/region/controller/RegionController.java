package cl.proyecto.inventario.crud.region.controller;

import cl.proyecto.inventario.crud.region.dto.RegionDTO;
import cl.proyecto.inventario.crud.region.service.IRegionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/region")
public class RegionController {
    @Autowired
    private IRegionService service;

    @GetMapping
    public List<RegionDTO> getAll() {
        return service.getAll();
    }

    @PostMapping
    public RegionDTO save(@RequestBody RegionDTO clienteDTO) {
        return service.save(clienteDTO);
    }

    @GetMapping("/{id}")
    public RegionDTO getById(@PathVariable int id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }


    @PutMapping("/{id}")
    public RegionDTO update(@PathVariable int id, @RequestBody RegionDTO regionDTO) {
    return service.update(id, regionDTO);
}
}
