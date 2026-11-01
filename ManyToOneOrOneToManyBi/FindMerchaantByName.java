package org.jsp.ManyToOneOrOneToManyBi;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;



public class FindMerchaantByName {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("M15");
		EntityManager em=emf.createEntityManager();
		Query q=em.createQuery("select m from Merchant m where m.name=?1");
		System.out.println("Enter the name: ");

		q.setParameter(1, new Scanner(System.in).next());
		List<Merchant> ml=q.getResultList();
		if(!ml.isEmpty()) {
			Iterator<Merchant> i=ml.iterator();
			while(i.hasNext()) {
				Merchant p=i.next();
				System.out.println(p);
			}
					
		}else {
			System.err.println("No record found");
		}
	}
}
