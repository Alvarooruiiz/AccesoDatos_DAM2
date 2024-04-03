package org.example.jpa;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "departamento", schema = "public", catalog = "empleado")
public class DepartamentoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "nombre")
    private String nombre;
    @Basic
    @Column(name = "presupuesto")
    private double presupuesto;
    @Basic
    @Column(name = "gastos")
    private double gastos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    public double getGastos() {
        return gastos;
    }

    public void setGastos(double gastos) {
        this.gastos = gastos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DepartamentoEntity that = (DepartamentoEntity) o;
        return id == that.id && Double.compare(presupuesto, that.presupuesto) == 0 && Double.compare(gastos, that.gastos) == 0 && Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, presupuesto, gastos);
    }
}
