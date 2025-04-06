package cl.proyecto.inventario.crud.cliente.service;

import java.util.List;

import cl.proyecto.inventario.crud.cliente.dto.ClienteDTO;

public interface IClienteService {

    ClienteDTO insert(ClienteDTO cliente); // Inserta un nuevo cliente
    ClienteDTO update(int rut, ClienteDTO cliente); // Actualiza un cliente por su ID
    ClienteDTO delete(int rut); // Elimina un cliente por su ID
    ClienteDTO getById(int rut); // Obtiene un cliente por su ID
    List<ClienteDTO> getAll(); // Obtiene todos los clientes

}

