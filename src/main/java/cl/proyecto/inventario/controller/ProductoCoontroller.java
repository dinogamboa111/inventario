package cl.proyecto.inventario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.proyecto.inventario.dto.ProductoDTO;
import cl.proyecto.inventario.service.IProductoService;


@RestController // aca indicamos que es un controlador REST
@RequestMapping("/api/productos") // ruta del api

public class ProductoCoontroller {

    @Autowired // inyecta el servicio
    private IProductoService productoService;

    //creacion manual sin Autowired, aun no lo entiendo bn
    //public class ProductoController {
  //  private ProductoService productoService = new ProductoServiceImpl(); // Creación manual
//}

     @GetMapping
    public List<ProductoDTO> obtenerTodos() {
        return productoService.obtenerTodos();
    }

     @GetMapping("/{id}")
    public ResponseEntity<ProductoDTO> obtenerPorId(@PathVariable Long id) {
        ProductoDTO producto = productoService.obtenerPorId(id);
        return producto != null ? ResponseEntity.ok(producto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<ProductoDTO> guardar(@RequestBody ProductoDTO productoDTO) {
        ProductoDTO nuevoProducto = productoService.guardar(productoDTO);
        return ResponseEntity.ok(nuevoProducto);
    }


     @PutMapping("/{id}")
    public ResponseEntity<ProductoDTO> actualizar(@PathVariable Long id, @RequestBody ProductoDTO productoDTO) {
        ProductoDTO productoActualizado = productoService.actualizar(id, productoDTO);
        return productoActualizado != null ? ResponseEntity.ok(productoActualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        return productoService.eliminar(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
