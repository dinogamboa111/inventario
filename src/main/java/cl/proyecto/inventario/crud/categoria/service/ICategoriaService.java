package cl.proyecto.inventario.crud.categoria.service;

import java.util.List;

import cl.proyecto.inventario.crud.categoria.dto.CategoriaDTO;

public interface ICategoriaService {

    CategoriaDTO insert(CategoriaDTO categoria); // Inserta un nuevo categoria
    CategoriaDTO update(int id, CategoriaDTO categoria); // Actualiza un categoria por su ID
    CategoriaDTO delete(int id); // Elimina un categoria por su ID
    CategoriaDTO getById(int id); // Obtiene un categoria por su ID
    List<CategoriaDTO> getAll(); // Obtiene todos los categorias

}

