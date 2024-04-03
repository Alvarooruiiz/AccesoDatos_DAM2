package org.acdat.XML;

public class ClientesDestinosEntity {
    private int clienteId;
    private int destinoId;
    private ClientesEntity clientesByClienteId;
    private DestinosEntity destinosByDestinoId;

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public int getDestinoId() {
        return destinoId;
    }

    public void setDestinoId(int destinoId) {
        this.destinoId = destinoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientesDestinosEntity that = (ClientesDestinosEntity) o;

        if (clienteId != that.clienteId) return false;
        if (destinoId != that.destinoId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = clienteId;
        result = 31 * result + destinoId;
        return result;
    }

    public ClientesEntity getClientesByClienteId() {
        return clientesByClienteId;
    }

    public void setClientesByClienteId(ClientesEntity clientesByClienteId) {
        this.clientesByClienteId = clientesByClienteId;
    }

    public DestinosEntity getDestinosByDestinoId() {
        return destinosByDestinoId;
    }

    public void setDestinosByDestinoId(DestinosEntity destinosByDestinoId) {
        this.destinosByDestinoId = destinosByDestinoId;
    }
}
