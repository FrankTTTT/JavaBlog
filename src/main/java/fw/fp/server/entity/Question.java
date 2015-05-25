package fw.fp.server.entity;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Question {
	
	@Id
	@GeneratedValue
	private int id;
	
	@OneToMany(mappedBy="question")
	private List<Item> items;
	
	
	private String description;
	
	
	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> options;
	private String correctAnswer;

	@ManyToOne
	@JoinColumn(name="questiontest_id")
	private QuestionTest questionTest;

	
	
	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public QuestionTest getQuestionTest() {
		return questionTest;
	}

	public void setQuestionTest(QuestionTest questionTest) {
		this.questionTest = questionTest;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}



	public List<String> getOptions() {
		return options;
	}

	public void setOptions(List<String> options) {
		this.options = options;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
}
