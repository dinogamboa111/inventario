package cl.proyecto.inventario.crud.usuario.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "usuario")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UsuarioDTO {
    @Id
    @Column(name = "id_usuario")
    private int idUsuario;
    private String nombreUsuario;
    private String apellidoUsario;

    private String nombre_usuario;
    private String claveUsuario;


}