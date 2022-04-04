package app;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Dao;
import data.Candidates;

/**
 * Servlet implementation class SingleCandidate
 */
@WebServlet("/SingleCandidate")
public class SingleCandidate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Dao dao;

	@Override
	public void init() {
		dao = new Dao("jdbc:mysql://localhost:3306/", "user", "password");
	}
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SingleCandidate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		String id=request.getParameter("id");
		Candidates candidate = null;

		if (dao.getConnection()) {
			candidate = dao.readCertainCandidate(id);
			// daosta kandidaatille kysymykset
			// daosta kandidaatin vastaukset kysymyksiin
		} else {
			System.out.println("No connection to database");
		}
	
		request.setAttribute("candidate", candidate);
		
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/SingleCandidateJSP.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
