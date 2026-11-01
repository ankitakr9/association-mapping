package org.jsp.ManyToOneOrOneToManyBi;

import java.util.Arrays;

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
		
		Merchant m=new Merchant();
		m.setName("Zara");
		m.setGst_num("ZARA6378");
		m.setEmail("zara@gmail.com");
		m.setPhone(8474748373l);
		m.setPassword("zara948n");
		
		Product p1=new Product();
		p1.setName("Kurta");
		p1.setBrand("zara");
		p1.setCategory("Formal");
		p1.setPrice(799.0);
		p1.setM(m);
		
		Product p2=new Product();
		p2.setName("Jeans");
		p2.setBrand("zara");
		p2.setCategory("Daily wear");
		p2.setPrice(900.0);
		p2.setM(m);
		
		Product p3=new Product();
		p3.setName("TShirt");
		p3.setBrand("zara");
		p3.setCategory("Casual");
		p3.setPrice(399.0);
		p3.setM(m);
		
		
		m.setProds(Arrays.asList(p1,p2,p3));
		em.persist(m);
		etran.commit();
	}
}
