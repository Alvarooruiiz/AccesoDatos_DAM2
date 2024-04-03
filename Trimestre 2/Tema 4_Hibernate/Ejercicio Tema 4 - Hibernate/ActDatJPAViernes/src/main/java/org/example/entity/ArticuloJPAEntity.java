package org.example.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "articulos")
public class ArticuloJPAEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idArticulo;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "precio_venta")
    private int precioVenta;

    @ManyToMany
    @JoinTable(
            name = "venta",
            joinColumns = @JoinColumn(name = "idArticulo"),
            inverseJoinColumns = @JoinColumn(name = "idComprador")
    )
    private Set<CompradorJPAEntity> compradores = new HashSet<>();

    // Constructores, Setters y Getters, y toString

    public ArticuloJPAEntity() {}

    public ArticuloJPAEntity(String descripcion, int precioVenta) {
        this.descripcion = descripcion;
        this.precioVenta = precioVenta;
    }

    // Setters y Getters
    public Set<CompradorJPAEntity> getCompradores() {
        return compradores;
    }

    // toString
    @Override
    public String toString() {
        return "Articulo{" +
                "idArticulo=" + idArticulo +
                ", descripcion='" + descripcion + '\'' +
                ", precioVenta=" + precioVenta +
                '}';
    }
}
