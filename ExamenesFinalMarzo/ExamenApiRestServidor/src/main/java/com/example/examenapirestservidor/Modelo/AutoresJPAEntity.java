package com.example.examenapirestservidor.Modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "autores", schema = "public", catalog = "PruebaFinalPrestamos")
public class AutoresJPAEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_autor", nullable = false)
    private int idAutor;
    @Basic
    @Column(name = "nombre_autor", nullable = true, length = 255)
    private String nombreAutor;
    @Basic
    @Column(name = "pais", nullable = true, length = 50)
    private String pais;

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AutoresJPAEntity that = (AutoresJPAEntity) o;

        if (idAutor != that.idAutor) return false;
        if (nombreAutor != null ? !nombreAutor.equals(that.nombreAutor) : that.nombreAutor != null) return false;
        if (pais != null ? !pais.equals(that.pais) : that.pais != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idAutor;
        result = 31 * result + (nombreAutor != null ? nombreAutor.hashCode() : 0);
        result = 31 * result + (pais != null ? pais.hashCode() : 0);
        return result;
    }
}
