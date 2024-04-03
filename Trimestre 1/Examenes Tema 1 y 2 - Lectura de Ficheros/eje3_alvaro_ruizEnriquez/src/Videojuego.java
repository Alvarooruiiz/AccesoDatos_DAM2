public class Videojuego {
    private String titulo;
    private String semilla;
    private String estado;
    private String tipoRecoleccion;
    private String frecuencia;
    private String profundidad;
    private String tamanio;
    private String palabrasClave;
    private String materia;

    public Videojuego() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSemilla() {
        return semilla;
    }

    public void setSemilla(String semilla) {
        this.semilla = semilla;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipoRecoleccion() {
        return tipoRecoleccion;
    }

    public void setTipoRecoleccion(String tipoRecoleccion) {
        this.tipoRecoleccion = tipoRecoleccion;
    }

    public String getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(String frecuencia) {
        this.frecuencia = frecuencia;
    }

    public String getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(String profundidad) {
        this.profundidad = profundidad;
    }

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    public String getPalabrasClave() {
        return palabrasClave;
    }

    public void setPalabrasClave(String palabrasClave) {
        this.palabrasClave = palabrasClave;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    @Override
    public String toString() {
        return "Videojuego{" +
                "titulo='" + titulo + '\'' +
                ", semilla='" + semilla + '\'' +
                ", estado='" + estado + '\'' +
                ", tipoRecoleccion='" + tipoRecoleccion + '\'' +
                ", frecuencia='" + frecuencia + '\'' +
                ", profundidad='" + profundidad + '\'' +
                ", tamanio='" + tamanio + '\'' +
                ", palabrasClave='" + palabrasClave + '\'' +
                ", materia='" + materia + '\'' +
                '}';
    }
}
