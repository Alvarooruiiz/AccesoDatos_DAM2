package org.example.Actividad3_6_1;

public class Asignatura {
    String nombre;
    int horas;
    int anyo;

    public Asignatura(String nombre, int horas, int anyo) {
        this.nombre = nombre;
        this.horas = horas;
        this.anyo = anyo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public int getAnyo() {
        return anyo;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }
}
