package org.jsp.OneToManyuni;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class FindEmployeesByDeptIdAndName {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("M15");

        EntityManager em = emf.createEntityManager();

        TypedQuery<Employee> query =
                em.createQuery(
                    "select e from Dept d join d.elist e " +
                    "where d.id=?1 and e.name=?2",
                    Employee.class
                );

        query.setParameter(1, 1);
        query.setParameter(2, "Ankita");

        List<Employee> list = query.getResultList();

        for (Employee e : list) {
            System.out.println(e);
        }

        em.close();
        emf.close();
    }
}