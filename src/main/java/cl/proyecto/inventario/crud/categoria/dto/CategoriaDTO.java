package cl.proyecto.inventario.crud.categoria.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "categoria")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CategoriaDTO {
    @Id
    @Column(name = "id_categoria")
    private int idCategoria;

    private String nombre;

    private String descripcionCategoria;


}


