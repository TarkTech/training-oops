package com.tarktech.training.ipl.util;

import com.tarktech.training.ipl.domain.*;

import java.util.List;

public class PrettyPrinter {
    public static void printTeamDetails(Team team) {
        System.out.println(); //Intentionally left blank

        System.out.println("Team: " + team.getName());
        team.getPlayerList()
                .forEach(player -> System.out.println("Player: " + player.getName() + ", Role: " + player.getRole() + ", Jersey Number: " + player.getJerseyNo()));

        System.out.println(); //Intentionally left blank

    }

    public static void printTeamDetails(List<Team> teams) {
        System.out.println(); //Intentionally left blank
        System.out.println("Total teams: " + teams.size());
        teams.forEach(PrettyPrinter::printTeamDetails);
    }

    public static void printMatchDetails(CricketMatch cricketMatch) {
        System.out.println(); //Intentionally left blank

        System.out.println("Match: " + cricketMatch);

        printInningDetails(cricketMatch.getFirstInning());
        System.out.println(); //Intentionally left blank
        printInningDetails(cricketMatch.getSecondInning());
        System.out.println(); //Intentionally left blank
    }

    public static void printMatchResult(List<CricketMatch> cricketMatches) {
        System.out.println(); //Intentionally left blank
        System.out.println("Total Matches: " + cricketMatches.size());
        cricketMatches.forEach(PrettyPrinter::printMatchResult);
        System.out.println(); //Intentionally left blank
    }

    public static void printMatchResult(CricketMatch cricketMatch) {
        int runsScoredInFirstInning = getTotalRuns(cricketMatch.getFirstInning());
        int extraRunsScoredInFirstInning = getExtraRuns(cricketMatch.getFirstInning());
        int totalWicketsInFirstInning = getTotalWickets(cricketMatch.getFirstInning());
        String totalOversPlayedInFirstInning = getTotalOversPlayed(cricketMatch.getFirstInning());

        int runsScoredInSecondInning = getTotalRuns(cricketMatch.getSecondInning());
        int extraRunsScoredInSecondInning = getExtraRuns(cricketMatch.getSecondInning());
        int totalWicketsInSecondInning = getTotalWickets(cricketMatch.getSecondInning());
        String totalOversPlayedInSecondInning = getTotalOversPlayed(cricketMatch.getSecondInning());

        System.out.println(); //Intentionally left blank
        System.out.println("Summary of Match: " + cricketMatch);
        System.out.println("First inning: " + cricketMatch.getFirstInning());
        System.out.printf("Runs Total (Extras): %s (%s), Wickets: %s, Overs: %s%n", runsScoredInFirstInning, extraRunsScoredInFirstInning, totalWicketsInFirstInning, totalOversPlayedInFirstInning);

        System.out.println(); //Intentionally left blank
        System.out.println("Second inning: " + cricketMatch.getSecondInning());
        System.out.printf("Runs Total (Extras): %s (%s), Wickets: %s, Overs: %s%n", runsScoredInSecondInning, extraRunsScoredInSecondInning, totalWicketsInSecondInning, totalOversPlayedInSecondInning);

        System.out.println(); //Intentionally left blank
    }

    private static String getTotalOversPlayed(Inning inning) {
        List<Over> oversPlayed = inning.getOversPlayed();
        Over lastOver = oversPlayed.get(oversPlayed.size() - 1);

        long ballsPlayedInLastOver = lastOver.getBallsDelivered()
                .stream()
                .filter(ballDelivery -> ballDelivery.getDeliveryType() == BallDeliveryType.Normal)
                .count();

        if (ballsPlayedInLastOver == 6) {
            return String.format("%d", oversPlayed.size());
        } else {
            return String.format("%d.%d", oversPlayed.size()-1, ballsPlayedInLastOver);
        }
    }

    private static int getExtraRuns(Inning inning) {
        return inning.getOversPlayed()
                .stream()
                .flatMap(over -> over.getBallsDelivered().stream())
                .map(BallDelivery::getExtraRuns)
                .reduce(0, Integer::sum);

    }

    private static int getTotalWickets(Inning inning) {
        long totalWickets = inning.getOversPlayed()
                .stream()
                .flatMap(over -> over.getBallsDelivered().stream())
                .filter(ballDelivery -> ballDelivery.getWicketDismissal() != null)
                .count();

        return (int) totalWickets;
    }

    private static Integer getTotalRuns(Inning inning) {
        return inning.getOversPlayed()
                .stream()
                .flatMap(over -> over.getBallsDelivered().stream())
                .map(ballDelivery -> ballDelivery.getRunsScoredByBatsman() + ballDelivery.getExtraRuns())
                .reduce(0, Integer::sum);
    }

    private static void printInningDetails(Inning inning) {
        System.out.println("Started Inning: " + inning);
        inning.getOversPlayed().forEach(PrettyPrinter::printOverDetails);
        System.out.println("Finished Inning: " + inning);

    }

    private static void printOverDetails(Over over) {
        System.out.println("Over: " + over.getOverNumber());
        over.getBallsDelivered().forEach(PrettyPrinter::printBallDeliveryDetails);
    }

    private static void printBallDeliveryDetails(BallDelivery ballDelivery) {
        System.out.println("Runs: " + ballDelivery.getRunsScoredByBatsman() + " Wicket: " + ballDelivery.getWicketDismissal() + " Extras: " + ballDelivery.getExtraRuns() + " Ball Delivery: " + ballDelivery.getDeliveryType() + " Bowler: " + ballDelivery.getBowledBy() + " Striker: " + ballDelivery.getStrikerPlayer() + " NonStriker: " + ballDelivery.getNonStrikerPlayer());
    }

    public static void printMatchDetails(List<CricketMatch> playedMatches) {
        System.out.println();//Intentionally left blank
        System.out.println("Total matches played: " + playedMatches.size());
        playedMatches.forEach(PrettyPrinter::printMatchDetails);
    }

    public static void printMatchSchedule(List<CricketMatch> scheduledMatches) {
        System.out.println(); //Intentionally left blank
        System.out.println("Schedule of Matches");
        scheduledMatches.forEach(System.out::println);
        System.out.println(); //Intentionally left blank
    }
}
