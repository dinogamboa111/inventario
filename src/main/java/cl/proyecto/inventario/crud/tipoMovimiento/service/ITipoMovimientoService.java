package cl.proyecto.inventario.crud.tipomovimiento.service;

import java.util.List;

import cl.proyecto.inventario.crud.tipomovimiento.dto.TipomovimientoDTO;

public interface ITipomovimientoService {

    TipomovimientoDTO insert( TipomovimientoDTO tipomovimiento); // Inserta un nuevo provincia
    TipomovimientoDTO update(int id,  TipomovimientoDTO tipomovimiento); // Actualiza un provincia por su ID
    TipomovimientoDTO delete(int id); // Elimina un provincia por su ID
    TipomovimientoDTO getById(int id); // Obtiene un provincia por su ID
    List< TipomovimientoDTO> getAll(); // Obtiene todos los provincias
}
