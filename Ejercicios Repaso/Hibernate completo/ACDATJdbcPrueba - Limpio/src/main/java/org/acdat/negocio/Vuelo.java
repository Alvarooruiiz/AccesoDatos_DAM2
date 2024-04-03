package org.acdat.negocio;

import org.acdat.entitiesJPA.VueloJPA;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class Vuelo {
    protected int id;
    protected String origen;
    protected String destino;
    protected LocalDate fechaSalida;
    protected LocalDate fechaLlegada;
    protected double costo;

    public Vuelo(int id, String origen, String destino, LocalDate fechaSalida, LocalDate fechaLlegada, double costo) {
        this.id = id;
        this.origen = origen;
        this.destino = destino;
        this.fechaSalida = fechaSalida;
        this.fechaLlegada = fechaLlegada;
        this.costo = costo;
    }

    public Vuelo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public LocalDate getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(LocalDate fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "Vuelo{" +
                "id=" + id +
                ", origen='" + origen + '\'' +
                ", destino='" + destino + '\'' +
                ", fechaSalida=" + fechaSalida +
                ", fechaLlegada=" + fechaLlegada +
                ", costo=" + costo +
                '}';
    }

    public String mostrarVuelos() throws SQLException {
        String respuesta = "";

        VueloJPA vueloJPA = new VueloJPA();
        List<VueloJPA> vuelos = vueloJPA.mostrarVuelos();

        for (VueloJPA vuelo : vuelos) {
            respuesta = respuesta + "\n" + vuelo.toString();
        }

        return respuesta;
    }

    public boolean agregarVuelo() throws SQLException {
        boolean respuesta;
        VueloJPA vueloJPA = new VueloJPA();
        Vuelo vuelo = new Vuelo(id, origen, destino, fechaSalida, fechaLlegada, costo);

        respuesta = vueloJPA.crearVuelo(vuelo);

        return respuesta;
    }

    public boolean actualizarVuelo() throws SQLException {
        boolean respuesta = false;
        VueloJPA vueloJPA = new VueloJPA();
        VueloJPA vuelo = vueloJPA.leerVuelo(id);

        if (vuelo != null) {
            vuelo.setOrigen(origen);
            vuelo.setDestino(destino);
            vuelo.setFechaSalida(fechaSalida);
            vuelo.setFechaLlegada(fechaLlegada);
            vuelo.setCosto(costo);

            respuesta = vueloJPA.actualizarVuelo(vuelo);
        }

        return respuesta;
    }

    public boolean cargarVuelo() throws SQLException {
        boolean respuesta = false;
        VueloJPA vueloJPA = new VueloJPA();
        VueloJPA vuelo = vueloJPA.leerVuelo(id);

        if (vuelo != null) {
            this.origen = vuelo.getOrigen();
            this.destino = vuelo.getDestino();
            this.fechaSalida = vuelo.getFechaSalida();
            this.fechaLlegada = vuelo.getFechaLlegada();
            this.costo = vuelo.getCosto();
            respuesta = true;
        }

        return respuesta;
    }

    public boolean eliminarVuelo() throws SQLException {
        boolean respuesta = false;
        VueloJPA vueloJPA = new VueloJPA();
        respuesta = vueloJPA.borrarVuelo(id);

        return respuesta;
    }
}
