package com.tarktech.training.ipl.util;

import com.tarktech.training.ipl.domain.Player;

import java.util.List;

public class LiveInningStatistics {
    private int totalRuns;
    private int totalWickets;
    private List<Player> batters;
    private List<Player> bowlers;
    private Player strikerPlayer;
    private Player nonStrikerPlayer;
    private Player bowler;
    private int nextBattingPosition;
    private boolean isInningOver;

    public LiveInningStatistics( List<Player> batters, List<Player> bowlers) {
        this.totalRuns = 0;
        this.totalWickets = 0;
        this.batters = batters;
        this.bowlers = bowlers;
        this.strikerPlayer = batters.get(0);
        this.nonStrikerPlayer = batters.get(1);
        this.bowler = bowlers.get(0);
        this.nextBattingPosition = 3;
        this.isInningOver = false;
    }

    public int getTotalRuns() {
        return totalRuns;
    }

    public int getTotalWickets() {
        return totalWickets;
    }

    public Player getStrikerPlayer() {
        return strikerPlayer;
    }

    public Player getNonStrikerPlayer() {
        return nonStrikerPlayer;
    }

    public Player getBowler() {
        return bowler;
    }

    public void changeStrike() {
        Player tempPlayer = this.strikerPlayer;
        this.strikerPlayer = this.nonStrikerPlayer;
        this.nonStrikerPlayer = tempPlayer;
    }

    public void addRuns(int runs) {
        this.totalRuns += runs;
    }

    public boolean isInningOver() {
        return isInningOver;
    }

    public void addWicket() {
        this.totalWickets += 1;
        if(nextBattingPosition > 11){ // nextBattingPosition is 1 based index, like real world cricket
            this.isInningOver= true;
        }

        this.strikerPlayer = isInningOver ? null : batters.get(nextBattingPosition - 1);
        this.nextBattingPosition += 1;
    }

    public void changeBowler(int i) {
        this.bowler = bowlers.get(i % bowlers.size());
    }

    public void isTargetChased(int target){
        if (target != -1 && this.totalRuns > target) {
            this.isInningOver = true;
        }
    }
}
