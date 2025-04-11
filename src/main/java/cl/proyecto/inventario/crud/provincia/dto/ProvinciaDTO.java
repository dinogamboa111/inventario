package cl.proyecto.inventario.crud.provincia.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "provincia")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ProvinciaDTO {
    @Id
    @Column(name = "id_provincia")

    private int idProvincia;

    private String nombreProvincia;

    private int idRegion;

}