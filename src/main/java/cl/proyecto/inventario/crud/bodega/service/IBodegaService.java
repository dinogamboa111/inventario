package cl.proyecto.inventario.crud.bodega.service;

import java.util.List;

import cl.proyecto.inventario.crud.bodega.dto.BodegaDTO;

public interface IBodegaService {

    BodegaDTO insert(BodegaDTO bodega); // Inserta un nuevo bodega
    BodegaDTO update(int id, BodegaDTO bodega); // Actualiza un bodega por su ID
    BodegaDTO delete(int id); // Elimina un bodega por su ID
    BodegaDTO getById(int id); // Obtiene un bodega por su ID
    List<BodegaDTO> getAll(); // Obtiene todos los bodegas
}




 