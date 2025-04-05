package cl.proyecto.inventario.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Producto")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ProductoDTO {

    @Id
    @Column(name = "id_producto")

    private int idProducto;

    private String nombre;

    private String descripcion;

    private int stock;

    private double precioCompra;

    private double precioVenta;

    private String estado;

}

