package org.acdat.negocio;

import org.acdat.entitiesJPA.DestinoJPA;

import java.sql.SQLException;
import java.util.List;

public class Destino {
    protected int id;
    protected String destino;
    protected String descripcion;
    protected double coste;

    public Destino(int id, String destino, String descripcion, double coste) {
        this.id = id;
        this.destino = destino;
        this.descripcion = descripcion;
        this.coste = coste;
    }

    public Destino() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCoste() {
        return coste;
    }

    public void setCoste(double coste) {
        this.coste = coste;
    }

    @Override
    public String toString() {
        return "Destino{" +
                "id=" + id +
                ", destino='" + destino + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", coste=" + coste +
                '}';
    }

    public String mostrarDestinos() throws SQLException {
        String respuesta = "";

        DestinoJPA destinoJPA = new DestinoJPA();
        List<DestinoJPA> destinos = destinoJPA.mostrarDestinos();

        for (DestinoJPA destino : destinos) {
            respuesta = respuesta + "\n" + destino.toString();
        }

        return respuesta;
    }

    public boolean agregarDestino() throws SQLException {
        boolean respuesta;
        DestinoJPA destinoJPA = new DestinoJPA();
        Destino destino = new Destino(id, this.destino, descripcion, coste);

        respuesta = destinoJPA.crearDestino(destino);

        return respuesta;
    }

    public boolean actualizarDestino() throws SQLException {
        boolean respuesta = false;
        DestinoJPA destinoJPA = new DestinoJPA();
        DestinoJPA destino = destinoJPA.leerDestino(id);

        if (destino != null) {
            destino.setNombreDestino(this.destino);
            destino.setDescripcion(descripcion);
            destino.setCostoEstadia(coste);

            respuesta = destinoJPA.actualizarDestino(destino);
        }

        return respuesta;
    }

    public boolean cargarDestino() throws SQLException {
        boolean respuesta = false;
        DestinoJPA destinoJPA = new DestinoJPA();
        DestinoJPA destino = destinoJPA.leerDestino(id);

        if (destino != null) {
            this.destino = destino.getNombreDestino();
            this.descripcion = destino.getDescripcion();
            this.coste = destino.getCostoEstadia();
            respuesta = true;
        }

        return respuesta;
    }

    public boolean eliminarDestino() throws SQLException {
        boolean respuesta;
        DestinoJPA destinoJPA = new DestinoJPA();
        respuesta = destinoJPA.borrarDestino(id);

        return respuesta;
    }
}
