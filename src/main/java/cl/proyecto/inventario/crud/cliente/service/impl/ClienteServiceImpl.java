package cl.proyecto.inventario.crud.cliente.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.proyecto.inventario.crud.cliente.dto.ClienteDTO;
import cl.proyecto.inventario.crud.cliente.repository.ClienteRepository;
import cl.proyecto.inventario.crud.cliente.service.IClienteService;

@Service
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    ClienteRepository repo;

    @Override
    public ClienteDTO insert(ClienteDTO cliente) {
        // Inserta o actualiza el cliente
        return repo.save(cliente); // Guarda el cliente (si tiene ID, lo actualiza; si no, lo inserta)
    }
    @Override
    public ClienteDTO getById(int rut) {
       // Obtiene un cliente por su ID
        return repo.findById(rut).orElse(null); // Retorna null si no se encuentra el producto
    }
    @Override
    public List<ClienteDTO> getAll() {
        // Obtiene todos los clientes
        return (List<ClienteDTO>) repo.findAll(); 
    }
    @Override
    public ClienteDTO update(int rut, ClienteDTO cliente) {
        // Asigna el ID del cliente para actualizar
        cliente.setRut(rut); // Actualiza el ID del cliente
        return repo.save(cliente); // Guarda el cliente actualizado
    }
    @Override
    public ClienteDTO delete(int rut) {
        // Obtiene el cliente antes de eliminarlo
        ClienteDTO cliente = repo.findById(rut).orElse(null);
        if (cliente != null) {
            // Elimina el cliente
            repo.deleteById(rut);
        }
        return cliente; // Devuelve el cliente eliminado o null si no existía
    }

}
