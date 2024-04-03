package org.example.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "usuarios", schema = "public", catalog = "AccDatJPA")
public class UsuariosJPAEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idUsuario", nullable = false)
    private int idUsuario;
    @Basic
    @Column(name = "nombre", nullable = true, length = 48)
    private String nombre;

    private Date fechaCimpleanyos;
    @Column(name = "fechaCimpleanyos", nullable = true)


    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsuariosJPAEntity that = (UsuariosJPAEntity) o;

        if (idUsuario != that.idUsuario) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idUsuario;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        return result;
    }
}
