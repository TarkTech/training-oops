package com.tarktech.training.ipl.domain;

import java.util.ArrayList;
import java.util.List;

public class Tournament {
    private List<Team> teams;

    private List<CricketMatch> leagueRoundMatches;

    private List<CricketMatch> semiFinalMatches;

    private CricketMatch finalMatch;

    public Tournament(List<Team> teams) {
        this.teams = teams;
        leagueRoundMatches = new ArrayList<>();
        semiFinalMatches = new ArrayList<>();
    }

    public void scheduleLeagueRound(List<CricketMatch> leagueRoundMatches) {
        this.leagueRoundMatches = leagueRoundMatches;
    }

    public void scheduleSemifinalMatch(CricketMatch semiFinalMatch) {
        semiFinalMatches.add(semiFinalMatch);
    }

    public void scheduleFinalMatch(CricketMatch finalMatch){
        this.finalMatch = finalMatch;
    }
}
