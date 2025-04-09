package cl.proyecto.inventario.crud.proveedor.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.proyecto.inventario.crud.proveedor.dto.ProveedorDTO;
import cl.proyecto.inventario.crud.proveedor.repository.ProveedorRepository;
import cl.proyecto.inventario.crud.proveedor.service.IProveedorService;

@Service
public class ProveedorServiceImpl implements IProveedorService {

    @Autowired
    ProveedorRepository repo;

    @Override
    public ProveedorDTO insert(ProveedorDTO proveedor) {
        return repo.save(proveedor);
    }

    @Override
    public ProveedorDTO update(int id, ProveedorDTO proveedor) {
        // Verificar si el proveedor existe antes de actualizar
        if (repo.existsById(id)) {
            proveedor.setIdProveedor(id);  // Asigna el ID del proveedor para la actualización
            return repo.save(proveedor);   // Guarda el proveedor actualizado
        } else {
            return null;  // Si no existe, puedes devolver null o lanzar una excepción
        }
    }

    @Override
    public ProveedorDTO delete(int id) {
        // Verificar si el proveedor existe antes de eliminar
        ProveedorDTO proveedor = repo.findById(id).orElse(null);
        if (proveedor != null) {
            repo.deleteById(id);  // Elimina el proveedor
            return proveedor;      // Devuelve el proveedor eliminado
        }
        return null;  // Retorna null si no lo encuentra
    }

    @Override
    public ProveedorDTO getById(int id) {
        return repo.findById(id).orElse(null);  // Devuelve el proveedor si lo encuentra, de lo contrario, null
    }

    @Override
    public List<ProveedorDTO> getAll() {
        return (List<ProveedorDTO>) repo.findAll();  // Devuelve todos los proveedores
    }
}
