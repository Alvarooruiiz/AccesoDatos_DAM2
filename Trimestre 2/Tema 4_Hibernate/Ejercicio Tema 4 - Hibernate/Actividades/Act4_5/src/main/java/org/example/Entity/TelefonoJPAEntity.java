package org.example.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Telefono", schema = "public", catalog = "AcdatJPA")
public class TelefonoJPAEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idTelefono", nullable = false)
    private int idTelefono;
    @Basic
    @Column(name = "numero", nullable = false, length = 9)
    private String numero;
    @ManyToOne
    @JoinColumn(name = "idPersona", foreignKey = @ForeignKey(name = "PERSON_ID_FK"))
    private PersonaJPAEntity persona;

    public TelefonoJPAEntity() {
    }

    public TelefonoJPAEntity(String numero) {
        this.numero = numero;
    }

    public int getIdTelefono() {
        return idTelefono;
    }

    public void setIdTelefono(int idTelefono) {
        this.idTelefono = idTelefono;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public PersonaJPAEntity getPersona() {
        return persona;
    }

    public void setPersona(PersonaJPAEntity persona) {
        this.persona = persona;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TelefonoJPAEntity that = (TelefonoJPAEntity) o;

        if (idTelefono != that.idTelefono) return false;
        if (numero != null ? !numero.equals(that.numero) : that.numero != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idTelefono;
        result = 31 * result + (numero != null ? numero.hashCode() : 0);
        return result;
    }
}