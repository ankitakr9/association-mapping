package org.jsp.ManyToOneUni;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindQuestionById {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("M15");

        EntityManager em = emf.createEntityManager();

        QuestionData qd = em.find(QuestionData.class, 1);

        if (qd != null) {
            System.out.println(qd);
        } else {
            System.out.println("Question not found");
        }

        em.close();
        emf.close();
    }
}