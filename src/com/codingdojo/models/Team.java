package com.codingdojo.models;

import java.util.ArrayList;

public class Team {
	private String teamName;
	private ArrayList<Player> players = new ArrayList<Player>();
	
	public Team(String teamName) {
		this.setTeamName(teamName);
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}
	
}
