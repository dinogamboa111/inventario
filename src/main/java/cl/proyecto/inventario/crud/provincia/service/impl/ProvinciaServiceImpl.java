package cl.proyecto.inventario.crud.provincia.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.proyecto.inventario.crud.provincia.dto.ProvinciaDTO;
import cl.proyecto.inventario.crud.provincia.repository.ProvinciaRepository;
import cl.proyecto.inventario.crud.provincia.service.IProvinciaService;

@Service
public class ProvinciaServiceImpl implements IProvinciaService{

    @Autowired
    ProvinciaRepository repo;

    @Override
    public ProvinciaDTO insert(ProvinciaDTO provincia) {
        // Inserta o actualiza el provincia
        return repo.save(provincia); // Guarda el provincia (si tiene ID, lo actualiza; si no, lo inserta)
    }
    @Override
    public ProvinciaDTO getById(int id) {
        // Obtiene un provincia por su ID
        return repo.findById(id).orElse(null); // Retorna null si no se encuentra el provincia
    }
    @Override
    public List<ProvinciaDTO> getAll() {
       // Obtiene todos los provincias
       return (List<ProvinciaDTO>) repo.findAll(); 
    }
    
    @Override
    public ProvinciaDTO update(int id, ProvinciaDTO provincia) {
        //Asigna el ID de la provincia para actualizar
        provincia.setIdProvincia(id); // Actualiza el ID del provincia
        return repo.save(provincia); // Guarda el provincia actualizado
    }
    @Override
    public ProvinciaDTO delete(int id) {
        // Obtiene el provincia antes de eliminarlo
        ProvinciaDTO provincia = repo.findById(id).orElse(null);
        if (provincia != null) {
            // Elimina el procincia
            repo.deleteById(id);
        }
        return provincia; // Devuelve la provincia eliminado o null si no existía
    }

}
