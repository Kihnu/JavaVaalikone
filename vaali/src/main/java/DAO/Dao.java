package DAO;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.Questions;
import java.sql.Connection;

public class Dao {
	private String user;
	private String pass;
	private String url;
	private Connection conn;

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
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public ArrayList<Questions> readAllQuestions() {
		ArrayList<Questions> list = new ArrayList<>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet RS = stmt.executeQuery("select * from questions");
			while (RS.next()) {
				Questions q = new Questions();
				q.setId(RS.getInt("question_id"));
				q.setQuestion(RS.getString("question"));
				list.add(q);
			}
			return list;
		} catch (SQLException e) {
			return null;
		}
	}
	
	public Questions readQuestion(String id) {
		Questions q = null;
		try {
			String sql = "select* from questions where id=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setNString(1, id);
			ResultSet RS = pstmt.executeQuery();
			while (RS.next()) {
				q = new Questions();
				q.setId(RS.getInt("id"));
				q.setQuestion(RS.getNString("question"));
			}
			return q;
		} catch(SQLException e) {
			return null;
		}
	}
}
