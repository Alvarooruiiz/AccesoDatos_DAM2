package com.example.examenapirestservidor.Modelo;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "usuarios", schema = "public", catalog = "PruebaFinalPrestamos")
public class UsuariosJPAEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_usuario", nullable = false)
    private int idUsuario;
    @Basic
    @Column(name = "nombre_usuario", nullable = true, length = 255)
    private String nombreUsuario;
    @Basic
    @Column(name = "email", nullable = true, length = 100)
    private String email;

    @OneToMany(mappedBy = "usuariosByIdUsuario")
    private Collection<PrestamosJPAEntity> prestamosByIdUsuario;


    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsuariosJPAEntity that = (UsuariosJPAEntity) o;

        if (idUsuario != that.idUsuario) return false;
        if (nombreUsuario != null ? !nombreUsuario.equals(that.nombreUsuario) : that.nombreUsuario != null)
            return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idUsuario;
        result = 31 * result + (nombreUsuario != null ? nombreUsuario.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    public Collection<PrestamosJPAEntity> getPrestamosByIdUsuario() {
        return prestamosByIdUsuario;
    }

    public void setPrestamosByIdUsuario(Collection<PrestamosJPAEntity> prestamosByIdUsuario) {
        this.prestamosByIdUsuario = prestamosByIdUsuario;
    }
}
