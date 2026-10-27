package org.com.OneToOne;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindPersonById {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("M15");
		EntityManager em=emf.createEntityManager();
		Person p=em.find(Person.class,3);
		if(p!=null) {
			System.out.println(p);
		}else {
			System.out.println("Merchant not found");
		}
		em.close();
		emf.close();
	}
}
