package data;

public class AnswersC {
	private int answerId;
	private int CandidateId;
	private int QuestionId;
	private int answerint;
	private String answerstring;
	
	public AnswersC(String 
			answerId, int CandidateId, int QuestionId, int answerint, String answerstring) {
		setId(answerId);
	
		
		this.CandidateId=CandidateId;
		this.QuestionId=QuestionId;
		this.answerint=answerint;
		this.answerstring=answerstring;
	}


	public AnswersC()
	{
		
	}
	
	
	
	public int getId() {
	return answerId;
	}
	public void setId(int answerId) {
	this.answerId = answerId;
	}
	
	
	

	private void setId(String answerId) {
		// TODO Auto-generated method stub
		
		try {
			this.answerId = Integer.parseInt(answerId);
		}
		catch(NumberFormatException | NullPointerException e) {
			System.out.println(e.getMessage());
		}
		
	}
	

	public int getCandidateId() {
		return CandidateId;
	}
	public void setCandidateId(int CandidateId) {
		this.CandidateId = CandidateId;
	}
	
	
	
	public int getQuestionId() {
		return QuestionId;
	}
	public void setQuestionId(int QuestionId) {
		this.QuestionId = QuestionId;
		
	}
	
	
	
	public int answerint() {
		return answerint;
	}
	public void setanswerint(int answerint) {
		this.answerint = answerint;
		
	}
	
	public String answerstring() {
		return answerstring;
	}
	public void setanswerstring(String answerstring) {
		this.answerstring = answerstring;
		
	}
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	

}
