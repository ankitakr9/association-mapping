package org.jsp.ManyToOneUni;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class AnswerData {
	@Override
	public String toString() {
		return "AnswerData [id=" + id + ", answer=" + answer + ", answerBy=" + answerBy + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getAnswerBy() {
		return answerBy;
	}
	public void setAnswerBy(String answerBy) {
		this.answerBy = answerBy;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String answer;
	private String answerBy;
	@ManyToOne
	(cascade=CascadeType.ALL)
	private QuestionData qd;

	public QuestionData getQd() {
		return qd;
	}
	public void setQd(QuestionData qd) {
		this.qd = qd;
	}
	
}
