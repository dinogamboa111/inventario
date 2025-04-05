package cl.proyecto.inventario.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import cl.proyecto.inventario.dto.ProductoDTO;

@Repository

public interface ProductoRepository extends CrudRepository<ProductoDTO,Integer>{

}
