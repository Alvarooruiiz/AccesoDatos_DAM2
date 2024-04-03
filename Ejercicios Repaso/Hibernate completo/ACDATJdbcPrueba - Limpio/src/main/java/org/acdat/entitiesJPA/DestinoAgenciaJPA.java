package org.acdat.entitiesJPA;

import jakarta.persistence.*;

@Entity
@Table(name = "destinos_agencias", schema = "public", catalog = "HibernatePrueba")
public class DestinoAgenciaJPA {
    @Id
    @ManyToOne
    @JoinColumn(name = "destino_id", referencedColumnName = "destino_id")
    private DestinoJPA destino;

    @Id
    @ManyToOne
    @JoinColumn(name = "agencia_id", referencedColumnName = "agencia_id")
    private AgenciaJPA agencia;

    public DestinoAgenciaJPA() {
    }

    public DestinoJPA getDestino() {
        return destino;
    }

    public void setDestino(DestinoJPA destino) {
        this.destino = destino;
    }

    public AgenciaJPA getAgencia() {
        return agencia;
    }

    public void setAgencia(AgenciaJPA agencia) {
        this.agencia = agencia;
    }
}
