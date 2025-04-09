package cl.proyecto.inventario.crud.cliente.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cl.proyecto.inventario.crud.cliente.dto.ClienteDTO;
import cl.proyecto.inventario.crud.cliente.service.impl.ClienteServiceImpl;

import java.util.List;

@RestController
@RequestMapping("api/cliente")
public class ClienteController {
    @Autowired
    private ClienteServiceImpl clienteService;

    // Crear nuevo cliente
    @PostMapping
    public ResponseEntity<ClienteDTO> create(@RequestBody ClienteDTO cliente) {
        ClienteDTO clienteCreado = clienteService.insert(cliente);
        return new ResponseEntity<>(clienteCreado, HttpStatus.CREATED);
    }

    // obtener  cliente por rut
    @GetMapping("/{rut}")
    public ResponseEntity<ClienteDTO> getById(@PathVariable int rut) {
        ClienteDTO cliente = clienteService.getById(rut);
        if (cliente != null) {
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // bbtener todos los clientes (listar)
    @GetMapping
    public ResponseEntity<List<ClienteDTO>> getAll() {
        List<ClienteDTO> clientes = clienteService.getAll();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    //actualizar 
    @PutMapping("/{rut}")
    public ResponseEntity<ClienteDTO> update(@PathVariable int rut, @RequestBody ClienteDTO cliente) {
        ClienteDTO clienteActualizado = clienteService.update(rut, cliente);
        if (clienteActualizado != null) {
            return new ResponseEntity<>(clienteActualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // eliminar 
    @DeleteMapping("/{rut}")
    public ResponseEntity<Void> delete(@PathVariable int rut) {
        ClienteDTO cliente = clienteService.delete(rut);
        if (cliente != null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
