package com.example.act8_1_crearapirestspringboot.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "departamento", schema = "public", catalog = "empleado")
public class EntidadDepartamentos {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    @Basic
    @Column(name = "presupuesto", nullable = false, precision = 0)
    private double presupuesto;
    @Basic
    @Column(name = "gastos", nullable = false, precision = 0)
    private double gastos;
    @JsonIgnoreProperties("departamentoByIdDepartamento")
    private List<EntidadEmpleados> empleados;

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
        EntidadDepartamentos that = (EntidadDepartamentos) o;
        return id == that.id && Double.compare(presupuesto, that.presupuesto) == 0 && Double.compare(gastos, that.gastos) == 0 && Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, presupuesto, gastos);
    }
}
