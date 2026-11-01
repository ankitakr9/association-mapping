package org.jsp.ManyToOneUni;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class QuestionData {
	@Override
	public String toString() {
		return "QuestionData [id=" + id + ", question=" + question + ", questionBy=" + questionBy + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getQuestionBy() {
		return questionBy;
	}
	public void setQuestionBy(String questionBy) {
		this.questionBy = questionBy;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String question;
	private String questionBy;
}
