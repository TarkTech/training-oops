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


    @Override
    public String toString() {
        return String.format("Batting team: %s, Bowling team: %s", teamToBat, teamToBowl);
    }
}
