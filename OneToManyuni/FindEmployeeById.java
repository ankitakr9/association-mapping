package org.jsp.OneToManyuni;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindEmployeeById {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("M15");

        EntityManager em = emf.createEntityManager();

        Employee e = em.find(Employee.class, 1);

        if (e != null) {
            System.out.println(e);
        } else {
            System.out.println("Employee not found");
        }

        em.close();
        emf.close();
    }
}