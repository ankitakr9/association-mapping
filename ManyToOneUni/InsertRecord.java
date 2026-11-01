package org.jsp.ManyToOneUni;

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
		QuestionData qd=new QuestionData();
		qd.setQuestion("What is the most important thing in you life");
		qd.setQuestionBy("Mayank");
		
		AnswerData a1=new AnswerData();
		a1.setAnswer("Family,Money & Peace");
		a1.setAnswerBy("Ankita");
		a1.setQd(qd);
		
		AnswerData a2=new AnswerData();
		a2.setAnswer("Peace");
		a2.setAnswerBy("Sakshi");
		a2.setQd(qd);
		
		AnswerData a3=new AnswerData();
		a3.setAnswer("Money");
		a3.setAnswerBy("Aditya");
		a3.setQd(qd);
		
		AnswerData a4=new AnswerData();
		a4.setAnswer("job");
		a4.setAnswerBy("Neha");
		a4.setQd(qd);
		
		AnswerData a5=new AnswerData();
		a5.setAnswer("Suraj");
		a5.setAnswerBy("Puja");
		a5.setQd(qd);
		
		List<AnswerData> al=Arrays.asList(a1,a2,a3,a4,a5);
		for(AnswerData ad : al) {
			em.persist(ad);
		}
		
		
		etran.commit();
	}
}
