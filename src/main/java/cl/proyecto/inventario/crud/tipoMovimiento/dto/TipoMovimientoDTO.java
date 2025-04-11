package cl.proyecto.inventario.crud.tipomovimiento.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tipomovimiento")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class TipoMovimientoDTO {
    @Id
    @Column(name = "id_tipomovimiento")

    private int idTipomovimiento;

    private String nombreTipomovimiento;


}
