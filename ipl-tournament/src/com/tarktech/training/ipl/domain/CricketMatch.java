package com.tarktech.training.ipl.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CricketMatch {
    private Team team1;
    private Team team2;
    private Date scheduledOn;
    private List<Inning> innings;

    public CricketMatch(Team team1, Team team2){
        this.team1 = team1;
        this.team2 = team2;
        innings = new ArrayList<>();
    }

    public void scheduleOn(Date scheduledDate){
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

    private void validateCoinTossed() {
        if(innings.isEmpty()){
            //throw new RuntimeException("Innings not decided yet! Make sure that the match is scheduled and coin tossed");
            System.out.println("please Toss the coin again");
        }
    }
}
