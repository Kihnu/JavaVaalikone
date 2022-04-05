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

/**
 * Servlet implementation class AddCandidate
 */
@WebServlet("/AddCandidate")
public class AddCandidate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao;

	@Override
	public void init() {
		dao = new Dao("jdbc:mysql://localhost:3306/", "user", "password");
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddCandidate() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		String firstname = request.getParameter("firstname");
		String surname = request.getParameter("surname");
		String age = request.getParameter("age");
		String party = request.getParameter("party");
		String profession = request.getParameter("pro");
		String why = request.getParameter("why");
		String what = request.getParameter("what");
		String vote = request.getParameter("vote");
		
		int age_i = Integer.parseInt(age);
		int vote_i = Integer.parseInt(vote);

		if (dao.getConnection()) {
			dao.addCandidate(surname, firstname, age_i, party, profession, why, what, vote_i);
		} else {
			System.out.println("No connection to database");
		}
		
		ArrayList<Candidates> candidates=null;
		if (dao.getConnection()){
			candidates=dao.readAllCandidates();
		}
		else {
			System.out.println("No connection to database");
		}
		request.setAttribute("candidates", candidates);
		
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/EditCandidates.jsp");
		rd.forward(request, response);

	}

}
