package cl.proyecto.inventario.crud.detallepedido.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.proyecto.inventario.crud.detallePedido.dto.DetallePedidoDTO;
import cl.proyecto.inventario.crud.detallePedido.service.impl.DetallePedidoServiceImpl;

@RestController
@RequestMapping("api/detallepedido")
public class DetallePedidoController {

    @Autowired
    private DetallePedidoServiceImpl detallePedidoService;
    

    // Crear nuevo detallePedido
    @PostMapping
    public ResponseEntity<DetallePedidoDTO> create(@RequestBody DetallePedidoDTO detallePedido) {
        DetallePedidoDTO detallePedidoCreado = detallePedidoService.insert(detallePedido);
        return new ResponseEntity<>(detallePedidoCreado, HttpStatus.CREATED);
    }

    // obtener  detallePedido por ID
    @GetMapping("/{id}")
    public ResponseEntity<DetallePedidoDTO> getById(@PathVariable int id) {
        DetallePedidoDTO detallePedido = detallePedidoService.getById(id);
        if (detallePedido != null) {
            return new ResponseEntity<>(detallePedido, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // bbtener todos los detallePedidos (listar)
    @GetMapping
    public ResponseEntity<List<DetallePedidoDTO>> getAll() {
        List<DetallePedidoDTO> detallePedidos = detallePedidoService.getAll();
        return new ResponseEntity<>(detallePedidos, HttpStatus.OK);
    }

    //actualizar 
    @PutMapping("/{id}")
    public ResponseEntity<DetallePedidoDTO> update(@PathVariable int id, @RequestBody DetallePedidoDTO detallePedido) {
        DetallePedidoDTO detallePedidoActualizado = detallePedidoService.update(id, detallePedido);
        if (detallePedidoActualizado != null) {
            return new ResponseEntity<>(detallePedidoActualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // eliminar 
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        DetallePedidoDTO detallePedido = detallePedidoService.delete(id);
        if (detallePedido != null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
/*



}

 */