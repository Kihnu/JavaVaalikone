package DAO;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import app.Comparison;
import data.Candidates;

import data.Questions;
import java.sql.Connection;


public class Dao {
	private String user;
	private String pass;
	private String url;
	private Connection conn;
	// private Comparison com;

	public Dao(String url, String user, String pass) {
		this.url = url;
		this.user = user;
		this.pass = pass;
	}

	public boolean getConnection() {
		try {
			if (conn == null || conn.isClosed()) {
				try {
					Class.forName("com.mysql.jdbc.Driver").newInstance();
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
					throw new SQLException(e);
				}
				conn = DriverManager.getConnection(url, user, pass);
			}
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public ArrayList<Questions> readAllQuestions() {
		ArrayList<Questions> list = new ArrayList<>();
		try {
			Statement stmt = conn.createStatement();
			String sql = "";
			PreparedStatement statement = conn.prepareStatement(sql);
			sql = "use vaalikone";
			statement.executeUpdate(sql);
			ResultSet RS = stmt.executeQuery("select * from questions");
			while (RS.next()) {
				Questions q = new Questions();
				q.setId(RS.getInt("question_id"));
				q.setQuestion(RS.getString("question"));
				list.add(q);
			}
			return list;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}

	}

	public ArrayList<Candidates> readAllCandidates() {
		ArrayList<Candidates> list = new ArrayList<>();
		try {

			Statement stmt = conn.createStatement();
			ResultSet RS = stmt.executeQuery("select * from candidates");
			while (RS.next()) {
				Candidates c = new Candidates();
				c.setId(RS.getInt("candidate_id"));
				c.setfirstname(RS.getString("firstname"));
				c.setsurname(RS.getString("surname"));
				list.add(c);
			}
			return list;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}

	}

//	public ArrayList<UserAnswer> userAnswer() {
//		ArrayList<UserAnswer> list = new ArrayList<>();
//		try {
//			Statement stmt = conn.createStatement();
//			String sql = "";
//			PreparedStatement statement = conn.prepareStatement(sql);
//			sql = "use vaalikone";
//			statement.executeUpdate(sql);
//			sql = "update user_answers set answer_int=? where id=?";
//			statement.setString(1, com.g);
//			statement.setString(2, );
//			ResultSet RS = statement.executeQuery();
//			
//			return list;
//
//		} catch (SQLException e) {
//			System.out.println(e.getMessage());
//			return null;
//		}
//	}
}
