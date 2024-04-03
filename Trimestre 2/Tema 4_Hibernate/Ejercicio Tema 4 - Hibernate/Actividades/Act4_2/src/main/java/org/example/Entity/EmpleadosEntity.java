package org.example.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "empleados")
public class EmpleadosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empno")
    private int empno;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "puesto")
    private String puesto;

    @ManyToOne
    @JoinColumn(name = "depno", referencedColumnName = "depno")
    private DepartamentosEntity departamento;

    // Constructor, getters y setters
    public EmpleadosEntity() {
    }

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public DepartamentosEntity getDepartamento() {
        return departamento;
    }

    public void setDepartamento(DepartamentosEntity departamento) {
        this.departamento = departamento;
    }
}
