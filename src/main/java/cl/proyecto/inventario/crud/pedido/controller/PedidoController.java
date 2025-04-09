package cl.proyecto.inventario.crud.pedido.controller;

import cl.proyecto.inventario.crud.pedido.dto.PedidoDTO;
import cl.proyecto.inventario.crud.pedido.service.impl.PedidoServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoServiceImpl pedidoService;

    @PostMapping
    public ResponseEntity<PedidoDTO> create(@RequestBody PedidoDTO pedido) {
        PedidoDTO creado = pedidoService.insert(pedido);
        return new ResponseEntity<>(creado, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDTO> getById(@PathVariable int id) {
        PedidoDTO pedido = pedidoService.getById(id);
        if (pedido != null) {
            return new ResponseEntity<>(pedido, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<PedidoDTO>> getAll() {
        List<PedidoDTO> pedidos = pedidoService.getAll();
        return new ResponseEntity<>(pedidos, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoDTO> update(@PathVariable int id, @RequestBody PedidoDTO pedido) {
        PedidoDTO actualizado = pedidoService.update(id, pedido);
        if (actualizado != null) {
            return new ResponseEntity<>(actualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        PedidoDTO eliminado = pedidoService.delete(id);
        if (eliminado != null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
