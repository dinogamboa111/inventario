package cl.proyecto.inventario.crud.provincia.service;

import java.util.List;

import cl.proyecto.inventario.crud.provincia.dto.ProvinciaDTO;

public interface IProvinciaService {

    ProvinciaDTO insert(ProvinciaDTO provincia); // Inserta un nuevo provincia
    ProvinciaDTO update(int id, ProvinciaDTO provincia); // Actualiza un provincia por su ID
    ProvinciaDTO delete(int id); // Elimina un provincia por su ID
    ProvinciaDTO getById(int id); // Obtiene un provincia por su ID
    List<ProvinciaDTO> getAll(); // Obtiene todos los provincias
}

