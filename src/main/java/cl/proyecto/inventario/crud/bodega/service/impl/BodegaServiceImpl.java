package cl.proyecto.inventario.crud.bodega.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.proyecto.inventario.crud.bodega.dto.BodegaDTO;
import cl.proyecto.inventario.crud.bodega.repository.BodegaRepository;
import cl.proyecto.inventario.crud.bodega.service.IBodegaService;

@Service
public class BodegaServiceImpl implements IBodegaService {

    @Autowired
    BodegaRepository repo;
    @Override
    public BodegaDTO insert(BodegaDTO bodega) {
       
        return repo.save(bodega); // Guarda el producto (si tiene ID, lo actualiza; si no, lo inserta)
    }
    @Override
    public BodegaDTO getById(int id) {
        // Obtiene un producto por su ID
        return repo.findById(id).orElse(null); // Retorna null si no se encuentra el producto
    }
    @Override
    public List<BodegaDTO> getAll() {
       
       // Obtiene todos los productos
       return (List<BodegaDTO>) repo.findAll(); 
    }
    @Override
    public BodegaDTO update(int id, BodegaDTO bodega) {
         // Asigna el ID del producto para actualizar
         bodega.setIdBodega(id); // Actualiza el ID del producto
         return repo.save(bodega); // Guarda el producto actualizado
    }
    @Override
    public BodegaDTO delete(int id) {
         // Obtiene el producto antes de eliminarlo
         BodegaDTO bodega = repo.findById(id).orElse(null);
         if (bodega != null) {
             // Elimina el producto
             repo.deleteById(id);
         }
         return bodega; // Devuelve la bodega  eliminado o null si no existía
    }

}

