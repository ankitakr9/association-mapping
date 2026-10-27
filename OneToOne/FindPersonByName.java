package org.com.OneToOne;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;



public class FindPersonByName {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("M15");
		EntityManager em=emf.createEntityManager();
		Query q=em.createQuery("select p from Person p where p.name=?1");
		System.out.println("Enter the name: ");

		q.setParameter(1, new Scanner(System.in).next());//hashmap,hashset,hashTable internal work of
		List<Person> ml=q.getResultList();
		if(!ml.isEmpty()) {
			Iterator<Person> i=ml.iterator();
			while(i.hasNext()) {
				Person p=i.next();
				System.out.println(p);
			}
					
		}else {
			System.err.println("No record found");
		}
	}
}
