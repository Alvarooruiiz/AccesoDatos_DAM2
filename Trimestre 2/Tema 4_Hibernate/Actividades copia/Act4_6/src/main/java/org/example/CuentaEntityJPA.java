package org.example;

import jakarta.persistence.*;

@Entity
@Table(name = "cuenta", schema = "public", catalog = "banco")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_cuenta")
public class CuentaEntityJPA {
    private long id;
    private double balance;
    private double tipointeres;
    private String titular;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "balance")
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Basic
    @Column(name = "tipointeres")
    public double getTipointeres() {
        return tipointeres;
    }

    public void setTipointeres(double tipointeres) {
        this.tipointeres = tipointeres;
    }

    @Basic
    @Column(name = "titular")
    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CuentaEntityJPA that = (CuentaEntityJPA) o;

        if (id != that.id) return false;
        if (Double.compare(balance, that.balance) != 0) return false;
        if (Double.compare(tipointeres, that.tipointeres) != 0) return false;
        if (titular != null ? !titular.equals(that.titular) : that.titular != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (id ^ (id >>> 32));
        temp = Double.doubleToLongBits(balance);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(tipointeres);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (titular != null ? titular.hashCode() : 0);
        return result;
    }
}
