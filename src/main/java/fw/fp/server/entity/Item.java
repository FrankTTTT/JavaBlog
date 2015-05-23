package fw.fp.server.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Item {
	@Id
	@GeneratedValue
	private Integer id;

	@OneToOne
	@JoinColumn(name="question_id")
	private Question question;
	
	@ManyToOne
	@JoinColumn(name="test_id")
	private Test test;
	
	private boolean score;
	private String useranswer;

	
	public boolean getScore(){
		return this.score;
	}
	public String getUseranswer() {
		return useranswer;
	}
	public void setUseranswer(String user_answer) {
		this.useranswer = user_answer;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public void setScore(boolean score) {
		this.score = score;
	}
	public String getAnswer() {
		return useranswer;
	}
	public void setAnswer(String answer) {
		this.useranswer = answer;
	}
	public Test getTest() {
		return test;
	}
	public void setTest(Test test) {
		this.test = test;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}
