package cl.proyecto.inventario.crud.region.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import cl.proyecto.inventario.crud.region.dto.RegionDTO;
import cl.proyecto.inventario.crud.region.repository.RegionRepository;
import cl.proyecto.inventario.crud.region.service.IRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegionServiceImpl implements IRegionService {

    @Autowired
    private RegionRepository repository;

    @Override
    public List<RegionDTO> getAll() {
        return repository.findAll();
    }

    @Override
    public RegionDTO save(RegionDTO regionDTO) {
        // Verificar si ya existe el mismo ID
        if (repository.existsById(regionDTO.getId())) {
            // Si existe, lanzar una excepcion y retornar un mensaje
            throw new NoSuchElementException("El ID " + regionDTO.getId() + " ya existe.");
        }
        // Si no existe el id, guardarlo
        return repository.save(regionDTO);
    }

    // lista todos los datos
    @Override
    public RegionDTO getById(int id) {
        // Si no se encuentra el id, lanzamos una excepcion y un mensaje
        return repository.findById(id).orElseThrow(() -> new NoSuchElementException("Error:  ID " + id + " no encontrado"));
    }

    // Borra por ID
    @Override
    public void delete(int id) {
        // Si no se encuentra el id, lanzamos una excepcion y un mensaje
        if (!repository.existsById(id)) {
            throw new NoSuchElementException("Error: ID " + id + " no encontrado");
        }
        repository.deleteById(id);
    }

    // Actualiza por ID
    @Override
    public RegionDTO update(int id, RegionDTO regionDTO) {
        // Verificamos si el cliente existe antes de actualizarlo
        if (!repository.existsById(id)) {
            throw new NoSuchElementException("Error: ID " + id + " no encontrado");
        }
        regionDTO.setId(id); // Asignamos el ID recibido al DTO
        return repository.save(regionDTO);
    }
}