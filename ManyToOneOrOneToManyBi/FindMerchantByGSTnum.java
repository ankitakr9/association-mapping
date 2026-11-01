package org.jsp.ManyToOneOrOneToManyBi;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;



public class FindMerchantByGSTnum {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("M15");
		EntityManager em=emf.createEntityManager();
		Query q=em.createQuery("Select m from Merchant m where m.gst_num=?1");
		System.out.println("Enter the GST_num: ");
		q.setParameter(1, new Scanner(System.in).next());
		try {
			Merchant p=(Merchant) q.getSingleResult();
			System.out.println(p);
		}catch(NoResultException e) {
			System.err.println("No record found");
		}
	}
	
}
