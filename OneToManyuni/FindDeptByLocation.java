package org.jsp.OneToManyuni;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class FindDeptByLocation {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("M15");

        EntityManager em = emf.createEntityManager();

        TypedQuery<Dept> query =
                em.createQuery(
                    "select d from Dept d where d.loc=?1",
                    Dept.class
                );

        query.setParameter(1, "BTM");

        Dept d = query.getSingleResult();

        System.out.println(d);

        em.close();
        emf.close();
    }
}
