package com.tarktech.training.ipl.domain;

import java.util.ArrayList;
import java.util.List;

public class Inning {
    private Team teamToBat;
    private Team teamToBowl;

    private List<Over> oversPlayed;

    public Inning(Team teamToBat, Team teamToBowl) {
        this.teamToBat = teamToBat;
        this.teamToBowl = teamToBowl;
        oversPlayed = new ArrayList<>();
    }

    public void overPlayed(Over over) {
        oversPlayed.add(over);
    }

    public Team getTeamToBat() {
        return teamToBat;
    }

    public Team getTeamToBowl() {
        return teamToBowl;
    }

    public List<Over> getOversPlayed() {
        return oversPlayed;
    }

    public int getTotalRuns() {
        int totalRuns = 0;
        for (Over overPlayed : oversPlayed) {
            totalRuns += overPlayed.getTotalRuns();
        }
        return totalRuns;
    }

    public int getTotalWickets() {
        int totalWickets = 0;
        for (Over overPlayed : oversPlayed) {
            totalWickets += overPlayed.getTotalWickets();
        }
        return totalWickets;
    }

    public int getTotalRunsScoredByPlayer(Player player) {
        int totalRuns = 0;
        for (Over overPlayed : oversPlayed) {
            for (BallDelivery ballDelivery : overPlayed.getBallsDelivered()) {
                if (ballDelivery.getStrikerPlayer() == player) {
                    totalRuns += ballDelivery.getRunsScoredByBatsman();
                }
            }
        }
        return totalRuns;
    }

    public int getTotalRunsGivenByBowler(Player player) {
        int totalRuns = 0;
        for (Over overPlayed : oversPlayed) {
            for (BallDelivery ballDelivery : overPlayed.getBallsDelivered()) {
                if (ballDelivery.getBowledBy() == player) {
                    totalRuns += ballDelivery.getTotalRuns();
                }
            }
        }
        return totalRuns;
    }

    public int getTotalWicketsTakenByBowler(Player player) {
        int totalWickets = 0;
        for (Over overPlayed : oversPlayed) {
            for (BallDelivery ballDelivery : overPlayed.getBallsDelivered()) {
                if (ballDelivery.getBowledBy() == player
                        && ballDelivery.getWicketDismissal() != null
                        && ballDelivery.getWicketDismissal() != WicketDismissal.RunOut) {
                    totalWickets ++;
                }
            }
        }
        return totalWickets;
    }


    @Override
    public String toString() {
        return String.format("Batting team: %s, Bowling team: %s", teamToBat, teamToBowl);
    }
}
