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
 * Servlet implementation class Players
 */
@WebServlet("/Players")
public class Players extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Players() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HttpSession session = request.getSession();
		if(request.getParameter("id") == null) {
			response.sendRedirect("Home");
		} else {
			int user_id = Integer.parseInt(request.getParameter("id"));
			
			@SuppressWarnings("unchecked")
			ArrayList<Team> allTeams = (ArrayList<Team>) session.getAttribute("roster");
			
			Team user_team = allTeams.get(user_id);
			ArrayList<Player> allPlayers = user_team.getPlayers();
			request.setAttribute("allPlayers", allPlayers);
			request.setAttribute("user_team", user_team);
			request.setAttribute("user_id", user_id);
			
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/NewPlayer.jsp");
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
		int id = Integer.parseInt(request.getParameter("id"));
		Team user_team = allTeams.get(id);
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		int age = Integer.parseInt(request.getParameter("age"));
		Player newPlayer = new Player(firstName, lastName, age);
		
		user_team.getPlayers().add(newPlayer);
		allTeams.set(id,  user_team);
		
		session.setAttribute("roster", allTeams);
		response.sendRedirect("Teams?id="+id);

		
	}

}
