package com.tarktech.training.ipl;

import com.tarktech.training.ipl.domain.*;
import com.tarktech.training.ipl.util.PrettyPrinter;
import com.tarktech.training.ipl.util.TeamRepository;

import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        TeamRepository teamRepository = new TeamRepository();

        List<Team> teams = teamRepository.findAllTeams();
        PrettyPrinter.printTeamDetails(teams);
        LocalDate tournamentStartDate = LocalDate.of(2022, 3, 15);

        Tournament tournament = new Tournament(teams, tournamentStartDate);

        List<CricketMatch> scheduledMatches = tournament.scheduleLeagueRound();
        PrettyPrinter.printMatchSchedule(scheduledMatches);

        List<CricketMatch> playedMatches = tournament.playLeagueRound();
        PrettyPrinter.printMatchDetails(playedMatches.get(0));

        Inning firstInning = playedMatches.get(0).getFirstInning();
        Team teamToBat = firstInning.getTeamToBat();
        Team teamToBowl = firstInning.getTeamToBowl();

        System.out.println("Total runs: " + firstInning.getTotalRuns());
        System.out.println("Total wickets: " + firstInning.getTotalWickets());

        Player batsman = teamToBat.getPlayerList().get(0);
        System.out.println("Runs made by: " + firstInning.getTotalRunsScoredByPlayer(batsman));
        System.out.println("Batsman: " + batsman.getName());

        Player bowler = teamToBowl.getPlayerList().get(10);
        System.out.println("Bowler: " + bowler.getName());

        System.out.println("Total Runs given by: " + firstInning.getTotalRunsGivenByBowler(bowler));
        System.out.println("Total Wickets taken by: " + firstInning.getTotalWicketsTakenByBowler(bowler));



        tournament.scheduleSemifinals();
        tournament.playSemifinals();

        tournament.scheduleFinal();
        tournament.playFinal();

    }
}
