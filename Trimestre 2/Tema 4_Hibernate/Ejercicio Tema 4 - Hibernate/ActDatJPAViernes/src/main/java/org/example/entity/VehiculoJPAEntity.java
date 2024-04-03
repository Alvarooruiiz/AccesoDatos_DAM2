package org.example.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "vehiculos")
public class VehiculoJPAEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "marca")
    private String marca;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "color")
    private String color;

    @Column(name = "matricula")
    private String matricula;

    @Column(name = "fecha_matriculacion")
    private Date fechaMatriculacion;

    @Column(name = "numero_kilometros")
    private long numeroKilometros;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "concesionario_id")
    private ConcesionarioJPAEntity concesionario;

    // Constructores, Setters y Getters, y toString

    public VehiculoJPAEntity() {}

    public VehiculoJPAEntity(String marca, String modelo, String color, String matricula, Date fechaMatriculacion, long numeroKilometros) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.matricula = matricula;
        this.fechaMatriculacion = fechaMatriculacion;
        this.numeroKilometros = numeroKilometros;
    }

    // Setters y Getters
    public void setConcesionario(ConcesionarioJPAEntity concesionario) {
        this.concesionario = concesionario;
    }

    // toString
    @Override
    public String toString() {
        return "Vehiculo{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", color='" + color + '\'' +
                ", matricula='" + matricula + '\'' +
                ", fechaMatriculacion=" + fechaMatriculacion +
                ", numeroKilometros=" + numeroKilometros +
                '}';
    }
}
