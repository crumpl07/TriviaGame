package SQL;

public class Questions {

		public String answer;
		public String question;
		public String incorrectAnswer1;
		public String incorrectAnswer2;
		public String incorrectAnswer3;
	
		public Questions(String answer, String incorrectAnswer1, String incorrectAnswer2, String incorrectAnswer3, String question)
		{
			this.answer = answer;
			this.question = question;
			this.incorrectAnswer1 = incorrectAnswer1;
			this.incorrectAnswer2 = incorrectAnswer2;
			this.incorrectAnswer3 = incorrectAnswer3;
		}
}
