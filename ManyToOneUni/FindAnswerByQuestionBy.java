package org.jsp.ManyToOneUni;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindAnswerByQuestionBy {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("M15");

        EntityManager em = emf.createEntityManager();

        List<AnswerData> list = em
                .createQuery(
                    "select a from AnswerData a where a.qd.questionBy=?1",
                    AnswerData.class)
                .setParameter(1, "Ankita")
                .getResultList();

        for (AnswerData ad : list) {
            System.out.println(ad);
        }

        em.close();
        emf.close();
    }
}