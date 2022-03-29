package app;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Dao;
import data.Questions;

/**
 * Servlet implementation class AdminRefresh
 */
@WebServlet("/AdminRefresh")
public class AdminRefresh extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Dao dao;
    
	@Override
	public void init() {
		dao = new Dao("jdbc:mysql://localhost:3306/", "user", "password");
	}
    
    public AdminRefresh() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Questions> list=null;
		if (dao.getConnection()) {
			list=dao.readAllQuestions();
		}
		else {
			System.out.println("No connection to database");
		}
		request.setAttribute("questions", list);
		
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/questions.jsp");
		rd.forward(request, response);

		
		String sql = "";
		// Miten ottaa DAOsta
		String dbURL = "jdbc:mysql://localhost:3306/";
		String username = "user";
		String password = "password";
		
		try {
			Connection conn = DriverManager.getConnection(dbURL, username, password);

			if (conn != null) {
				System.out.println("Connected!");
			}
			
			PreparedStatement statement = conn.prepareStatement(sql); 
			
			sql = "DROP DATABASE if exists Vaalikone;"; // Poistaa mahdollisen databasen
			statement.executeUpdate(sql);
			
			System.out.println("Vaalikone db dropattu");
			
			sql = "CREATE DATABASE Vaalikone;"; // Luo uudestaan Vaalikone DB:n
			statement.executeUpdate(sql);
			System.out.println("Vaalikone db luotu");
			
			sql = "use Vaalikone;"; // Joo
			statement.executeUpdate(sql);
			System.out.println("Vaalikone db aktivoitu");
			
			// Ei toimi alla oleva koodi
			sql = "CREATE TABLE candidates (candidate_id int(3) NOT NULL AUTO_INCREMENT, surname varchar(30) NOT NULL, "
					+ "firstname varchar(30), age int(3), party varchar(30) NOT NULL, profession varchar(60), why varchar(600), "
					+ "what varchar(600), vote_nro int(4) NOT NULL, PRIMARY KEY (candidate_id, vote_nro)); "
					+ "CREATE TABLE questions (question_id int(3) NOT NULL AUTO_INCREMENT, question varchar(600) NOT NULL, "
					+ "PRIMARY KEY (question_id));"
					+ "CREATE TABLE answers (answer_id int(5) NOT NULL AUTO_INCREMENT, candidate_id int(3) NOT NULL, "
					+ "question_id int(3) NOT NULL, answer_int int(1) NOT NULL, answer_string varchar(600), PRIMARY KEY (answer_id), "
					+ "FOREIGN KEY (candidate_id) REFERENCES candidates (candidate_id), FOREIGN KEY (question_id) "
					+ "REFERENCES questions (question_id));";
			statement.executeUpdate(sql);
			System.out.println("Candidates taulu luotu");
			
			// TESTI
			sql = "INSERT INTO  candidates (surname, firstname, age, party, profession, why, what, vote_nro) VALUES (?, ?, ?, ?, ?, ?, ?, ?)"; 
			
			statement.setString(1, "Duck"); 
			statement.setString(2, "Donald"); 
			statement.setLong(3, 36); 
			statement.setString(4, "Socialist"); 
			statement.setString(5, "Rubber Bread"); 
			statement.setString(6, "In my opinion the amount of work an anthropomorphic animal has to do just to live their life normally is way too much."); 
			statement.setString(7, "Something to occupy my feeble mind while I try to avoid working as much as I can."); 
			statement.setLong(8, 313);  
			 
			int rowsInserted = statement.executeUpdate(sql); 
			if (rowsInserted > 0) { 
				System.out.println("A new user was inserted successfully!"); 

			} 
			
			
			
			
			
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			
	}

}
