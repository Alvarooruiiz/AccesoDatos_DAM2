import java.io.Serializable;

public class Jugador  implements Serializable {
    private String nombre;
    private String apodo;
    private String puesto;
    private Integer dorsal;
    private String descripcion;


    public Jugador() {
    }

    public Jugador(String nombre, String apodo, String puesto, Integer dorsal, String descripcion) {
        this.nombre = nombre;
        this.apodo = apodo;
        this.puesto = puesto;
        this.dorsal = dorsal;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public Integer getDorsal() {
        return dorsal;
    }

    public void setDorsal(Integer dorsal) {
        this.dorsal = dorsal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "nombre='" + nombre + '\'' +
                ", apodo='" + apodo + '\'' +
                ", puesto='" + puesto + '\'' +
                ", dorsal=" + dorsal +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
