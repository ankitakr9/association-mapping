
package org.jsp.ManyToOneOrOneToManyBi;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class FindMerchantById {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("M15");
		EntityManager em=emf.createEntityManager();
		EntityTransaction etran=em.getTransaction();
		Merchant m=em.find(Merchant.class,2);
		if(m!=null) {
			System.out.println(m);
		}else {
			System.out.println("Merchant not found");
		}
		em.close();
		emf.close();
	}
	
}
