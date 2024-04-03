public class Contacto {
    public String nombre;
    public String apellido;
    public String correoElectronico;
    public String numeroTelef;
    public String descripcion;

    public Contacto(String nombre, String apellido, String correoElectronico, String numeroTelef, String descripcion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correoElectronico = correoElectronico;
        this.numeroTelef = numeroTelef;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getNumeroTelef() {
        return numeroTelef;
    }

    public void setNumeroTelef(String numeroTelef) {
        this.numeroTelef = numeroTelef;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String nombreCompleto(){
        return nombre + " " + apellido;
    }

    @Override
    public String toString() {
        return "Contacto{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", numeroTelef='" + numeroTelef + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
