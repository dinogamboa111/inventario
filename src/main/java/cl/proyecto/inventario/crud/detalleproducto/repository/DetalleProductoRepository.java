package cl.proyecto.inventario.crud.detalleproducto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import cl.proyecto.inventario.crud.detalleproducto.dto.DetalleProductoDTO;

public interface DetalleProductoRepository extends JpaRepository<DetalleProductoDTO, Long> {

}
    