package com.example.springbootprestamos.dto;

import com.example.springbootprestamos.modelo.AutoresJPAEntity;

import java.util.List;

public class AutoresDTO {

    private int idAutor;
    private String nombreAutor;
    private String pais;

    public AutoresDTO(int idAutor, String nombreAutor, String pais) {
        this.idAutor = idAutor;
        this.nombreAutor = nombreAutor;
        this.pais = pais;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
