package com.codingdojo.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.codingdojo.models.Player;
import com.codingdojo.models.Team;

/**
 * Servlet implementation class DeletePlayer
 */
@WebServlet("/DeletePlayer")
public class DeletePlayer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePlayer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
//		process request
		HttpSession session = request.getSession();
		
		@SuppressWarnings("unchecked")
		ArrayList<Team> allTeams = (ArrayList<Team>) session.getAttribute("roster");
		int team_id = Integer.parseInt(request.getParameter("id"));
		int player_id = Integer.parseInt(request.getParameter("player_id"));
		
		Team user_team = allTeams.get(team_id);
		ArrayList<Player> allPlayers = user_team.getPlayers();
		
		allPlayers.remove(player_id);
		allTeams.set(team_id, user_team);
		
		session.setAttribute("roster", allTeams);
		response.sendRedirect("Teams?id="+team_id);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
