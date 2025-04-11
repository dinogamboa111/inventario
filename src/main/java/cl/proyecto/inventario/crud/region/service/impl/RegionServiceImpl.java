package cl.proyecto.inventario.crud.region.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import cl.proyecto.inventario.crud.region.dto.RegionDTO;
import cl.proyecto.inventario.crud.region.repository.RegionRepository;
import cl.proyecto.inventario.crud.region.service.IRegionService;

@Service
public class RegionServiceImpl implements IRegionService{

    @Autowired
    RegionRepository repo;

    @Override
    public RegionDTO insert(RegionDTO region) {
        // Inserta o actualiza el region
        return repo.save(region); // Guarda el region (si tiene ID, lo actualiza; si no, lo inserta)
    }


    @Override
    public RegionDTO getById(int id) {
        // Obtiene un region por su ID
        return repo.findById(id).orElse(null); // Retorna null si no se encuentra el region
    }
    @Override
    public List<RegionDTO> getAll() {
       // Obtiene todos los regions
       return (List<RegionDTO>) repo.findAll(); 
    }
    
    @Override
    public RegionDTO update(int id, RegionDTO region) {
        //Asigna el ID de la region para actualizar
        region.setIdRegion(id); // Actualiza el ID del region
        return repo.save(region); // Guarda el region actualizado
    }
    @Override
    public RegionDTO delete(int id) {
        // Obtiene el region antes de eliminarlo
        RegionDTO region = repo.findById(id).orElse(null);
        if (region != null) {
            // Elimina el procincia
            repo.deleteById(id);
        }
        return region; // Devuelve la region eliminado o null si no existía
    }

}
