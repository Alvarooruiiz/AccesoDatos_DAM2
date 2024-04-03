package org.example;

import jakarta.persistence.*;
@Entity
@DiscriminatorValue("credito")
public class CuentacreditoEntityJPA {
    private double limitecredito;
    private long id;
    private CuentaEntityJPA cuentaById;

    // Constructor que acepta un objeto CuentaEntityJPA
    public CuentacreditoEntityJPA(CuentaEntityJPA cuentaById) {
        this.cuentaById = cuentaById;
    }

    public CuentacreditoEntityJPA() {

    }

    @Basic
    @Column(name = "limitecredito")
    public double getLimitecredito() {
        return limitecredito;
    }

    public void setLimitecredito(double limitecredito) {
        this.limitecredito = limitecredito;
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

        CuentacreditoEntityJPA that = (CuentacreditoEntityJPA) o;

        if (Double.compare(that.limitecredito, limitecredito) != 0) return false;
        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(limitecredito);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (int) (id ^ (id >>> 32));
        return result;
    }
}
