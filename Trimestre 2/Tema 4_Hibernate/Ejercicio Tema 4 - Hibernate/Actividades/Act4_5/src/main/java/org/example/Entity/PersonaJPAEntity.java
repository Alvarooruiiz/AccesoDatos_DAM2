package org.example.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Persona", schema = "public", catalog = "AcdatJPA")
public class PersonaJPAEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idPersona", nullable = false)
    private int idPersona;
    @Basic
    @Column(name = "nombre", nullable = true, length = 100)
    private String nombre;
    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TelefonoJPAEntity> telefonos;

    public PersonaJPAEntity(){

    }

    public PersonaJPAEntity(String nombre) {
        this.nombre = nombre;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<TelefonoJPAEntity> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(List<TelefonoJPAEntity> telefonos) {
        this.telefonos = telefonos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonaJPAEntity that = (PersonaJPAEntity) o;

        if (idPersona != that.idPersona) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPersona;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        return result;
    }
}
