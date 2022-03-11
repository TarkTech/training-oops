package com.tarktech.training.ipl.util;

import com.tarktech.training.ipl.domain.*;

import java.util.*;

import static com.tarktech.training.ipl.domain.BallDeliveryType.*;
import static com.tarktech.training.ipl.domain.WicketDismissal.*;

public class MatchSimulator {
    private List<Player> getBowlerList(Team team) {
        List<Player> players = team.getPlayerList();
        List<Player> bowlers = new ArrayList<>();
        for (int i = 0; i < players.size(); i++) {
            PlayerRole playerRole = players.get(i).getRole();
            if (playerRole == PlayerRole.Bowler || playerRole == PlayerRole.AllRounder)
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


        for (int i = 0; i < 20; i++) {
            Over over = new Over();

            Player currentBowler = bowlers.get(i % bowlers.size()); //Pick bowler in round robin fashion

            int ballCount = 0;
            while (ballCount < 6 && !isInningOver) {
                int runsScoredByBatsman;
                BallDeliveryType deliveryType;
                int extraRuns = 0;
                WicketDismissal wicketDismissal = null;
                boolean isWicket = false;

                int randomForDeliveryType = random.nextInt(101);
                if (randomForDeliveryType <= 95) {
                    deliveryType = Normal;
                    int randomForWicketDismissal = random.nextInt(101);
                    if (randomForWicketDismissal > 95) {
                        isWicket = true;
                        wicketCurrentInning += 1;
                        wicketDismissal = randomOneOf(Bowled, Caught, RunOut, LegBeforeWicket);
                        runsScoredByBatsman = 0;
                    } else {
                        runsScoredByBatsman = randomOneOf(0, 1, 2, 3, 4, 6);
                    }
                    ballCount += 1;
                } else {
                    deliveryType = randomOneOf(Wide, NoBall);
                    extraRuns = 1;
                    runsScoredByBatsman = deliveryType == Wide ? 0 : randomOneOf(0, 1, 2, 3, 4, 6);
                }

                BallDelivery ballDelivery = new BallDelivery(runsScoredByBatsman, strikerPlayer, nonStrikerPlayer, deliveryType, extraRuns, wicketDismissal, currentBowler);
                validateBallDelivery(ballDelivery, battingTeam, bowlingTeam);

                over.deliveredBall(ballDelivery);

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

    private int randomOneOf(int... values) {
        int randomIndex = new Random().nextInt(values.length);
        return values[randomIndex - 1];
    }

    private <T> T randomOneOf(T... values) {
        int randomIndex = new Random().nextInt(values.length);
        return values[randomIndex - 1];
    }

    private void validateBallDelivery(BallDelivery ballDelivery, Team battingTeam, Team bowlingTeam) {
        throwExceptionIfFalse(ballDelivery != null, "Ball delivery must not be null");
        throwExceptionIfNotOneOf(ballDelivery.getBowledBy(), bowlingTeam.getPlayerList(), "Bowler is not from bowling team");

        throwExceptionIfFalse(ballDelivery.getDeliveryType() != null, "Ball delivery type must not be null");

        boolean isValidExtraRun = (ballDelivery.getDeliveryType() == Normal && ballDelivery.getExtraRuns() == 0)
                || (ballDelivery.getDeliveryType() != Normal && ballDelivery.getExtraRuns() == 1);
        throwExceptionIfFalse(isValidExtraRun, "Extra run must be 1 for NoBall or Wide and 0 for Normal delivery");

        throwExceptionIfNotOneOf(ballDelivery.getRunsScoredByBatsman(), Arrays.asList(0, 1, 2, 3, 4, 6), "Invalid run scored by batsman");

        throwExceptionIfNotOneOf(ballDelivery.getStrikerPlayer(), battingTeam.getPlayerList(), "Striker must be from batting team");
        throwExceptionIfNotOneOf(ballDelivery.getNonStrikerPlayer(), battingTeam.getPlayerList(), "Nonstriker must be from batting team");

        boolean isValidWicketDismissal = ballDelivery.getWicketDismissal() == null
                || (ballDelivery.getDeliveryType() == Normal && ballDelivery.getRunsScoredByBatsman() == 0 && ballDelivery.getExtraRuns() == 0);
        throwExceptionIfFalse(isValidWicketDismissal, "Invalid wicket dismissal");
    }

    private void throwExceptionIfFalse(boolean isTrue, String message) {
        if (!isTrue) {
            throw new RuntimeException(message);
        }
    }

    private <T> void throwExceptionIfNotOneOf(String message, T actualValue, T... values) {
        throwExceptionIfNotOneOf(actualValue, Arrays.asList(values), message);
    }

    private <T> void throwExceptionIfNotOneOf(T actualValue, List<T> values, String message) {
        if (!values.contains(actualValue)) {
            throw new RuntimeException("Invalid value: " + actualValue + "Message: " + message);
        }
    }
}
