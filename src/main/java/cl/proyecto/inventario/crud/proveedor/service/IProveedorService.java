package cl.proyecto.inventario.crud.proveedor.service;

import java.util.List;

import cl.proyecto.inventario.crud.proveedor.dto.ProveedorDTO;

public interface IProveedorService {

    ProveedorDTO insert(ProveedorDTO proveedor);
    ProveedorDTO update(int id, ProveedorDTO proveedor);
    ProveedorDTO delete(int id);
    ProveedorDTO getById(int id);
    List<ProveedorDTO> getAll();
}
