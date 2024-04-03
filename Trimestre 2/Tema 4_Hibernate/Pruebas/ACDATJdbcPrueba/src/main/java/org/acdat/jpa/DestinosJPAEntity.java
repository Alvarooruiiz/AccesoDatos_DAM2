package org.acdat.jpa;

import jakarta.persistence.*;
import org.acdat.negocio.Destino;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "destinos", schema = "public", catalog = "agenciaPrueba")
public class DestinosJPAEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "destinos_id", nullable = false)
    private int destinosId;
    @Basic
    @Column(name = "nombre_destino", nullable = true, length = 100)
    private String nombreDestino;
    @Basic
    @Column(name = "description", nullable = true, length = -1)
    private String description;
    @Basic
    @Column(name = "costo_estadia", nullable = true, precision = 0)
    private BigInteger costoEstadia;

    public int getDestinosId() {
        return destinosId;
    }

    public void setDestinosId(int destinosId) {
        this.destinosId = destinosId;
    }

    public String getNombreDestino() {
        return nombreDestino;
    }

    public void setNombreDestino(String nombreDestino) {
        this.nombreDestino = nombreDestino;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

        DestinosJPAEntity that = (DestinosJPAEntity) o;

        if (destinosId != that.destinosId) return false;
        if (nombreDestino != null ? !nombreDestino.equals(that.nombreDestino) : that.nombreDestino != null)
            return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (costoEstadia != null ? !costoEstadia.equals(that.costoEstadia) : that.costoEstadia != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = destinosId;
        result = 31 * result + (nombreDestino != null ? nombreDestino.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (costoEstadia != null ? costoEstadia.hashCode() : 0);
        return result;
    }

    static Session abrirSession() throws Exception {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        if (session == null) {
            return null;
        }else {
            System.out.println("Conexión Establecida");
        }
        return session;
    }


    public List<Destino> mostrarDestino{
        List<Destino> destinosLista = new ArrayList<>;
        List<DestinosJPAEntity destinosJPAEntities = new ArrayList<DestinosJPAEntity>();
    }
}
