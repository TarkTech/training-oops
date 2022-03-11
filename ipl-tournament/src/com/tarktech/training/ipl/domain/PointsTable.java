package com.tarktech.training.ipl.domain;

import java.util.*;

public class PointsTable {
    private Map<String, TeamPoints> pointsPerTeam;

    public PointsTable(List<Team> teams, List<CricketMatch> cricketMatches) {
        pointsPerTeam = new HashMap<>();

        for (Team team : teams) {
            pointsPerTeam.put(team.getName(), new TeamPoints(team));
        }

        for (CricketMatch cricketMatch : cricketMatches) {
            if (cricketMatch.isTied()) {
                String team1 = cricketMatch.getTeam1().getName();
                String team2 = cricketMatch.getTeam2().getName();

                pointsPerTeam.get(team1).addPoints(1);
                pointsPerTeam.get(team2).addPoints(1);
            } else {
                String winningTeam = cricketMatch.getWinningTeam().getName();
                pointsPerTeam.get(winningTeam).addPoints(2);
            }
        }
    }

    public List<TeamPoints> getTeamPoints() {
        List<TeamPoints> teamPoints = new ArrayList<>(pointsPerTeam.values());
        // Sort by points
        return teamPoints;
    }
}
