package com.tarktech.training.ipl.domain;

import com.tarktech.training.ipl.SimpleMatchScheduler;
import com.tarktech.training.ipl.util.MatchSimulator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Tournament {
    private List<Team> teams;
    private LocalDate tournamentStartDate;

    private List<CricketMatch> leagueRoundMatches;

    private List<CricketMatch> semiFinalMatches;

    private CricketMatch finalMatch;

    public Tournament(List<Team> teams, LocalDate tournamentStartDate) {
        this.teams = teams;
        this.tournamentStartDate = tournamentStartDate;
        leagueRoundMatches = new ArrayList<>();
        semiFinalMatches = new ArrayList<>();
    }

    public List<CricketMatch> scheduleLeagueRound() {
        SimpleMatchScheduler matchScheduler = new SimpleMatchScheduler();
        this.leagueRoundMatches = matchScheduler.scheduleLeagueRound(teams, tournamentStartDate);
        return this.leagueRoundMatches;
    }

    public List<CricketMatch> playLeagueRound() {
        MatchSimulator matchSimulator = new MatchSimulator();

        for (CricketMatch cricketMatch : leagueRoundMatches) {
            matchSimulator.playMatch(cricketMatch);
        }
        return leagueRoundMatches;
    }
}
