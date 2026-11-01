package org.jsp.ManyToMany;

import java.util.Arrays;
import java.util.List;

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
		
		Batch b1=new Batch();
		b1.setBatch_code("A18");
		b1.setSubject("Java");
		b1.setTrainer("Abhi");
		
		Batch b2=new Batch();
		b2.setBatch_code("M15");
		b2.setSubject("Hibernate");
		b2.setTrainer("Mayank");
		
		Batch b3=new Batch();
		b3.setBatch_code("A86");
		b3.setSubject("Spring");
		b3.setTrainer("Anugraha");
		
		Student s1=new Student();
		s1.setName("Ankita");
		s1.setPhone(8736353536l);
		s1.setMarks(98.0);
		
		Student s2=new Student();
		s2.setName("Shan");
		s2.setPhone(8798654426l);
		s2.setMarks(99.0);
		
		Student s3=new Student();
		s3.setName("Nandani");
		s3.setPhone(9876556703l);
		s3.setMarks(48.0);
		
		Student s4=new Student();
		s4.setName("Anshi");
		s4.setPhone(9854556536l);
		s4.setMarks(78.0);
		
		Student s5=new Student();
		s5.setName("Anshika");
		s5.setPhone(9896353536l);
		s5.setMarks(89.0);
		
		Student s6=new Student();
		s6.setName("Annu");
		s6.setPhone(8447453536l);
		s6.setMarks(89.0);
		
		b1.setStudents(Arrays.asList(s1,s2,s3,s4,s5,s6));
		b2.setStudents(Arrays.asList(s1,s3,s5,s6));
		b2.setStudents(Arrays.asList(s1,s2,s4,s6));
		
		s1.setBatch(Arrays.asList(b1,b2,b3));
		s2.setBatch(Arrays.asList(b1,b3));
		s3.setBatch(Arrays.asList(b1,b2));
		s4.setBatch(Arrays.asList(b1,b3));
		s5.setBatch(Arrays.asList(b1,b2));
		s6.setBatch(Arrays.asList(b1,b2,b3));
		
		List<Batch> bl=Arrays.asList(b1,b2,b3);
		for(Batch b:bl) {
			em.persist(b);
		}
		etran.commit();
	}
}
