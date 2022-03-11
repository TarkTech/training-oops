package com.tarktech.training.ipl.util;

import com.tarktech.training.ipl.domain.Player;
import com.tarktech.training.ipl.domain.PlayerRole;
import com.tarktech.training.ipl.domain.Team;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TeamRepository {
    public List<Team> findAllTeams() {
        //TODO: add teams.csv and players.csv inside resource folder/package
        //Read these csvs and implement this method
        ArrayList<Team> teams = new ArrayList<>();
        String line = "";
        String splitBy = ",";
        boolean firstLine = true;
        try {
            //parsing a CSV file into BufferedReader class constructor
            BufferedReader br = new BufferedReader(new FileReader("src/com/tarktech/training/ipl/resource/Teams.csv"));
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                if (!firstLine) {
                    String[] teamDetails = line.split(splitBy);// use comma as separator
                    Team team = new Team(teamDetails[0], findPlayerByTeamName(teamDetails[0]));
                    teams.add(team);
                }
                firstLine = false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return teams;
    }

    private PlayerRole getPlayerRoleFromString(String playerRole) {
        if (playerRole.equals("Batsman") || playerRole.equals("WK-Batsman")) {
            return PlayerRole.Batsman;
        } else if (playerRole.equals("Bowlers") || playerRole.equals("Bowler")) {
            return PlayerRole.Bowler;
        } else {
            return PlayerRole.AllRounder;
        }
    }

    private ArrayList<Player> findPlayerByTeamName(String teamName) {
        ArrayList<Player> players = new ArrayList<Player>();
        String line = "";
        String splitBy = ",";
        try {
            //parsing a CSV file into BufferedReader class constructor
            BufferedReader br = new BufferedReader(new FileReader("src/com/tarktech/training/ipl/resource/Players.csv"));
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] playerDetails = line.split(splitBy);    // use comma as separator
                if (playerDetails[0].equals(teamName)) {

                    Player player = new Player(playerDetails[1], getPlayerRoleFromString(playerDetails[3].trim()));
                    players.add(player);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return players;
    }
}
