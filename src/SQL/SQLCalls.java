//STEP 1. Import required packages
package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javafx.scene.layout.Pane;

public class SQLCalls {
	// JDBC driver name and database URL
	public String DB_URL = "jdbc:mysql://localhost:3306/TriviaGame?user=root&password=Uff.ar.ted07&useUnicode=true&characterEncoding=UTF-8";

	// Database credentials
	String USER = "root";
	String PASS = "Uff.ar.ted07";

	Connection conn = null;
	Statement stmt = null;

/*
 * Creates all of the gets and sets for the SQL database
 * Each function is structured the same with the connection at 
 * the top followed by a space and the code that manipulates the data
 * There is another space and then the file returns and closes the
 * connection
 */
	
	//Used for testing
	public static void main(String[] args) {
		
		SQLCalls s = new SQLCalls();
		try {
			
			String st = null;
			ArrayList<Questions> hello = new ArrayList<Questions>();
			
			hello = s.getQuestions(1);
			for(Questions x: hello)
			{
				System.out.println(x.answer);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//Constructor for SQL Connection
	public SQLCalls()
	{
		DB_URL = "jdbc:mysql://localhost:3306/triviagame?user=root&password=Uff.ar.ted07&useUnicode=true&characterEncoding=UTF-8";
		USER = "root";
		PASS = "Uff.ar.ted07";
	}
	
	//Creates an acount for a user
	public void createAcount(String username, String password)
	{
		try 
		{	//Connects to the database
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			
			String sql = "INSERT INTO Users(ID, username, password, score) VALUES (0,'" + username +"','" + password + "',0);";
			stmt.executeUpdate(sql);
			System.out.println("Succssful update");
			
			stmt.close();
			conn.close();
		} 
		catch (final SQLException se) {se.printStackTrace();}
		catch (final Exception e) {e.printStackTrace();} 
		finally { try { if (stmt != null) stmt.close();} catch (final SQLException se2) {}
		try { if (conn != null) conn.close();} catch (final SQLException se) {se.printStackTrace();}}
	}
	
	//Gets old score and then adds to the new score
	public void setScore(String username, int score)
	{
		try 
		{	//Connects to the database
			int oldScore = getScore(username);
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			
			score = score + oldScore;
			String sql = "UPDATE Users SET score = '" + score +"' WHERE username = '"+ username+ "';";
			stmt.executeUpdate(sql);
			System.out.println("Succssful update");
			
			stmt.close();
			conn.close();
		} 
		catch (final SQLException se) {se.printStackTrace();}
		catch (final Exception e) {e.printStackTrace();} 
		finally { try { if (stmt != null) stmt.close();} catch (final SQLException se2) {}
		try { if (conn != null) conn.close();} catch (final SQLException se) {se.printStackTrace();}}
	}
	
	//Creates a quiz id with unique id
	public void createQuiz(int id, String title)
	{
		try 
		{	//Connects to the database
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			
			String sql = "INSERT INTO Quiz VALUES ('"+id+"','"+title+"');";
			stmt.executeUpdate(sql);
			System.out.println("Succssful update");
			
			stmt.close();
			conn.close();
		} 
		catch (final SQLException se) {se.printStackTrace();}
		catch (final Exception e) {e.printStackTrace();} 
		finally { try { if (stmt != null) stmt.close();} catch (final SQLException se2) {}
		try { if (conn != null) conn.close();} catch (final SQLException se) {se.printStackTrace();}}
	}
	
	//Creates question in SQL
	public void createQuestion(int id, String answer, String incA1, String incA2, String incA3, String question)
	{
		try 
		{	//Connects to the database
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			
			String sql = "INSERT INTO Question(ID, answer, incorrectAnser1, incorrectAnser2, incorrectAnser3, question) "
						+ "VALUES ('"+id+"','"+answer+"','"+incA1+"','"+incA2+"','"+incA3+"','"+question+"');";
			stmt.executeUpdate(sql);
			System.out.println("Succssful update");
			
			stmt.close();
			conn.close();
		} 
		catch (final SQLException se) {se.printStackTrace();}
		catch (final Exception e) {e.printStackTrace();} 
		finally { try { if (stmt != null) stmt.close();} catch (final SQLException se2) {}
		try { if (conn != null) conn.close();} catch (final SQLException se) {se.printStackTrace();}}
	}
	
	//Sets title of the quiz given an id
	public void setTitle(String title, int id)
	{
		try 
		{	//Connects to the database
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			
			String sql = "UPDATE Quiz SET title = '"+title+"' WHERE ID = '"+id+"';";
			stmt.executeUpdate(sql);
			System.out.println("Succssful update");
			
			stmt.close();
			conn.close();
		} 
		catch (final SQLException se) {se.printStackTrace();}
		catch (final Exception e) {e.printStackTrace();} 
		finally { try { if (stmt != null) stmt.close();} catch (final SQLException se2) {}
		try { if (conn != null) conn.close();} catch (final SQLException se) {se.printStackTrace();}}
	}
	
	//Sets the answer given the id
	public void setAnswer(String answer, int id)
	{
		try 
		{	//Connects to the database
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			
			String sql = "UPDATE Question SET answer = '"+ answer +"' WHERE ID = '"+ id +"';";
			stmt.executeUpdate(sql);
			
			System.out.println("Succssful update");
			stmt.close();
			conn.close();
		} 
		catch (final SQLException se) {se.printStackTrace();}
		catch (final Exception e) {e.printStackTrace();} 
		finally { try { if (stmt != null) stmt.close();} catch (final SQLException se2) {}
		try { if (conn != null) conn.close();} catch (final SQLException se) {se.printStackTrace();}}
	}
	
	//Sets the question given the id 
	public void setQuestion(String question, int id)
	{
		try 
		{	//Connects to the database
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			
			String sql = "UPDATE Question SET question = '"+question+"' WHERE ID = '"+id+"';";
			stmt.executeUpdate(sql);
			System.out.println("Succssful update");
			
			stmt.close();
			conn.close();
		} 
		catch (final SQLException se) {se.printStackTrace();}
		catch (final Exception e) {e.printStackTrace();} 
		finally { try { if (stmt != null) stmt.close();} catch (final SQLException se2) {}
		try { if (conn != null) conn.close();} catch (final SQLException se) {se.printStackTrace();}}
	}
	
	//Gets username given a password
	public String getUsername(String password) throws Exception
	{
		String username = null;
		try 
		{	//Connects to the database
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Creating statement...");
			
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT username FROM Users WHERE password = '" + password + "';";
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			username = rs.getString("username");
			
			rs.close();
			stmt.close();
			conn.close();

		} catch (final SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (final Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (final SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (final SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		return username;
	}
	
	//Gets password given the username
	public String getPassword(String username) throws Exception
	{
		String password = null;
		try 
		{
			//Connects to the database
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Creating statement...");
			
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT password FROM Users WHERE username = '" + username + "';";
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			password = rs.getString("password");
			
			rs.close();
			stmt.close();
			conn.close();

		} catch (final SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (final Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (final SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (final SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		return password;
	}
	
	//Gets the score given the username
	public int getScore(String username) throws Exception
	{
		int score = 0;
		try 
		{	//Connects to the database
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Creating statement...");
			
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT score FROM Users WHERE username = '" + username + "';";
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			score = rs.getInt("score");
			
			rs.close();
			stmt.close();
			conn.close();

		} catch (final SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (final Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (final SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (final SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		return score;
	}
	
	//Gets the answer given the id of the problem
	public String getAnswer(int id) throws Exception
	{
		String answer = null;
		try 
		{
			//Connects to the database
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Creating statement...");
			
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT answer FROM Question WHERE ID = '" + id + "';";
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			answer = rs.getString("answer");
			
			rs.close();
			stmt.close();
			conn.close();

		} catch (final SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (final Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (final SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (final SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		return answer;
	}
	
	//Gets the quiz id given the title of the quiz
	public int getQuizID(String title) throws Exception
	{
		int id = 0;
		try 
		{
			//Connects to the database
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Creating statement...");
			
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT ID FROM Quiz WHERE title = '" + title + "';";
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			id = rs.getInt("ID");
			
			rs.close();
			stmt.close();
			conn.close();

		} catch (final SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (final Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (final SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (final SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		return id;
	}
	
	//Gets the question ID given the answer
	public int getQuestionID(String answer) throws Exception
	{
		int id = 0;
		try 
		{
			//Connects to the database
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Creating statement...");
			
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT ID FROM Question WHERE answer = '" + answer + "';";
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			id = rs.getInt("ID");
			
			rs.close();
			stmt.close();
			conn.close();

		} catch (final SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (final Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (final SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (final SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		return id;
	}
	
	//Gets the top 10 rows from sql given the table
	public int getHighestID(String table)
	{
		int id = 0;
		try 
		{

			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Creating statement...");
			
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT MAX(ID) FROM " + table + ";";
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			id = rs.getInt("MAX(ID)");
			
			rs.close();
			stmt.close();
			conn.close();

		} catch (final SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (final Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (final SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (final SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		return id;
	}
	
	//Gets the highest scores for all users 
	public ArrayList<String> getHighestScores()
	{
		ArrayList<String> scores = new ArrayList<String>();
		
		try 
		{

			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Creating statement...");
			
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT username, score FROM Users LIMIT 10;";
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next())
			{
				 scores.add(rs.getString("score")); 
				 scores.add(rs.getString("username"));
			}

			rs.close();
			stmt.close();
			conn.close();

		} catch (final SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (final Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (final SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (final SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		return scores;
	}
	
	//gets the quizzes to populate the trivia select page
	public ArrayList<String> getQuizzes()
	{
		ArrayList<String> quiz = new ArrayList<String>();
		try 
		{

			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Creating statement...");
			
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT title FROM Quiz;";
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next())
			{
				 quiz.add(rs.getString("title")); 
			}

			rs.close();
			stmt.close();
			conn.close();

		} catch (final SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (final Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (final SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (final SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		return quiz;
	}
	
	//Gets the questions for the quizzes given the id
	public ArrayList<Questions> getQuestions(int id)
	{
			ArrayList<Questions> quest = new ArrayList<Questions>();
		try 
		{
			
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Creating statement...");
			
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT answer, incorrectAnser1, incorrectAnser2,"
					+ " incorrectAnser3, question FROM Question WHERE ID = " + id + ";";
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next())
			{
				 quest.add(new Questions(rs.getString("answer"),
						 				 rs.getString("incorrectAnser1"), 
						 				 rs.getString("incorrectAnser2"),
						 				 rs.getString("incorrectAnser3"), 
						 				 rs.getString("question")));
			}

			rs.close();
			stmt.close();
			conn.close();

		} catch (final SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (final Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (final SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (final SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		return quest;
	}
}