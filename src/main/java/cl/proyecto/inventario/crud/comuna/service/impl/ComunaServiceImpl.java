package cl.proyecto.inventario.crud.comuna.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cl.proyecto.inventario.crud.comuna.dto.ComunaDTO;
import cl.proyecto.inventario.crud.comuna.repository.ComunaRepository;
import cl.proyecto.inventario.crud.comuna.service.IComunaService;

public class ComunaServiceImpl implements IComunaService{

    @Autowired
    ComunaRepository repo;

    @Override
    public ComunaDTO insert(ComunaDTO comuna) {
        // Inserta o actualiza el comuna
        return repo.save(comuna); // Guarda el comuna (si tiene ID, lo actualiza; si no, lo inserta)
    }
    @Override
    public ComunaDTO getById(int id) {
        // Obtiene un comuna por su ID
        return repo.findById(id).orElse(null); // Retorna null si no se encuentra el comuna
    }
    @Override
    public List<ComunaDTO> getAll() {
       // Obtiene todos los comunas
       return (List<ComunaDTO>) repo.findAll(); 
    }
    
    @Override
    public ComunaDTO update(int id, ComunaDTO comuna) {
        //Asigna el ID del comuna para actualizar
        comuna.setIdComuna(id); // Actualiza el ID del comuna
        return repo.save(comuna); // Guarda el comuna actualizado
    }
    @Override
    public ComunaDTO delete(int id) {
        // Obtiene el comuna antes de eliminarlo
        ComunaDTO comuna = repo.findById(id).orElse(null);
        if (comuna != null) {
            // Elimina el comuna
            repo.deleteById(id);
        }
        return comuna; // Devuelve el comuna eliminado o null si no existía
    }

}

