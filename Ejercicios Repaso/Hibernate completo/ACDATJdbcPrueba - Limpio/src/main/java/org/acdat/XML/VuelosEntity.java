package org.acdat.XML;

public class VuelosEntity {
    private int vueloId;
    private Double costo;
    private String destino;
    private String fechaLlegada;
    private String fechaSalida;
    private String origen;

    public int getVueloId() {
        return vueloId;
    }

    public void setVueloId(int vueloId) {
        this.vueloId = vueloId;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(String fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VuelosEntity that = (VuelosEntity) o;

        if (vueloId != that.vueloId) return false;
        if (costo != null ? !costo.equals(that.costo) : that.costo != null) return false;
        if (destino != null ? !destino.equals(that.destino) : that.destino != null) return false;
        if (fechaLlegada != null ? !fechaLlegada.equals(that.fechaLlegada) : that.fechaLlegada != null) return false;
        if (fechaSalida != null ? !fechaSalida.equals(that.fechaSalida) : that.fechaSalida != null) return false;
        if (origen != null ? !origen.equals(that.origen) : that.origen != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = vueloId;
        result = 31 * result + (costo != null ? costo.hashCode() : 0);
        result = 31 * result + (destino != null ? destino.hashCode() : 0);
        result = 31 * result + (fechaLlegada != null ? fechaLlegada.hashCode() : 0);
        result = 31 * result + (fechaSalida != null ? fechaSalida.hashCode() : 0);
        result = 31 * result + (origen != null ? origen.hashCode() : 0);
        return result;
    }
}
