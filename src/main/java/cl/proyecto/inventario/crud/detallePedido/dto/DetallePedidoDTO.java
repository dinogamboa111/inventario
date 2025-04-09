
package cl.proyecto.inventario.crud.detallepedido.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "detallepedido")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class DetallePedidoDTO {

    @Id
    @Column(name = "id_pedido")
    private int idPedido;
    
    private int idProducto;
    private int idDetalle;
    private int cantidad;
    private double precio;

}


