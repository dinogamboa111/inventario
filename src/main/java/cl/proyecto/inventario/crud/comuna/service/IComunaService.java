package cl.proyecto.inventario.crud.comuna.service;

import java.util.List;

import cl.proyecto.inventario.crud.comuna.dto.ComunaDTO;

public interface IComunaService {

    ComunaDTO insert(ComunaDTO comuna); // Inserta un nuevo comuna
    ComunaDTO update(int id, ComunaDTO comuna); // Actualiza un comuna por su ID
    ComunaDTO delete(int id); // Elimina un comuna por su ID
    ComunaDTO getById(int id); // Obtiene un comuna por su ID
    List<ComunaDTO> getAll(); // Obtiene todos los comunas
}



