package DAO;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.AnswersC;
import data.Candidates;
import data.Questions;
import data.Comparison;
import java.sql.Connection;
import data.SingleCandidateAnswers;

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
		} catch (SQLException e) {
			System.out.println("DAO get connection" + e.getMessage());
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
			System.out.println("Read all questions: " + e.getMessage());
			return null;
		}

	}

	public ArrayList<Candidates> readAllCandidates() {
		ArrayList<Candidates> list = new ArrayList<>();
		try {
			Statement stmt = conn.createStatement();
			String sql = "";
			PreparedStatement statement = conn.prepareStatement(sql);
			sql = "use vaalikone";
			statement.executeUpdate(sql);
			ResultSet RS = stmt.executeQuery("select * from candidates");
			while (RS.next()) {
				Candidates c = new Candidates();
				c.setId(RS.getInt("candidate_id"));
				c.setfirstname(RS.getString("firstname"));
				c.setsurname(RS.getString("surname"));
				c.setParty(RS.getString("party"));
				c.setAge(RS.getInt("age"));
				c.setProfession(RS.getString("profession"));
				c.setWhat(RS.getString("what"));
				c.setWhy(RS.getString("why"));
				c.setVote_nro(RS.getInt("vote_nro"));
				list.add(c);
			}
			return list;
		} catch (SQLException e) {
			System.out.println("Read all candidates: " + e.getMessage());
			return null;
		}

	}

	public Candidates readCertainCandidate(String id) {
		Candidates c = null;
		try {
			Statement stmt = conn.createStatement();
			String sql = "use vaalikone;";
			stmt.executeUpdate(sql);
			sql = "select * from candidates where candidate_id=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet RS = pstmt.executeQuery();
			// Tietyn kandidaatin tiedot
			while (RS.next()) {
				c = new Candidates();
				c.setId(RS.getInt("candidate_id"));
				c.setfirstname(RS.getString("firstname"));
				c.setsurname(RS.getString("surname"));
				c.setParty(RS.getString("party"));
				c.setAge(RS.getInt("age"));
				c.setProfession(RS.getString("profession"));
				c.setWhat(RS.getString("what"));
				c.setWhy(RS.getString("why"));
				c.setVote_nro(RS.getInt("vote_nro"));
			}
			return c;
		} catch (SQLException e) {
			System.out.println("Read certain candidates: " + e.getMessage());
			return null;
		}
	}

	public ArrayList<AnswersC> readAllAnswersC() {
		ArrayList<AnswersC> list = new ArrayList<>();
		try {

			Statement stmt = conn.createStatement();
			ResultSet RS = stmt.executeQuery("select * from answers");
			while (RS.next()) {
				AnswersC a = new AnswersC();
				a.setId(RS.getInt("answer_id"));
				a.setCandidateId(RS.getInt("candidate_id"));
				a.setQuestionId(RS.getInt("question_id"));
				a.setanswerint(RS.getInt("answer_int"));
				a.setanswerstring(RS.getString("answer_string"));

				list.add(a);
			}
			return list;
		} catch (SQLException e) {
			System.out.println("Read all answers C: " + e.getMessage());
			return null;
		}

	}

	public ArrayList<Integer> readCertainAnswersC(int id) {
		ArrayList<Integer> list = new ArrayList<>();
		try {
			Statement stmt = conn.createStatement();
			String sql = "use vaalikone;";
			stmt.executeUpdate(sql);
			sql = "select * from answers where candidate_id = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet RS = pstmt.executeQuery();
			while (RS.next()) {
				list.add(RS.getInt("answer_int"));
			}
			return list;
		} catch (SQLException e) {
			System.out.println("Read some answers: " + e.getMessage());
			return null;
		}

	}

	public ArrayList<Integer> addComparison(int candidate, int average) {
		ArrayList<Integer> list = new ArrayList<>();
		try {
			Statement stmt = conn.createStatement();
			String sql = "use vaalikone;";
			stmt.executeUpdate(sql);
			sql = "update comparison set average = " + average + " where candidate_id = " + candidate + ";";
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("comparison: " + e.getMessage());
			return null;
		}
		return list;
	}

	public ArrayList<Candidates> updateCandidate(Candidates c) {
		try {
			Statement stmt = conn.createStatement();
			String sql = "use vaalikone;";
			stmt.executeUpdate(sql);
			sql = "update candidates set firstname=?, surname=?, age=?, party=?, profession=?, why=?, what=?, vote_nro=? where candidate_id=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, c.getfirstname());
			pstmt.setString(2, c.getsurname());
			pstmt.setInt(3, c.getAge());
			pstmt.setString(4, c.getParty());
			pstmt.setString(5, c.getProfession());
			pstmt.setString(6, c.getWhy());
			pstmt.setString(7, c.getWhat());
			pstmt.setInt(8, c.getVote_nro());
			pstmt.setInt(9, c.getId());
			pstmt.executeUpdate();
			return readAllCandidates();
		} catch (SQLException e) {
			System.out.println("update candidate: " + e.getMessage());
			return null;
		}
	}

	public ArrayList<Candidates> deleteCandidate(String id) {
		try {
			Statement stmt = conn.createStatement();
			String sql = "use vaalikone;";
			stmt.executeUpdate(sql);
			sql = "delete from answers where candidate_id=" + id;
			stmt.executeUpdate(sql);
			sql = "delete from candidates where candidate_id=" + id;
			stmt.executeUpdate(sql);
			sql = "alter table candidates auto_increment = 1";
			stmt.executeUpdate(sql);
			return readAllCandidates();
		} catch (SQLException e) {
			System.out.println("Deletoi: " + e.getMessage());
			return null;
		}
	}

	public ArrayList<Comparison> readAllComparison() {
		ArrayList<Comparison> list = new ArrayList<>();
		try {
			Statement stmt = conn.createStatement();
			String sql = "";
			PreparedStatement statement = conn.prepareStatement(sql);
			sql = "use vaalikone";
			statement.executeUpdate(sql);
			ResultSet RS = stmt.executeQuery(
					"select * from candidates join comparison on candidates.candidate_id = comparison.comp_id order by average desc;");
			while (RS.next()) {
				Comparison c = new Comparison();
				c.setComparisonID(RS.getInt("comp_id"));
				c.setId(RS.getInt("candidate_id"));
				c.setComparisonPercent(RS.getInt("average"));
				c.setFirstname(RS.getString("firstname"));
				c.setLastname(RS.getString("surname"));
				c.setParty(RS.getString("party"));
				c.setVote(RS.getInt("vote_nro"));
				c.setC_id(RS.getInt("candidate_id"));
				list.add(c);
			}
			return list;
		} catch (SQLException e) {
			System.out.println("Read all comparisons: " + e.getMessage());
			return null;
		}
	}

	public ArrayList<Candidates> addCandidate(String surname, String firstname, int age, String party,
			String profession, String why, String what, int vote_nro) {
		try {
			String sql = "";
			PreparedStatement stmt = conn.prepareStatement(sql);
			sql = "use vaalikone";
			stmt.executeUpdate(sql);
			sql = "INSERT INTO candidates (surname, firstname, age, party, profession, why, what, vote_nro) VALUES (\""
					+ surname + "\", \"" + firstname + "\", " + age + ", \"" + party + "\", \"" + profession + "\", \""
					+ why + "\", \"" + what + "\", " + vote_nro + ");";
			stmt.executeUpdate(sql);
			return readAllCandidates();
		} catch (SQLException e) {
			System.out.println("Add candidate: " + e.getMessage());
			return null;
		}

	}

	// Tietylle kandidaatille kysymykset ja niille vastaukset
	public ArrayList<SingleCandidateAnswers> readCertainCandidates(String id) {
		ArrayList<SingleCandidateAnswers> list = new ArrayList<>();
		try {
			Statement stmt = conn.createStatement();
			String sql = "";
			PreparedStatement statement = conn.prepareStatement(sql);
			sql = "use vaalikone";
			statement.executeUpdate(sql);
			// Right join SQL
			ResultSet RS = stmt.executeQuery(
					"select questions.question, answers.answer_int FROM answers RIGHT JOIN questions ON answers.question_id = questions.question_id WHERE candidate_id = "
							+ id + ";");
			while (RS.next()) {
				SingleCandidateAnswers c = new SingleCandidateAnswers();
				c.setQuestion(RS.getString("question"));
				c.setAnswer_int(RS.getInt("answer_int"));
				// System.out.println(c);
				list.add(c);
			}
			// System.out.println(list);
			return list;
		} catch (SQLException e) {
			System.out.println("Certain candidates questions + answers: " + e.getMessage());
			return null;
		}

	}

}
