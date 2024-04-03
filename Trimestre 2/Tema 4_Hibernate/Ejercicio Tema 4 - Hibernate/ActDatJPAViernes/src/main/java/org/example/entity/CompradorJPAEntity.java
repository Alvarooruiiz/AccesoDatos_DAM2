package org.example.entity;

import jakarta.persistence.*;


import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "compradores")
public class CompradorJPAEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idComprador;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "telefono")
    private String telefono;

    @ManyToMany(mappedBy = "compradores")
    private Set<ArticuloJPAEntity> articulos = new HashSet<>();

    // Constructores, Setters y Getters, y toString

    public CompradorJPAEntity() {}

    public CompradorJPAEntity(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }

    // Setters y Getters
    public void addArticulo(ArticuloJPAEntity articulo) {
        articulos.add(articulo);
        articulo.getCompradores().add(this);
    }

    public void removeArticulo(ArticuloJPAEntity articulo) {
        articulos.remove(articulo);
        articulo.getCompradores().remove(this);
    }

    // toString
    @Override
    public String toString() {
        return "Comprador{" +
                "idComprador=" + idComprador +
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}