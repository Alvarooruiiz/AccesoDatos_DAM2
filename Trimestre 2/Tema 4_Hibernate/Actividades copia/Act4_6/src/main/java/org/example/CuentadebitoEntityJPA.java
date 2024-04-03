package org.example;

import jakarta.persistence.*;
@Entity
@DiscriminatorValue("debito")
public class CuentadebitoEntityJPA {
    private double cargopordescubierto;
    private long id;
    private CuentaEntityJPA cuentaById;

    // Constructor que acepta un objeto CuentaEntityJPA
    public CuentadebitoEntityJPA(CuentaEntityJPA cuentaById) {
        this.cuentaById = cuentaById;
    }

    public CuentadebitoEntityJPA() {

    }

    @Basic
    @Column(name = "cargopordescubierto")
    public double getCargopordescubierto() {
        return cargopordescubierto;
    }

    public void setCargopordescubierto(double cargopordescubierto) {
        this.cargopordescubierto = cargopordescubierto;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CuentadebitoEntityJPA that = (CuentadebitoEntityJPA) o;

        if (Double.compare(that.cargopordescubierto, cargopordescubierto) != 0) return false;
        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(cargopordescubierto);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (int) (id ^ (id >>> 32));
        return result;
    }
}
