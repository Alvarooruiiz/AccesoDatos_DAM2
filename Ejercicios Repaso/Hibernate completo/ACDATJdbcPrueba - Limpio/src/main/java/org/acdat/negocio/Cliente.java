package org.acdat.negocio;

import org.acdat.entitiesJPA.ClienteJPA;

import java.sql.SQLException;
import java.util.List;

public class Cliente {
    protected int id;
    protected String nombre;
    protected String correo;
    protected String telefono;

    public Cliente(int id, String nombre, String correo, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
    }

    public Cliente() {
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }

    public String mostrarClientes() throws SQLException {
        String respuesta = "";

        ClienteJPA clienteJPA = new ClienteJPA();
        List<ClienteJPA> clientes = clienteJPA.mostrarClientes();

        for (ClienteJPA cliente : clientes) {
            respuesta = respuesta + "\n" + cliente.toString();
        }

        return respuesta;
    }

    public boolean agregarCliente() throws SQLException {
        boolean respuesta;
        ClienteJPA clienteJPA = new ClienteJPA();
        Cliente cliente = new Cliente(id, nombre, correo, telefono);

        respuesta = clienteJPA.crearCliente(cliente);

        return respuesta;
    }

    public boolean actualizarCliente() throws SQLException {
        boolean respuesta = false;
        ClienteJPA clienteJPA = new ClienteJPA();
        ClienteJPA cliente = clienteJPA.leerCliente(id);

        if (cliente != null) {
            cliente.setNombreCliente(nombre);
            cliente.setCorreoCliente(correo);
            cliente.setTelefonoCliente(telefono);

            respuesta = clienteJPA.actualizarCliente(cliente);
        }

        return respuesta;
    }

    public boolean cargarCliente() throws SQLException {
        boolean respuesta = false;
        ClienteJPA clienteJPA = new ClienteJPA();
        ClienteJPA cliente = clienteJPA.leerCliente(id);

        if (cliente != null) {
            this.nombre = cliente.getNombreCliente();
            this.correo = cliente.getCorreoCliente();
            this.telefono = cliente.getTelefonoCliente();
            respuesta = true;
        }

        return respuesta;
    }

    public boolean eliminarCliente() throws SQLException {
        boolean respuesta;
        ClienteJPA clienteJPA = new ClienteJPA();
        respuesta = clienteJPA.borrarCliente(id);

        return respuesta;
    }
}
