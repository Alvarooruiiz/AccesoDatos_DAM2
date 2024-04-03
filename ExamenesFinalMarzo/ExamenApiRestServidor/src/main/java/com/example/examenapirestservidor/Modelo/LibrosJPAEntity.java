package com.example.examenapirestservidor.Modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "libros", schema = "public", catalog = "PruebaFinalPrestamos")
public class LibrosJPAEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_libro", nullable = false)
    private int idLibro;
    @Basic
    @Column(name = "titulo", nullable = true, length = 255)
    private String titulo;
    @Basic
    @Column(name = "id_autor", nullable = true)
    private Integer idAutor;
    @Basic
    @Column(name = "genero", nullable = true, length = 50)
    private String genero;
    @Basic
    @Column(name = "anio_publicacion", nullable = true)
    private Integer anioPublicacion;
    @ManyToOne
    @JoinColumn(name = "id_autor", referencedColumnName = "id_autor", insertable = false, updatable = false)
    private AutoresJPAEntity autoresByIdAutor;

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Integer idAutor) {
        this.idAutor = idAutor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(Integer anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LibrosJPAEntity that = (LibrosJPAEntity) o;

        if (idLibro != that.idLibro) return false;
        if (titulo != null ? !titulo.equals(that.titulo) : that.titulo != null) return false;
        if (idAutor != null ? !idAutor.equals(that.idAutor) : that.idAutor != null) return false;
        if (genero != null ? !genero.equals(that.genero) : that.genero != null) return false;
        if (anioPublicacion != null ? !anioPublicacion.equals(that.anioPublicacion) : that.anioPublicacion != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idLibro;
        result = 31 * result + (titulo != null ? titulo.hashCode() : 0);
        result = 31 * result + (idAutor != null ? idAutor.hashCode() : 0);
        result = 31 * result + (genero != null ? genero.hashCode() : 0);
        result = 31 * result + (anioPublicacion != null ? anioPublicacion.hashCode() : 0);
        return result;
    }

    public AutoresJPAEntity getAutoresByIdAutor() {
        return autoresByIdAutor;
    }

    public void setAutoresByIdAutor(AutoresJPAEntity autoresByIdAutor) {
        this.autoresByIdAutor = autoresByIdAutor;
    }
}
