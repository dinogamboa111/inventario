package cl.proyecto.inventario.crud.producto.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.proyecto.inventario.crud.producto.dto.ProductoDTO;

@Repository

public interface ProductoRepository extends CrudRepository<ProductoDTO,Integer>{

}
