package cl.proyecto.inventario.crud.categoria.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.proyecto.inventario.crud.categoria.dto.CategoriaDTO;
import cl.proyecto.inventario.crud.categoria.repository.CategoriaRepository;
import cl.proyecto.inventario.crud.categoria.service.ICategoriaService;

@Service
public class CategoriaServiceImpl  implements ICategoriaService{
    
    @Autowired
    CategoriaRepository repo;
    @Override
    public CategoriaDTO insert(CategoriaDTO categoria) {
        // Inserta o actualiza la categoria
        return repo.save(categoria); // Guarda la categoria (si tiene ID, lo actualiza; si no, lo inserta)
    }
    
    
    @Override
    public CategoriaDTO getById(int id) {
         // Obtiene la categoria por su ID
         return repo.findById(id).orElse(null); // Retorna null si no se encuentra la categoria
    }
    @Override
    public CategoriaDTO update(int id, CategoriaDTO categoria) {
        // Asigna el ID de la categoria para actualizar
        categoria.setIdCategoria(id); // Actualiza el ID de la categoria
        return repo.save(categoria); // Guarda la categoria actualizado
    }
    @Override
    public CategoriaDTO delete(int id) {
        // Obtiene la categoria antes de eliminarlo
        CategoriaDTO categoria = repo.findById(id).orElse(null);
        if (categoria != null) {
            // Elimina la categoria
            repo.deleteById(id);
        }
        return categoria; // Devuelve el producto eliminado o null si no existía
    }
    @Override
    public List<CategoriaDTO> getAll() {
        // Obtiene todos las categorias
        return (List<CategoriaDTO>) repo.findAll(); 
    }

}


