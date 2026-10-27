package org.com.OneToOne;

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
		
		Person p=new Person();
		p.setName("Shan");
		p.setPhone(9575558573l);
		
		Pancard card=new Pancard();
		card.setPanNo("SPJ456");
		card.setDob("21-09-2018");
		
		p.setCard(card);
		em.persist(card);
		em.persist(p);
		
		etran.commit();
	}
}
