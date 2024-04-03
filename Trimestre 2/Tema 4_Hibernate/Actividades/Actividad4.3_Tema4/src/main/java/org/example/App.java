package org.example;

import jakarta.persistence.*;
import entity.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            Employee alvaro = new Employee();
            alvaro.setId(6);
            alvaro.setFirstname("Alvaro");
            alvaro.setLastname("Ruiz Enriquez");
            entityManager.persist(alvaro);

            TypedQuery<Employee> empByDeptQuery = entityManager.createNamedQuery("Employee.byDept", Employee.class);
            empByDeptQuery.setParameter(1, "Java Advocacy");
            for (Employee employee : empByDeptQuery.getResultList()) {
                System.out.println(employee);
            }

            Query countEmpByDept = entityManager.createNativeQuery("SELECT COUNT(*) FROM Employee INNER JOIN Department D on Employee.department_id = D.id WHERE D.name=:deptName");
            countEmpByDept.setParameter("deptName", "Java Advocacy");
            System.out.println("There are " + countEmpByDept.getSingleResult() + " Java Advocates.");

            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
