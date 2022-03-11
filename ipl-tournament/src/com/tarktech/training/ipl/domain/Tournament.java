package com.tarktech.training.ipl.domain;

import com.tarktech.training.ipl.MatchScheduler;
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
        MatchScheduler matchScheduler = new MatchScheduler();
        this.leagueRoundMatches = matchScheduler.scheduleLeagueRound(teams, tournamentStartDate);
        return this.leagueRoundMatches;
    }

    public List<CricketMatch> playLeagueRound() {
        MatchSimulator matchSimulator = new MatchSimulator();

        for (CricketMatch cricketMatch : leagueRoundMatches) {
            Team team1 = cricketMatch.getTeam1();
            Team team2 = cricketMatch.getTeam2();

            matchSimulator.playMatch(cricketMatch);

            team1.matchPlayed(cricketMatch);
            team2.matchPlayed(cricketMatch);
        }
        return leagueRoundMatches;
    }

    public void scheduleSemifinals() {
    }

    public void playSemifinals() {

    }

    public void scheduleFinal() {

    }

    public void playFinal() {

    }
}
