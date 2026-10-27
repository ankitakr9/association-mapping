package org.com.OneToOne;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindPersonByPhone {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("M15");
		EntityManager em=emf.createEntityManager();
		Query q=em.createQuery("select p from Person p where p.phone=?1");
		
		System.out.println("Enter the PhoneNo:"); 
		
		q.setParameter(1, new Scanner(System.in).nextLong());
		Person person = (Person) q.getSingleResult(); 
		System.out.println(person); 
		
		em.close(); 
		emf.close();
	}
}
