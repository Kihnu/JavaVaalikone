package app;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Dao;
import data.Candidates;
import data.Questions;

/**
 * Servlet implementation class Comparison
 */
@WebServlet("/Comparison")
public class Comparison extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao;
	private Questions questions;

	@Override
	public void init() {
		dao = new Dao("jdbc:mysql://localhost:3306/", "user", "password");
		questions = new Questions();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Comparison() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// response.getWriter().append("Served at: ").append(request.getContextPath());

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int number;

		ArrayList<Questions> questionlist = null;
		ArrayList<Candidates> candidates = null;
		ArrayList<Integer> candidateanswers = null;

		ArrayList<Integer> userlist = new ArrayList<>();
		ArrayList<Integer> candidatelist = null;

		ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();

		if (dao.getConnection()) {
			questionlist = dao.readAllQuestions();
		} else {
			System.out.println("No connection to database");
		}

		for (int i = 0; i < questionlist.size(); i++) {
			String answer = request.getParameter("answer" + (i + 1));
			if (answer.equals("option1")) {
				number = 1;
			} else if (answer.equals("option2")) {
				number = 2;
			} else if (answer.equals("option3")) {
				number = 3;
			} else if (answer.equals("option4")) {
				number = 4;
			} else {
				number = 5;
			}
			userlist.add(questions.getId() + i, number);

		}

		int id;
		candidates = dao.readAllCandidates();

		for (id = 1; id < candidates.size() + 1; id++) {
			candidatelist = new ArrayList<>();
			candidateanswers = dao.readCertainAnswersC(id);
			for (int j = 0; j < candidateanswers.size(); j++) {
				candidatelist.add(questions.getId() + j, candidateanswers.get(j));
			}
			lists.add(candidatelist);
			System.out.println("Ehdokas " + id + " vastaukset: " + lists.get(id - 1));
		}
		System.out.println("Kayttajan vastaukset: " + userlist);

		int user_num;
		int candid_num;
		int sum = 0;
		int y = 0;
		int z= 0;
		
		ArrayList<Integer> comparison = null;
		
		for (int x = 0; x < lists.size(); x++) {
			comparison = new ArrayList<>();
			candidatelist = lists.get(x);
			for (y = 0; y < userlist.size(); y++ ) {
				user_num = userlist.get(y);
				candid_num = candidatelist.get(y);
				int bigger = Math.max(user_num, candid_num);
				int smaller = Math.min(user_num, candid_num);
				int diff = bigger - smaller;
				int percentage = diff * 25;
				int comp = 100 - percentage;
				comparison.add(comp);
			}
			for (z = 0; z < comparison.size(); z++) {
				sum = sum + comparison.get(z);
			}
			System.out.println("SUMMA :" + sum);
			int average = sum / comparison.size();
			System.out.println("TAMA ON TULOSSA DATABASEE: " + (x+1) + " - " + average + " %");
			dao.addComparison(x+1, average);
			sum = 0;
		}
		RequestDispatcher rd=request.getRequestDispatcher("Results");
		rd.forward(request, response);
		// ehdokkaiden vastaustietokanta
		
		// request.setAttribute("AnswersC", candidateanswers);
		doGet(request, response);
	}

}
