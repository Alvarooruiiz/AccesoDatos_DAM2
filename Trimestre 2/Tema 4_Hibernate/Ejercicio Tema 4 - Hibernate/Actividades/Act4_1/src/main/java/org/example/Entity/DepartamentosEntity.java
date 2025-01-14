package org.example.Entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "departamentos", schema = "public", catalog = "Empleados")
public class DepartamentosEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "depno", nullable = false)
    private int depno;

    @Basic
    @Column(name = "nombre", nullable = true, length = 255)
    private String nombre;

    @Basic
    @Column(name = "ubicacion", nullable = true, length = 255)
    private String ubicacion;

    @OneToMany(mappedBy = "departamentosByDepno")
    private Collection<EmpleadosEntity> empleadosByDepno;

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

    public Collection<EmpleadosEntity> getEmpleadosByDepno() {
        return empleadosByDepno;
    }

    public void setEmpleadosByDepno(Collection<EmpleadosEntity> empleadosByDepno) {
        this.empleadosByDepno = empleadosByDepno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DepartamentosEntity that = (DepartamentosEntity) o;

        if (depno != that.depno) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (ubicacion != null ? !ubicacion.equals(that.ubicacion) : that.ubicacion != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = depno;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (ubicacion != null ? ubicacion.hashCode() : 0);
        return result;
    }
}
