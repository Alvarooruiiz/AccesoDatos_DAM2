package org.example.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "concesionarios")
public class ConcesionarioJPAEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_comercial")
    private String nombreComercial;

    @Column(name = "nombre_empresarial")
    private String nombreEmpresarial;

    @Column(name = "direccion_concesionario")
    private String direccionConcesionario;

    @Column(name = "num_trabajadores")
    private int numTrabajadores;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "concesionario", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<VehiculoJPAEntity> vehiculos = new HashSet<>();

    // Constructores, Setters y Getters, y toString

    public ConcesionarioJPAEntity() {}

    public ConcesionarioJPAEntity(String nombreComercial, String nombreEmpresarial, String direccionConcesionario, int numTrabajadores, String email) {
        this.nombreComercial = nombreComercial;
        this.nombreEmpresarial = nombreEmpresarial;
        this.direccionConcesionario = direccionConcesionario;
        this.numTrabajadores = numTrabajadores;
        this.email = email;
    }

    // Setters y Getters
    public void addVehiculo(VehiculoJPAEntity vehiculo) {
        vehiculos.add(vehiculo);
        vehiculo.setConcesionario(this);
    }

    public void removeVehiculo(VehiculoJPAEntity vehiculo) {
        vehiculos.remove(vehiculo);
        vehiculo.setConcesionario(null);
    }

    // toString
    @Override
    public String toString() {
        return "Concesionario{" +
                "id=" + id +
                ", nombreComercial='" + nombreComercial + '\'' +
                ", nombreEmpresarial='" + nombreEmpresarial + '\'' +
                ", direccionConcesionario='" + direccionConcesionario + '\'' +
                ", numTrabajadores=" + numTrabajadores +
                ", email='" + email + '\'' +
                '}';
    }
}
