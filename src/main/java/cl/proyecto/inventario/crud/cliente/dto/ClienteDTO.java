package cl.proyecto.inventario.crud.cliente.dto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cliente")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class ClienteDTO {
    @Id
    @Column(name = "run_cliente")

    private int rut;

    private String nombre;

    private String apellido;

    private String telefono;

    private String email;

    private String calle_direccion;

    private String num_direccion;

    private int idComuna;


}
