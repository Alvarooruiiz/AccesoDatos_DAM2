package com.example.examenapirestservidor.Modelo;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "prestamos", schema = "public", catalog = "PruebaFinalPrestamos")
public class PrestamosJPAEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_prestamo", nullable = false)
    private int idPrestamo;
    @Basic
    @Column(name = "id_libro", nullable = true, insertable = false, updatable = false)
    private Integer idLibro;
    @Basic
    @Column(name = "fecha_prestamo", nullable = true)
    private Date fechaPrestamo;
    @Basic
    @Column(name = "fecha_devolucion", nullable = true)
    private Date fechaDevolucion;
    @Basic
    @Column(name = "id_usuario", nullable = true, insertable = false, updatable = false)
    private Integer idUsuario;
    @ManyToOne
    @JoinColumn(name = "id_libro", referencedColumnName = "id_libro", insertable = false, updatable = false)
    private LibrosJPAEntity librosByIdLibro;

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", nullable = false)
    private UsuariosJPAEntity usuariosByIdUsuario;

    public int getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public Integer getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(Integer idLibro) {
        this.idLibro = idLibro;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PrestamosJPAEntity that = (PrestamosJPAEntity) o;

        if (idPrestamo != that.idPrestamo) return false;
        if (idLibro != null ? !idLibro.equals(that.idLibro) : that.idLibro != null) return false;
        if (fechaPrestamo != null ? !fechaPrestamo.equals(that.fechaPrestamo) : that.fechaPrestamo != null)
            return false;
        if (fechaDevolucion != null ? !fechaDevolucion.equals(that.fechaDevolucion) : that.fechaDevolucion != null)
            return false;
        if (idUsuario != null ? !idUsuario.equals(that.idUsuario) : that.idUsuario != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPrestamo;
        result = 31 * result + (idLibro != null ? idLibro.hashCode() : 0);
        result = 31 * result + (fechaPrestamo != null ? fechaPrestamo.hashCode() : 0);
        result = 31 * result + (fechaDevolucion != null ? fechaDevolucion.hashCode() : 0);
        result = 31 * result + (idUsuario != null ? idUsuario.hashCode() : 0);
        return result;
    }

    public LibrosJPAEntity getLibrosByIdLibro() {
        return librosByIdLibro;
    }

    public void setLibrosByIdLibro(LibrosJPAEntity librosByIdLibro) {
        this.librosByIdLibro = librosByIdLibro;
    }
}
