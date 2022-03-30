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
 * Servlet implementation class Admin
 */
@WebServlet("/AdminCandidates")
public class AdminCandidates extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao;
	
	@Override
	public void init() {
		dao = new Dao("jdbc:mysql://localhost:3306/", "user", "password");
	}
	
    public AdminCandidates() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Candidates> candidates=null;
		if (dao.getConnection()){
			candidates=dao.readAllCandidates();
		}
		else {
			System.out.println("No connection to database");
		}
		request.setAttribute("candidatesList", candidates);
		
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/EditCandidates.jsp");
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