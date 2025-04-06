package cl.proyecto.inventario.crud.detalleproducto.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "DetalleProducto")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class DetalleProductoDTO {

    @Id
    @Column(name = "id_detalle")
    private Long idDetalle;

    
    private Long idPedido;  

   
    private Long idProducto;

    private int cantidad;

    private double precio;
}
