package cl.proyecto.inventario.crud.region.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "region")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class RegionDTO {
    @Id
    @Column(name = "id_region")

    private int idRegion;

    private String nombreRegion;


}