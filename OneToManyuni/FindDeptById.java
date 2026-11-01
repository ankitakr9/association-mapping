package org.jsp.OneToManyuni;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
public class FindDeptById {
	public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("M15");

        EntityManager em = emf.createEntityManager();

        Dept d = em.find(Dept.class, 1);

        if (d != null) {
            System.out.println(d);
        } else {
            System.out.println("Department not found");
        }

        em.close();
        emf.close();
    }
	
}
