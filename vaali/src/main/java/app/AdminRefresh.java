package app;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<Questions> list = null;

		if (dao.getConnection()) {
			
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

				sql = "CREATE DATABASE Vaalikone;"; // Luo uudestaan Vaalikone DB:n
				statement.executeUpdate(sql);

				sql = "use Vaalikone;"; // Joo
				System.out.println(sql);
				statement.executeUpdate(sql);

				sql = "CREATE TABLE candidates (candidate_id int(3) NOT NULL AUTO_INCREMENT, surname varchar(30) NOT NULL, "
						+ "firstname varchar(30), age int(3), party varchar(30) NOT NULL, profession varchar(60), why varchar(600), "
						+ "what varchar(600), vote_nro int(4) NOT NULL, PRIMARY KEY (candidate_id, vote_nro));";
				statement.executeUpdate(sql);
				sql = "CREATE TABLE questions (question_id int(3) NOT NULL AUTO_INCREMENT, question varchar(600) NOT NULL, "
						+ "PRIMARY KEY (question_id));";
				statement.executeUpdate(sql);
				sql = "CREATE TABLE answers (answer_id int(5) NOT NULL AUTO_INCREMENT, candidate_id int(3) NOT NULL, "
						+ "question_id int(3) NOT NULL, answer_int int(1) NOT NULL, answer_string varchar(600), PRIMARY KEY (answer_id), "
						+ "FOREIGN KEY (candidate_id) REFERENCES candidates (candidate_id), FOREIGN KEY (question_id) "
						+ "REFERENCES questions (question_id));";
				statement.executeUpdate(sql);

				// TESTI
				sql = "INSERT INTO candidates (surname, firstname, age, party, profession, why, what, vote_nro) VALUES ('aku', 'ankka', 1, 'pomo', 'homo', 'muute vaa', 'jotai', 313)";

				sql = "INSERT INTO questions (question) VALUES ('Duckburg, Mouseville and Goosetown should all be combined into one big city.');";
				statement.executeUpdate(sql);
				sql = "INSERT INTO questions (question) VALUES ('The roads of Duckburg are in good condition.');";
				statement.executeUpdate(sql);
				sql = "INSERT INTO questions (question) VALUES ('The city of Duckburg should add more public transportation options.');";
				statement.executeUpdate(sql);
				sql = "INSERT INTO questions (question) VALUES ('Duckburg needs more car repair shops.');";
				statement.executeUpdate(sql);
				sql = "INSERT INTO questions (question) VALUES ('SAMPLE TEXT');";
				statement.executeUpdate(sql);
				sql = "INSERT INTO questions (question) VALUES ('Fethry Duck is a menace to society.');";
				statement.executeUpdate(sql);
				sql = "INSERT INTO questions (question) VALUES ('Schools should adapt more to the distance education model.');";
				statement.executeUpdate(sql);
				sql = "INSERT INTO questions (question) VALUES ('We live in a society.');";
				statement.executeUpdate(sql);
				sql = "INSERT INTO questions (question) VALUES ('Scrooge McDucks Money Bin should be moved away from Duckburg.');";
				statement.executeUpdate(sql);
				sql = "INSERT INTO questions (question) VALUES ('I dont agree with this statement.');";
				statement.executeUpdate(sql);
				sql = "INSERT INTO questions (question) VALUES ('Somebody once told me the world is gonna roll me.');";
				statement.executeUpdate(sql);
				sql = "INSERT INTO questions (question) VALUES ('Duckburg has too many ducks.');";
				statement.executeUpdate(sql);
				sql = "INSERT INTO questions (question) VALUES ('Every job in Duckburg should be automated.');";
				statement.executeUpdate(sql);
				sql = "INSERT INTO questions (question) VALUES ('The ducks and other birdlike citizens of Duckberg should be able to fly.');";
				statement.executeUpdate(sql);
				sql = "INSERT INTO questions (question) VALUES ('Dark chocolate is better than white chocolate.');";
				
//				statement = conn.prepareStatement(sql);
//				statement.setString(1, "Duck");
//				statement.setString(2, "Donald");
//				statement.setLong(3, 36);
//				statement.setString(4, "Socialist");
//				statement.setString(5, "Rubber Bread");
//				statement.setString(6,
//						"In my opinion the amount of work an anthropomorphic animal has to do just to live their life normally is way too much.");
//				statement.setString(7, "Something to occupy my feeble mind while I try to avoid working as much as I can.");
//				statement.setLong(8, 313);

				int rowsInserted = statement.executeUpdate(sql);
				if (rowsInserted > 0) {
					System.out.println("A questions were updated successfully!");
				} else {
					System.out.println("Nothing happened");
				}

			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			
			
			list = dao.readAllQuestions();
		} else {
			System.out.println("No connection to database");
		}
		

		request.setAttribute("questionlist", list);

		RequestDispatcher rd = request.getRequestDispatcher("/Admin");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
