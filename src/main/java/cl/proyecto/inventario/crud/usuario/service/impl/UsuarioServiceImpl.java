package cl.proyecto.inventario.crud.usuario.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import cl.proyecto.inventario.crud.usuario.dto.UsuarioDTO;
import cl.proyecto.inventario.crud.usuario.repository.UsuarioRepository;
import cl.proyecto.inventario.crud.usuario.service.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService{

    @Autowired
    UsuarioRepository repo;

    @Override
    public UsuarioDTO insert(UsuarioDTO usuario) {
        // Inserta o actualiza el usuario
        return repo.save(usuario); // Guarda el usuario (si tiene ID, lo actualiza; si no, lo inserta)
    }


    @Override
    public UsuarioDTO getById(int id) {
        // Obtiene un usuario por su ID
        return repo.findById(id).orElse(null); // Retorna null si no se encuentra el usuario
    }
    @Override
    public List<UsuarioDTO> getAll() {
       // Obtiene todos los usuarios
       return (List<UsuarioDTO>) repo.findAll(); 
    }
    
    @Override
    public UsuarioDTO update(int id, UsuarioDTO usuario) {
        //Asigna el ID de la usuario para actualizar
        usuario.setIdUsuario(id); // Actualiza el ID del usuario
        return repo.save(usuario); // Guarda el usuario actualizado
    }
    @Override
    public UsuarioDTO delete(int id) {
        // Obtiene el usuario antes de eliminarlo
        UsuarioDTO usuario = repo.findById(id).orElse(null);
        if (usuario != null) {
            // Elimina el procincia
            repo.deleteById(id);
        }
        return usuario; // Devuelve la usuario eliminado o null si no existía
    }

}
