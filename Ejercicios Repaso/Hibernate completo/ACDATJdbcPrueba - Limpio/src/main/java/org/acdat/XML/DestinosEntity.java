package org.acdat.XML;

import java.math.BigInteger;
import java.util.Collection;

public class DestinosEntity {
    private int destinoId;
    private String nombreDestino;
    private String descripcion;
    private BigInteger costoEstadia;
    private Collection<ClientesDestinosEntity> clientesDestinosByDestinoId;
    private Collection<DestinosAgenciasEntity> destinosAgenciasByDestinoId;

    public int getDestinoId() {
        return destinoId;
    }

    public void setDestinoId(int destinoId) {
        this.destinoId = destinoId;
    }

    public String getNombreDestino() {
        return nombreDestino;
    }

    public void setNombreDestino(String nombreDestino) {
        this.nombreDestino = nombreDestino;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigInteger getCostoEstadia() {
        return costoEstadia;
    }

    public void setCostoEstadia(BigInteger costoEstadia) {
        this.costoEstadia = costoEstadia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DestinosEntity that = (DestinosEntity) o;

        if (destinoId != that.destinoId) return false;
        if (nombreDestino != null ? !nombreDestino.equals(that.nombreDestino) : that.nombreDestino != null)
            return false;
        if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;
        if (costoEstadia != null ? !costoEstadia.equals(that.costoEstadia) : that.costoEstadia != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = destinoId;
        result = 31 * result + (nombreDestino != null ? nombreDestino.hashCode() : 0);
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + (costoEstadia != null ? costoEstadia.hashCode() : 0);
        return result;
    }

    public Collection<ClientesDestinosEntity> getClientesDestinosByDestinoId() {
        return clientesDestinosByDestinoId;
    }

    public void setClientesDestinosByDestinoId(Collection<ClientesDestinosEntity> clientesDestinosByDestinoId) {
        this.clientesDestinosByDestinoId = clientesDestinosByDestinoId;
    }

    public Collection<DestinosAgenciasEntity> getDestinosAgenciasByDestinoId() {
        return destinosAgenciasByDestinoId;
    }

    public void setDestinosAgenciasByDestinoId(Collection<DestinosAgenciasEntity> destinosAgenciasByDestinoId) {
        this.destinosAgenciasByDestinoId = destinosAgenciasByDestinoId;
    }
}
