package org.acdat.XML;

public class DestinosAgenciasEntity {
    private int destinoId;
    private int agenciaId;
    private DestinosEntity destinosByDestinoId;
    private AgenciasEntity agenciasByAgenciaId;

    public int getDestinoId() {
        return destinoId;
    }

    public void setDestinoId(int destinoId) {
        this.destinoId = destinoId;
    }

    public int getAgenciaId() {
        return agenciaId;
    }

    public void setAgenciaId(int agenciaId) {
        this.agenciaId = agenciaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DestinosAgenciasEntity that = (DestinosAgenciasEntity) o;

        if (destinoId != that.destinoId) return false;
        if (agenciaId != that.agenciaId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = destinoId;
        result = 31 * result + agenciaId;
        return result;
    }

    public DestinosEntity getDestinosByDestinoId() {
        return destinosByDestinoId;
    }

    public void setDestinosByDestinoId(DestinosEntity destinosByDestinoId) {
        this.destinosByDestinoId = destinosByDestinoId;
    }

    public AgenciasEntity getAgenciasByAgenciaId() {
        return agenciasByAgenciaId;
    }

    public void setAgenciasByAgenciaId(AgenciasEntity agenciasByAgenciaId) {
        this.agenciasByAgenciaId = agenciasByAgenciaId;
    }
}
