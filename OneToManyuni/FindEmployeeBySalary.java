package org.jsp.OneToManyuni;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class FindEmployeeBySalary {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("M15");

        EntityManager em = emf.createEntityManager();

        TypedQuery<Employee> query =
                em.createQuery(
                    "select e from Employee e where e.salary=?1",
                    Employee.class
                );

        query.setParameter(1, 15000.0);

        List<Employee> list = query.getResultList();

        for (Employee e : list) {
            System.out.println(e);
        }

        em.close();
        emf.close();
    }
}