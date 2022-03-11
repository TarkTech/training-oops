package com.tarktech.training.ipl.domain;

import java.time.LocalDate;

public class CricketMatch {
    private Team team1;
    private Team team2;
    private LocalDate scheduledOn;
    private Inning firstInning;
    private Inning secondInning;

    public CricketMatch(Team team1, Team team2) {
        this.team1 = team1;
        this.team2 = team2;
    }

    public void scheduleOn(LocalDate scheduledDate) {
        this.scheduledOn = scheduledDate;
    }

    public void tossCoin() {
        Team teamToBatFirst = Coin.toss() == Coin.Head ? this.team1 : this.team2;

        Team teamToBatInFirstInning = teamToBatFirst == team1 ? team1 : team2;
        Team teamToBowlInFirstInning = teamToBatFirst == team1 ? team2 : team1;

        firstInning = new Inning(teamToBatInFirstInning, teamToBowlInFirstInning);
        secondInning = new Inning(teamToBowlInFirstInning, teamToBatInFirstInning);
    }

    public Inning getFirstInning() {
        return firstInning;
    }

    public Inning getSecondInning() {
        return secondInning;
    }

    public Team getTeam1() {
        return team1;
    }

    public Team getTeam2() {
        return team2;
    }

    @Override
    public String toString() {
        return String.format("%s vs %s on %s", team1, team2, scheduledOn);
    }
}
