package com.tarktech.training.ipl.domain;

import java.time.LocalDate;

public class CricketMatch {
    private Team team1;
    private Team team2;
    private LocalDate scheduledOn;
    private Inning firstInning;
    private Inning secondInning;

    public CricketMatch(Team team1, Team team2){
        this.team1 = team1;
        this.team2 = team2;
    }

    public void scheduleOn(LocalDate scheduledDate){
        this.scheduledOn = scheduledDate;
    }

//    public void coinTossed(String teamToBatFirst){
    public void coinTossed(){
        int coinSideWon = (int) Math.round(Math.random());
        String teamToBatFirst;
        if (coinSideWon == 0) {
             teamToBatFirst = this.team1.getName();
        }else{
            teamToBatFirst = this.team2.getName();
        }

        Team teamToBatInFirstInning = team1.getName().equals(teamToBatFirst) ? team1 : team2;
        Team teamToBowlInFirstInning = team1.getName().equals(teamToBatFirst) ? team2 : team1;

        firstInning = new Inning(teamToBatInFirstInning, teamToBowlInFirstInning);
        secondInning = new Inning(teamToBowlInFirstInning, teamToBatInFirstInning);
    }

    public Inning getFirstInning(){
        validateCoinTossed();
        return firstInning;
    }

    public Inning getSecondInning(){
        validateCoinTossed();
        return secondInning;
    }

    public Team getTeam1(){
        return team1;
    }

    public Team getTeam2(){
        return team2;
    }

    private void validateCoinTossed() {
        if(firstInning == null || secondInning == null){
            throw new RuntimeException("Innings not decided yet! Make sure that the match is scheduled and coin tossed");
        }
    }

    public boolean isTied() {
        return false;
    }

    public Team getWinningTeam() {
        return null;
    }

    @Override
    public String toString(){
        return String.format("%s vs %s on %s", team1, team2, scheduledOn);
    }
}
