package cl.proyecto.inventario.crud.comuna.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "comuna")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ComunaDTO {
    @Id
    @Column(name = "id_comuna")

    private int idComuna;

    private String nombreComuna;

    private int idProvincia;

}
