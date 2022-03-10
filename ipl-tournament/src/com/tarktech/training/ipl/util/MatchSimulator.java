package com.tarktech.training.ipl.util;

import com.tarktech.training.ipl.domain.*;

import java.util.*;

public class MatchSimulator {
    private List<Player> getBowlerList(Team team) {
        List<Player> players = team.getPlayerList();
        List<Player> bowlers = new ArrayList<>();
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getRole() != PlayerRole.Bowler)
                bowlers.add(players.get(i));
        }
        return bowlers;
    }

    private int[] simulateInning(Inning inning, int targetToChase) {
        Random random = new Random();
        boolean isInningOver = false;

        int wicketCurrentInning = 0;
        int runCurrentInning = 0;
        Team battingTeam = inning.getTeamToBat();
        List<Player> batters = battingTeam.getPlayerList();
        Player strikerPlayer = batters.get(0);
        Player nonStrikerPlayer = batters.get(1);
        int nextBattingPosition = 2;

        Team bowlingTeam = inning.getTeamToBowl();
        List<Player> bowlers = getBowlerList(bowlingTeam);
        Player currentBowler = bowlers.get(0);
        int nextBowlerPosition = 1;

        for (int i = 0; i < 20; i++) {
            Over over = new Over();
            int ballCount = 0;
            while (ballCount < 6 && !isInningOver) {
                int runsScoredByBatsman;
                BallDeliveryType deliveryType;
                int extraRuns = 0;
                WicketDismissal wicketDismissal = null;
                boolean isWicket = false;

                int randomForDeliveryType = random.nextInt(101);
                if (randomForDeliveryType <= 95) {
                    deliveryType = BallDeliveryType.Normal;
                    int randomForWicketDismissal = random.nextInt(101);
                    if (randomForWicketDismissal > 95) {
                        isWicket = true;
                        wicketCurrentInning += 1;
                        int randomForWicketDismissalType = random.nextInt(4);
                        if (randomForWicketDismissalType == 0) {
                            wicketDismissal = WicketDismissal.Bowled;
                        } else if (randomForWicketDismissalType == 1) {
                            wicketDismissal = WicketDismissal.Caught;
                        } else if (randomForWicketDismissalType == 2) {
                            wicketDismissal = WicketDismissal.RunOut;
                        } else {
                            wicketDismissal = WicketDismissal.LegBeforeWicket;
                        }
                        runsScoredByBatsman = 0;
                    } else {
                        runsScoredByBatsman = random.nextInt(7);
                    }
                    ballCount += 1;
                } else if (randomForDeliveryType > 95 && randomForDeliveryType <= 97) {
                    deliveryType = BallDeliveryType.Wide;
                    extraRuns = 1;
                    runsScoredByBatsman = 0;
                } else {
                    deliveryType = BallDeliveryType.NoBall;
                    extraRuns = 1;
                    runsScoredByBatsman = random.nextInt(7);
                }
                over.deliveredBall(new BallDelivery(runsScoredByBatsman, strikerPlayer, nonStrikerPlayer, deliveryType, extraRuns, wicketDismissal, currentBowler));

                if (targetToChase != -1 && runCurrentInning > targetToChase) {
                    isInningOver = true;
                }
                if (runsScoredByBatsman == 1 || runsScoredByBatsman == 3) {
                    Player temp = strikerPlayer;
                    strikerPlayer = nonStrikerPlayer;
                    nonStrikerPlayer = temp;
                }
                //remaining to check which player got out for now Striker is considered as out
                if (isWicket) {
                    strikerPlayer = batters.get(nextBattingPosition);
                    nextBattingPosition += 1;
                    isWicket = false;
                    if (nextBattingPosition > 11) {
                        isInningOver = true;
                    }
                }
                runCurrentInning += runsScoredByBatsman + extraRuns;
            }
            inning.overPlayed(over);

            Player temp = strikerPlayer;
            strikerPlayer = nonStrikerPlayer;
            nonStrikerPlayer = temp;
        }
        return new int[]{runCurrentInning, wicketCurrentInning};
    }

    public void simulateMatch(CricketMatch cricketMatch) {
        cricketMatch.coinTossed();
        Inning firstInning = cricketMatch.getFirstInning();
        int[] firstInningStatistics = simulateInning(firstInning, -1);

        Inning secondInning = cricketMatch.getSecondInning();
        int[] secondInningStatistics = simulateInning(secondInning, firstInningStatistics[0]);

        if (firstInningStatistics[0] > secondInningStatistics[0]) {
            System.out.println(firstInning.getTeamToBat().getName() + " Won the match by " + (firstInningStatistics[0] - secondInningStatistics[0]) + " runs");
        } else {
            System.out.println(secondInning.getTeamToBat().getName() + " Won the match by " + (10 - secondInningStatistics[1]) + " wickets");
        }

        //TODO:
        //Toss the coin and decide who to bat first (randomly)
        //cricketMatch.coinTossed(teamToBat);

        //Simulate first inning
        // Pseudo code
        // while first inning is not over
        // simulate match over by over and record it using
        // firstInning.overPlayed(over);


        //Simulate second inning
        // Same as above

        //Few rules while simulating match
        //Simulate match ball by ball
        //In each ball, runsScored will be one of 0,1,2,3,4,6 (with equal probability)
        //BallDelivery could be Normal, Wide or NoBall, probability of Normal Delivery is 0.95 and probability for Wide and NoBall is 0.05 each
        //There could be WicketDismissal, with probability of 0.05. During dismissal of wicket, randomly decide WicketDismissalType
        //runsScored is the actual run scored by striker batsman (and not due to extra run)
        //Strike changes within over, if runsScored = 1/3
        //Strike changes after completion of an over
        //Second inning will be stopped as soon as the result is decided, i.e. once that team scores required runs to win

        //During simulation, if you need any helper methods/classes, add them inside com.tarktech.training.ipl.util package, but do not add these helper methods inside actual domain class
        //Please also let me know in-case if I've missed something in above
    }
}
