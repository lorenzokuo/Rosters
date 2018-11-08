package com.codingdojo.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.codingdojo.models.Player;
import com.codingdojo.models.Team;

/**
 * Servlet implementation class Teams
 */
@WebServlet("/Teams")
public class Teams extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Teams() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
//		instantiate session, indicate to our servlet that we want to use. We do this by asking our request to get the session for us:
		HttpSession session = request.getSession();
//		process request
		if(request.getParameter("id") == null) {
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/NewTeam.jsp");
			view.forward(request, response);
		} else {
			int user_id = Integer.parseInt(request.getParameter("id"));
			
			@SuppressWarnings("unchecked")
			ArrayList<Team> allTeams = (ArrayList<Team>) session.getAttribute("roster");
			
			Team user_team = allTeams.get(user_id);
			ArrayList<Player> allPlayers = user_team.getPlayers();
			request.setAttribute("allPlayers", allPlayers);
			request.setAttribute("user_team", user_team);
			request.setAttribute("user_id", user_id);
			
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/TeamInfo.jsp");
			view.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		ArrayList<Team> allTeams = (ArrayList<Team>) session.getAttribute("roster");
		
		Team newTeam = new Team(request.getParameter("teamName"));
		
		allTeams.add(newTeam);
		session.setAttribute("roster", allTeams);
		response.sendRedirect("Home");
		
	}

}
