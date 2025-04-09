package cl.proyecto.inventario.crud.bodega.dto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Bodega")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BodegaDTO {

    @Id
    @Column(name = "id_bodega")

    private int idBodega;

    private String nombreBodega;

    private String calleDireccion;

    private int numCalle;

    private int idComuna;










}
