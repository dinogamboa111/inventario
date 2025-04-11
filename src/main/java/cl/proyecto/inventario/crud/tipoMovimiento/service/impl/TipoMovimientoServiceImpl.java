package cl.proyecto.inventario.crud.tipomovimiento.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.proyecto.inventario.crud.tipomovimiento.dto.TipoMovimientoDTO;

import cl.proyecto.inventario.crud.tipomovimiento.repository.TipoMovimientoRepository;
import cl.proyecto.inventario.crud.tipomovimiento.service.ITipoMovimientoService;

@Service
public class TipoMovimientoServiceImpl implements ITipoMovimientoService{

    @Autowired
    TipoMovimientoRepository repo;

    @Override
    public TipoMovimientoDTO insert(TipoMovimientoDTO tipomovimiento) {
        // Inserta o actualiza el tipomovimiento
        return repo.save(tipomovimiento); // Guarda el tipomovimiento (si tiene ID, lo actualiza; si no, lo inserta)
    }


    @Override
    public TipoMovimientoDTO getById(int id) {
        // Obtiene un tipomovimiento por su ID
        return repo.findById(id).orElse(null); // Retorna null si no se encuentra el tipomovimiento
    }
    @Override
    public List<TipoMovimientoDTO> getAll() {
       // Obtiene todos los tipomovimientos
       return (List<TipoMovimientoDTO>) repo.findAll(); 
    }
    
    @Override
    public TipoMovimientoDTO update(int id, TipoMovimientoDTO tipomovimiento) {
        //Asigna el ID de la tipomovimiento para actualizar
        tipomovimiento.setIdTipomovimiento(id); // Actualiza el ID del tipomovimiento
        return repo.save(tipomovimiento); // Guarda el tipomovimiento actualizado
    }
    @Override
    public TipoMovimientoDTO delete(int id) {
        // Obtiene el tipomovimiento antes de eliminarlo
        TipoMovimientoDTO tipomovimiento = repo.findById(id).orElse(null);
        if (tipomovimiento != null) {
            // Elimina el procincia
            repo.deleteById(id);
        }
        return tipomovimiento; // Devuelve la tipomovimiento eliminado o null si no existía
    }

}
