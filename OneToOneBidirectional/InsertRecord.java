package org.jsp.OneToOneBidirectional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class InsertRecord {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("M15");
		EntityManager em=emf.createEntityManager();
		EntityTransaction etran=em.getTransaction();
		etran.begin();
		
		User u=new User();
		u.setName("Nandu");
		u.setPassword("@nkurru8");
		u.setPhone(9487978649l);
		
		AadharCard card=new AadharCard();
		 card.setNumber(933453758l);
		 card.setDob("12-10-2012");
		 card.setAddress("Patna");
		 card.setUser(u);
		 u.setCard(card);
		 
		 em.persist(u);
		 etran.commit();
	}
}
