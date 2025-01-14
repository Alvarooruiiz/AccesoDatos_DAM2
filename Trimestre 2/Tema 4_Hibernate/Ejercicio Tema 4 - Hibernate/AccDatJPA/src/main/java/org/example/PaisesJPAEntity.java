package org.example;

import jakarta.persistence.*;

@Entity
@Table(name = "paises", schema = "public", catalog = "AccDatJPA")
public class PaisesJPAEntity {
    private int idPais;
    private String nombre;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idPais", nullable = false)
    public int getIdPais() {
        return idPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
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

        PaisesJPAEntity that = (PaisesJPAEntity) o;

        if (idPais != that.idPais) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPais;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        return result;
    }
}
