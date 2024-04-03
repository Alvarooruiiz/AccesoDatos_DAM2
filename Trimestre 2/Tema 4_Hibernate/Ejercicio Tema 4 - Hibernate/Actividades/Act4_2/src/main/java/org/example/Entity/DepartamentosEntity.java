package org.example.Entity;

import jakarta.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "departamentos")
public class DepartamentosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "depno")
    private int depno;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "ubicacion")
    private String ubicacion;

    @OneToMany(mappedBy = "departamento")
    private Collection<EmpleadosEntity> empleados;

    // Constructor, getters y setters
    public DepartamentosEntity() {
    }

    public int getDepno() {
        return depno;
    }

    public void setDepno(int depno) {
        this.depno = depno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Collection<EmpleadosEntity> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Collection<EmpleadosEntity> empleados) {
        this.empleados = empleados;
    }
}
