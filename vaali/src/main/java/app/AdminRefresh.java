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
	private Dao dao = null;

	@Override
	public void init() {
		// connection_url_admin = jdbc:mysql://localhost:3306
		// connection_url = jdbc:mysql://localhost:3306/vaalikone
		String url = getServletContext().getInitParameter("connection_url_admin");
		String user = getServletContext().getInitParameter("username");
		String password = getServletContext().getInitParameter("passwd");

		dao = new Dao(url, user, password);
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
		int rowsInserted;

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
				statement.executeUpdate(sql);

				sql = "CREATE TABLE candidates (candidate_id int(3) NOT NULL AUTO_INCREMENT, surname varchar(30) NOT NULL, "
						+ "firstname varchar(30), age int(3), party varchar(30) NOT NULL, profession varchar(60), why varchar(600), "
						+ "what varchar(600), vote_nro int(4) NOT NULL, PRIMARY KEY (candidate_id, vote_nro));";
				statement.executeUpdate(sql);

//				// Kuva sarake lisääminen
//				sql = "CREATE TABLE candidates (candidate_id int(3) NOT NULL AUTO_INCREMENT, surname varchar(30) NOT NULL, "
//						+ "firstname varchar(30), age int(3), party varchar(30) NOT NULL, profession varchar(60), why varchar(600), "
//						+ "what varchar(600), vote_nro int(4) NOT NULL, PRIMARY KEY (candidate_id, vote_nro), kuva_id longblob NOT NULL);";
//				statement.executeUpdate(sql);

				// Quesiton tablen luonti
				sql = "CREATE TABLE questions (question_id int(3) NOT NULL AUTO_INCREMENT, question varchar(600) NOT NULL, "
						+ "PRIMARY KEY (question_id));";
				statement.executeUpdate(sql);

				// Vastaus tablen luonti
				sql = "CREATE TABLE answers (answer_id int(5) NOT NULL AUTO_INCREMENT, candidate_id int(3) NOT NULL, "
						+ "question_id int(3) NOT NULL, answer_int int(1) NOT NULL, answer_string varchar(600), PRIMARY KEY (answer_id), "
						+ "FOREIGN KEY (candidate_id) REFERENCES candidates (candidate_id), FOREIGN KEY (question_id) "
						+ "REFERENCES questions (question_id));";
				statement.executeUpdate(sql);

				// Candidates lisäys
				sql = "INSERT INTO  candidates (surname, firstname, age, party, profession, why, what, vote_nro) VALUES (\"Duck\", \"Donald\", 36, \"Socialist\", \"Rubber bread\", \"In my opinion the amount of work an anthropomorphic animal has to do just to live their life normally is way too much.\", \"Something to occupy my feeble mind while I try to avoid working as much as I can.\", 313);";
				statement.executeUpdate(sql);

				sql = "INSERT INTO  candidates (surname, firstname, age, party, profession, why, what, vote_nro) VALUES (\"McDuck\", \"Scrooge\", 75, \"Indepentend\", \"Business magnate\", \"I need money\", \"Money\", 112);";
				statement.executeUpdate(sql);

				sql = "INSERT INTO  candidates (surname, firstname, age, party, profession, why, what, vote_nro) VALUES (\"Gander\", \"Gladstone\", 38, \"Republican\", \"\", \"I just take part of every competition I can find, I'm so lucky that if I win, I win, and if I lose, I know I dodged a bullet, so it's always a win-win situation for me.\", \"It doesn't matter if I win, as long as Donald (Duck) loses.\", 777);";
				statement.executeUpdate(sql);

				sql = "INSERT INTO  candidates (surname, firstname, age, party, profession, why, what, vote_nro) VALUES (\"Duck\", \"Daisy\", 35, \"Enviromentalist\", \"TV Reporter\", \"Someone needs to do something about the flowers in the middle of the park, they are dying!\", \"My promise is to fix the flowers and then I'll probably resign.\", 666);";
				statement.executeUpdate(sql);

				sql = "INSERT INTO  candidates (surname, firstname, age, party, profession, why, what, vote_nro) VALUES (\"Gearloose\", \"Gyro\", 50, \"Libertarian\", \"Inventor\", \"My inventions will bring a new brighter future for everyone in Duckburg.\", \"To make the living conditions of your every day citizens easier and more stress free. To automate most of the working places, so that people can roam free daily without selling their souls to faceless corporations.\", 314);";
				statement.executeUpdate(sql);

				sql = "INSERT INTO  candidates (surname, firstname, age, party, profession, why, what, vote_nro) VALUES (\"Mouse\", \"Mickey\", 47, \"Socialist\", \"Jack-of-all-trades\", \"I am the most reliable person you will ever meet!\", \"I want to be part of recreating the glory of Duckburg that I remember we had when I was just a wee lad.\", 420);";
				statement.executeUpdate(sql);

				sql = "INSERT INTO  candidates (surname, firstname, age, party, profession, why, what, vote_nro) VALUES (\"Mouse\", \"Minnie\", 47, \"Republican\", \"Barmaid\", \"I feel like no one else gets things done. No one gets things done better than I do, go ask anyone. Ask me for example.\", \"Make Duckburg Great Again\", 137);";
				statement.executeUpdate(sql);

				sql = "INSERT INTO  candidates (surname, firstname, age, party, profession, why, what, vote_nro) VALUES (\"Pluto\", \"\", 8, \"Anarchist\", \"Dog\", \"woof\", \"woof woof\", 100);";
				statement.executeUpdate(sql);

				sql = "INSERT INTO  candidates (surname, firstname, age, party, profession, why, what, vote_nro) VALUES (\"Duck\", \"Huey, Dewey and Louie\", 11, \"Pirate Party\", \"3 children in a trenchcoat\", \"We... I mean, I feel like schools give too much homework for us... I mean, the children, and also recess is way too short, it should be over 1 hour long.\", \"Free candy for every children in Duckburg and never having to go to school again!\", 333);";
				statement.executeUpdate(sql);

				sql = "INSERT INTO  candidates (surname, firstname, age, party, profession, why, what, vote_nro) VALUES (\"Goof\", \"G.G. Goofy\", 61, \"Socialist\", \"Comedian\", \"Why is anyone anywhere? What is the point of life? Are we all just puppets here for the entertainment of some greater intergalactic cosmic beign that plays with the lives and minds of the innocent? What was the question?\", \"I don't know, PlayStation 5 or something.\", 123);";

				rowsInserted = statement.executeUpdate(sql);
				if (rowsInserted > 0) {
					System.out.println("Candidates were updated successfully!");
				} else {
					System.out.println("Nothing happened");
				}

				// Kysymysten lisäys
				sql = "INSERT INTO questions (question) VALUES (\"Duckburg, Mouseville and Goosetown should all be combined into one big city.\");";
				statement.executeUpdate(sql);
				sql = "INSERT INTO questions (question) VALUES (\"The roads of Duckburg are in good condition.\");";
				statement.executeUpdate(sql);
				sql = "INSERT INTO questions (question) VALUES (\"The city of Duckburg should add more public transportation options.\");";
				statement.executeUpdate(sql);
				sql = "INSERT INTO questions (question) VALUES (\"Duckburg needs more car repair shops.\");";
				statement.executeUpdate(sql);
				sql = "INSERT INTO questions (question) VALUES (\"SAMPLE TEXT\");";
				statement.executeUpdate(sql);
				sql = "INSERT INTO questions (question) VALUES (\"Fethry Duck is a menace to society.\");";
				statement.executeUpdate(sql);
				sql = "INSERT INTO questions (question) VALUES (\"Schools should adapt more to the distance education model.\");";
				statement.executeUpdate(sql);
				sql = "INSERT INTO questions (question) VALUES (\"We live in a society.\");";
				statement.executeUpdate(sql);
				sql = "INSERT INTO questions (question) VALUES (\"Scrooge McDuck's Money Bin should be moved away from Duckburg.\"); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO questions (question) VALUES (\"I don't agree with this statement.\");";
				statement.executeUpdate(sql);
				sql = "INSERT INTO questions (question) VALUES (\"Somebody once told me the world is gonna roll me.\");";
				statement.executeUpdate(sql);
				sql = "INSERT INTO questions (question) VALUES (\"Duckburg has too many ducks.\");";
				statement.executeUpdate(sql);
				sql = "INSERT INTO questions (question) VALUES (\"Every job in Duckburg should be automated.\");";
				statement.executeUpdate(sql);
				sql = "INSERT INTO questions (question) VALUES (\"The ducks and other birdlike citizens of Duckberg should be able to fly.\");";
				statement.executeUpdate(sql);
				sql = "INSERT INTO questions (question) VALUES (\"Dark chocolate is better than white chocolate.\");";

				rowsInserted = statement.executeUpdate(sql);
				if (rowsInserted > 0) {
					System.out.println("Questions were updated successfully!");
				} else {
					System.out.println("Nothing happened");
				}

				// Answers lisäys
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(1, 1, 2); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(1, 2, 4); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(1, 3, 2); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(1, 4, 1); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(1, 5, 5); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(1, 6, 2); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(1, 7, 2); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(1, 8, 5); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(1, 9, 2); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(1, 10, 3); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(1, 11, 2); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(1, 12, 5); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(1, 13, 1); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(1, 14, 2); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(1, 15, 2); ";
				statement.executeUpdate(sql);
				// 15 vastausta

				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(2, 1, 1); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(2, 2, 4); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(2, 3, 5); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(2, 4, 1); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(2, 5, 2); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(2, 6, 2); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(2, 7, 2); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(2, 8, 4); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(2, 9, 5); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(2, 10, 2); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(2, 11, 5); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(2, 12, 4); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(2, 13, 2); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(2, 14, 5); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(2, 15, 2); ";
				statement.executeUpdate(sql);
				// 30 vastusta

				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(3, 1, 5); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(3, 2, 1); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(3, 3, 3); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(3, 4, 2); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(3, 5, 2); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(3, 6, 1); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(3, 7, 3); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(3, 8, 2); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(3, 9, 5); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(3, 10, 2); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(3, 11, 1); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(3, 12, 4); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(3, 13, 5); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(3, 14, 2); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(3, 15, 1); ";
				statement.executeUpdate(sql);
				// 45 vastausta

				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(4, 1, 3); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(4, 2, 1); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(4, 4, 5); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(4, 5, 2); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(4, 6, 2); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(4, 7, 1); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(4, 8, 3); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(4, 9, 2); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(4, 10, 5); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(4, 11, 4); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(4, 12, 3); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(4, 13, 4); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(4, 14, 4); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(4, 15, 3); ";
				statement.executeUpdate(sql);
				// 60 vastausta

				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(5, 1, 5); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(5, 2, 5); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(5, 3, 2); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(5, 4, 2); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(5, 5, 5); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(5, 6, 2); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(5, 7, 5); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(5, 8, 2); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(5, 9, 2); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(5, 10, 1); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(5, 11, 5); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(5, 12, 2); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(5, 13, 1); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(5, 14, 5); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(5, 15, 2); ";
				statement.executeUpdate(sql);
				// 75 vastausta

				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(6, 1, 1); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(6, 2, 1); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(6, 3, 2); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(6, 4, 1); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(6, 5, 2); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(6, 6, 2); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(6, 7, 1); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(6, 8, 2); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(6, 9, 1); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(6, 10, 1); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(6, 11, 2); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(6, 12, 1); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(6, 13, 2); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(6, 14, 1); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(6, 15, 2); ";
				statement.executeUpdate(sql);
				// 90 vastausta

				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(7, 1, 2); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(7, 2, 2); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(7, 3, 2); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(7, 4, 2); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(7, 5, 2); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(7, 6, 2); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(7, 7, 2); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(7, 8, 2); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(7, 9, 2); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(7, 10, 2); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(7, 11, 2); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(7, 12, 2); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(7, 13, 2); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(7, 14, 2); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(7, 15, 2); ";
				statement.executeUpdate(sql);
				// 105 vastausta

				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(8, 1, 4); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(8, 2, 4); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(8, 3, 4); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(8, 4, 2); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(8, 5, 2); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(8, 6, 4); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(8, 7, 2); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(8, 8, 2); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(8, 9, 4); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(8, 10, 2); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(8, 11, 4); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(8, 12, 4); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(8, 13, 4); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(8, 14, 4); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(8, 15, 2); ";
				statement.executeUpdate(sql);
				// 120 vastausta

				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(9, 1, 5); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(9, 2, 5); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(9, 3, 5); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(9, 4, 5); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(9, 5, 5); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(9, 6, 5); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(9, 7, 5); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(9, 8, 5); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(9, 9, 5); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(9, 10, 5); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(9, 11, 5); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(9, 12, 5); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(9, 13, 5); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(9, 14, 5); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(9, 15, 5); ";
				statement.executeUpdate(sql);
				// 135 vastausta

				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(10, 1, 4); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(10, 2, 2); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(10, 3, 1); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(10, 4, 2); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(10, 5, 3); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(10, 6, 2); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(10, 7, 3); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(10, 8, 2); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(10, 9, 1); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(10, 10, 2); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(10, 11, 3); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(10, 12, 2); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(10, 13, 2); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(10, 14, 3); ";
				statement.executeUpdate(sql);
				sql = "INSERT INTO ANSWERS (CANDIDATE_ID, QUESTION_ID,ANSWER_INT) VALUES(10, 15, 5); ";
				statement.executeUpdate(sql);
				// 150 vastausta

				rowsInserted = statement.executeUpdate(sql);
				if (rowsInserted > 0) {
					System.out.println("Answers were updated successfully!");
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

		RequestDispatcher rd = request.getRequestDispatcher("/AdminMain");
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
