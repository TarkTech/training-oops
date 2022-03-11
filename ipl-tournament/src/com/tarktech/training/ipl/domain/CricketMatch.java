package com.tarktech.training.ipl.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CricketMatch {
    private Team team1;
    private Team team2;
    private LocalDate scheduledOn;
    private List<Inning> innings;

    public CricketMatch(Team team1, Team team2){
        this.team1 = team1;
        this.team2 = team2;
        innings = new ArrayList<>();
    }

    public void scheduleOn(LocalDate scheduledDate){
        this.scheduledOn = scheduledDate;
    }

    public void coinTossed(String teamToBatFirst){
        Team teamToBatInFirstInning = team1.getName().equals(teamToBatFirst) ? team1 : team2;
        Team teamToBowlInFirstInning = team1.getName().equals(teamToBatFirst) ? team2 : team1;

        innings.add(new Inning(teamToBatInFirstInning, teamToBowlInFirstInning));
        innings.add(new Inning(teamToBowlInFirstInning, teamToBatInFirstInning));
    }

    public Inning getFirstInning(){
        validateCoinTossed();
        return innings.get(0);
    }

    public Inning getSecondInning(){
        validateCoinTossed();
        return innings.get(1);
    }

    public Team getTeam1(){
        return team1;
    }

    public Team getTeam2(){
        return team2;
    }

    private void validateCoinTossed() {
        if(innings.isEmpty()){
            throw new RuntimeException("Innings not decided yet! Make sure that the match is scheduled and coin tossed");
        }
    }

    public boolean isTied() {
        return false;
    }

    public Team getWinningTeam() {
        return null;
    }
}
