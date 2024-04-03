package org.example;

import jakarta.persistence.*;

@Entity
@Table(name = "continente", schema = "public", catalog = "AccDatJPA")
public class ContinenteJPAEntity {
    private int idContinente;
    private String nombre;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idContinente", nullable = false)
    public int getIdPais() {
        return idContinente;
    }

    public void setIdPais(int idPais) {
        this.idContinente = idPais;
    }

    @Basic
    @Column(name = "nombre", nullable = true, length = 100)
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

        ContinenteJPAEntity that = (ContinenteJPAEntity) o;

        if (idContinente != that.idContinente) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idContinente;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        return result;
    }
}
