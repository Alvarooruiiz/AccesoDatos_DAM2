package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        EntityTransaction transaction = null;

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("default");
            entityManager = entityManagerFactory.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            
            CuentaEntityJPA cuentaComun = new CuentaEntityJPA();
            cuentaComun.setTitular("Luismi");

            entityManager.persist(cuentaComun);

            CuentacreditoEntityJPA cuentaCredito = new CuentacreditoEntityJPA(cuentaComun);
            cuentaCredito.setLimitecredito(600.0);
            entityManager.persist(cuentaCredito);

            CuentadebitoEntityJPA cuentaDebito = new CuentadebitoEntityJPA(cuentaComun);
            cuentaDebito.setCargopordescubierto(6.5);
            entityManager.persist(cuentaDebito);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
        }
    }
}
