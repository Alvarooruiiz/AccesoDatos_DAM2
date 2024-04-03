package org.acdat.entitiesJPA;

import jakarta.persistence.*;

@Entity
@Table(name = "clientes_destinos", schema = "public", catalog = "HibernatePrueba")
public class ClienteDestinoJPA {
    @Id
    @ManyToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "cliente_id")
    private ClienteJPA cliente;

    @Id
    @ManyToOne
    @JoinColumn(name = "destino_id", referencedColumnName = "destino_id")
    private DestinoJPA destino;

    public ClienteDestinoJPA() {
    }

    public ClienteJPA getCliente() {
        return cliente;
    }

    public void setCliente(ClienteJPA cliente) {
        this.cliente = cliente;
    }

    public DestinoJPA getDestino() {
        return destino;
    }

    public void setDestino(DestinoJPA destino) {
        this.destino = destino;
    }
}
