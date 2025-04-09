package cl.proyecto.inventario.crud.proveedor.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Proveedor")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ProveedorDTO {

    @Id
    @Column(name = "id_proveedor")
    private int idProveedor;

    private String nombre;

    private String telefono;

    private String email;

    private String calleDireccion;

    private int numCalle;

    private int idComuna;
}