package cl.proyecto.inventario.crud.usuario.service;

import java.util.List;

import cl.proyecto.inventario.crud.usuario.dto.UsuarioDTO;

public interface IUsuarioService {

    UsuarioDTO insert( UsuarioDTO usuario); // Inserta un nuevo provincia
    UsuarioDTO update(int id,  UsuarioDTO usuario); // Actualiza un provincia por su ID
    UsuarioDTO delete(int id); // Elimina un provincia por su ID
    UsuarioDTO getById(int id); // Obtiene un provincia por su ID
    List< UsuarioDTO> getAll(); // Obtiene todos los provincias
}

