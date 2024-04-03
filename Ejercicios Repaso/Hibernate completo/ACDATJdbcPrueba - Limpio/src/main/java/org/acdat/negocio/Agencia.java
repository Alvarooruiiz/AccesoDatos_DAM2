package org.acdat.negocio;

import org.acdat.entitiesJPA.AgenciaJPA;

import java.sql.SQLException;
import java.util.List;

public class Agencia {
    protected int id;
    protected String nombre;
    protected String direccion;
    protected String telefono;

    public Agencia(int id, String nombre, String direccion, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Agencia() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Agencia{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }

    public String mostrarAgencias() throws SQLException {
        String respuesta = "";

        AgenciaJPA agenciaJPA = new AgenciaJPA();
        List<AgenciaJPA> agencias = agenciaJPA.mostrarAgencias();

        for (AgenciaJPA agencia : agencias) {
            respuesta = respuesta + "\n" + agencia.toString();
        }

        return respuesta;
    }

    public boolean agregarAgencia() throws SQLException {
        boolean respuesta;
        AgenciaJPA agenciaJPA = new AgenciaJPA();
        Agencia agencia = new Agencia(id, nombre, direccion, telefono);

        respuesta = agenciaJPA.crearAgencia(agencia);

        return respuesta;
    }

    public boolean actualizarAgencia() throws SQLException {
        boolean respuesta = false;
        AgenciaJPA agenciaJPA = new AgenciaJPA();
        AgenciaJPA agencia = agenciaJPA.leerAgencia(id);

        if (agencia != null) {
            agencia.setNombreAgencia(nombre);
            agencia.setDireccionAgencia(direccion);
            agencia.setTelefonoAgencia(telefono);

            respuesta = agenciaJPA.actualizarAgencia(agencia);
        }

        return respuesta;
    }

    public boolean cargarAgencia() throws SQLException {
        boolean respuesta = false;
        AgenciaJPA agenciaJPA = new AgenciaJPA();
        AgenciaJPA agencia = agenciaJPA.leerAgencia(id);

        if (agencia != null) {
            this.nombre = agencia.getNombreAgencia();
            this.direccion = agencia.getDireccionAgencia();
            this.telefono = agencia.getTelefonoAgencia();
            respuesta = true;
        }

        return respuesta;
    }

    public boolean eliminarAgencia() throws SQLException {
        boolean respuesta;
        AgenciaJPA agenciaJPA = new AgenciaJPA();
        respuesta = agenciaJPA.borrarAgencia(id);

        return respuesta;
    }
}
