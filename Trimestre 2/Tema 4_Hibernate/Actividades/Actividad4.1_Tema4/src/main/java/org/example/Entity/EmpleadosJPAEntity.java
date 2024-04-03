package org.example.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "empleados", schema = "public", catalog = "Empleados")
public class EmpleadosJPAEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "empno", nullable = false)
    private int empno;
    @Basic
    @Column(name = "depno", nullable = true)
    private Integer depno;
    @Basic
    @Column(name = "nombre", nullable = true, length = 255)
    private String nombre;
    @Basic
    @Column(name = "puesto", nullable = true, length = 255)
    private String puesto;
    @ManyToOne
    @JoinColumn(name = "depno", referencedColumnName = "depno")
    private DepartamentosJPAEntity departamentosByDepno;

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public Integer getDepno() {
        return depno;
    }

    public void setDepno(Integer depno) {
        this.depno = depno;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmpleadosJPAEntity that = (EmpleadosJPAEntity) o;

        if (empno != that.empno) return false;
        if (depno != null ? !depno.equals(that.depno) : that.depno != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (puesto != null ? !puesto.equals(that.puesto) : that.puesto != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = empno;
        result = 31 * result + (depno != null ? depno.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (puesto != null ? puesto.hashCode() : 0);
        return result;
    }

    public DepartamentosJPAEntity getDepartamentosByDepno() {
        return departamentosByDepno;
    }

    public void setDepartamentosByDepno(DepartamentosJPAEntity departamentosByDepno) {
        this.departamentosByDepno = departamentosByDepno;
    }
}
