package Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "USUARIOS")
public class Usuario {

     @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "persona_seq")
    @SequenceGenerator(name = "persona_seq", sequenceName = "persona_seq", allocationSize = 1)
    @Column(name = "ID_USUARIO")
    private Long idUsuario;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "APELLIDO")
    private String apellido;

    @Column(name = "EMAIL", unique = true)
    private String email;

    @Column(name = "CONTRASENNA")
    private String contrasenna;


    @Column(name = "ID_ROL")
    private Integer idRol;

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasenna() {
        return contrasenna;
    }

    public void setContrasena(String contrasena) {
        this.contrasenna = contrasena;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }
}