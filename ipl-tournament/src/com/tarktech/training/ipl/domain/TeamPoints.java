package com.tarktech.training.ipl.domain;

public class TeamPoints {
    private Team team;
    private int points;

    public TeamPoints(Team team) {
        this.team = team;
        this.points = 0;
    }

    public void addPoints(int points){
        this.points += points;
    }

    public Team getTeam() {
        return team;
    }

    public int getPoints() {
        return points;
    }
}
