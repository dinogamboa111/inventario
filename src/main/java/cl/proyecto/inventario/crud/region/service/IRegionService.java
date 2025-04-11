package cl.proyecto.inventario.crud.region.service;

import java.util.List;

import cl.proyecto.inventario.crud.region.dto.RegionDTO;

public interface IRegionService {

    RegionDTO insert( RegionDTO region); // Inserta un nuevo region
    RegionDTO update(int id,  RegionDTO region); // Actualiza un region por su ID
    RegionDTO delete(int id); // Elimina un region por su ID
    RegionDTO getById(int id); // Obtiene un region por su ID
    List< RegionDTO> getAll(); // Obtiene todos los regions
}

