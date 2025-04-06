package cl.proyecto.inventario.crud.pedido.dto;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Pedido")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PedidoDTO {

    @Id
    @Column(name = "id_pedido")
    private int idPedido;

    private int idCliente;

    private String fecha; //modificar ya q depende de clase date******************

    private int cantidad;

    private double total;

    private int idMovimiento;

    private int idUsuario;
}
