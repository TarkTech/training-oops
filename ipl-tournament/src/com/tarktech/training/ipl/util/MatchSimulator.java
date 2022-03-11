package com.tarktech.training.ipl.util;

import com.tarktech.training.ipl.domain.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static com.tarktech.training.ipl.domain.BallDeliveryType.Normal;

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

    private LiveInningStatistics simulateInning(Inning inning, int targetToChase) {
        Random random = new Random();
        Team battingTeam = inning.getTeamToBat();
        Team bowlingTeam = inning.getTeamToBowl();

        List<Player> batters = battingTeam.getPlayerList();
        List<Player> bowlers = getBowlerList(bowlingTeam);

        LiveInningStatistics liveInningStatistics = new LiveInningStatistics(batters, bowlers);

        for (int i = 0; i < 20 && !liveInningStatistics.isInningOver(); i++) {
            Over over = new Over(i+1);
            liveInningStatistics.changeBowler(i); //Pick bowler in round robin fashion
            int ballCount = 0;

            while (ballCount < 6 && !liveInningStatistics.isInningOver()) {
                LiveBallStatistics liveBallStatistics = new LiveBallStatistics();

                int randomForDeliveryType = random.nextInt(100);
                int wicketDismissalProbability = 5;

                if (randomForDeliveryType < 100 -wicketDismissalProbability) {
                    liveBallStatistics.setDeliveryType(Normal);
                    int randomForWicketDismissal = random.nextInt(100);
                    if (randomForWicketDismissal < wicketDismissalProbability) {
                        liveBallStatistics.setWicketDismissal();
                    } else {
                        liveBallStatistics.setRunsScoredByBatsman();
                    }
                    ballCount += 1;
                } else {
                    liveBallStatistics.setWideOrNoBallDelivery();
                }

                BallDelivery ballDelivery = new BallDelivery(
                        liveBallStatistics.getRunsScoredByBatsman(),
                        liveInningStatistics.getStrikerPlayer(),
                        liveInningStatistics.getNonStrikerPlayer(),
                        liveBallStatistics.getBallDeliveryType(),
                        liveBallStatistics.getExtraRuns(),
                        liveBallStatistics.getWicketDismissal(),
                        liveInningStatistics.getBowler());

                validateBallDelivery(ballDelivery, battingTeam, bowlingTeam);
                over.deliveredBall(ballDelivery);

                if (liveBallStatistics.getRunsScoredByBatsman() == 1 || liveBallStatistics.getRunsScoredByBatsman() == 3) {
                    liveInningStatistics.changeStrike();
                }

                //remaining to check which player got out. for now Striker is considered as out
                if (liveBallStatistics.isWicketDismissal()) {
                    liveInningStatistics.addWicket();
                }
                liveInningStatistics.addRuns(liveBallStatistics.getTotalRunsScoredInBall());
                liveInningStatistics.isTargetChased(targetToChase);
            }

            validateOver(over, liveInningStatistics.isInningOver());
            inning.overPlayed(over);
            liveInningStatistics.changeStrike();
        }
        return liveInningStatistics;
    }

    public void playMatch(CricketMatch cricketMatch){
        playMatch(cricketMatch, false);
    }

    public void playMatch(CricketMatch cricketMatch, boolean displayResult) {
        cricketMatch.tossCoin();
        Inning firstInning = cricketMatch.getFirstInning();
        LiveInningStatistics firstInningStatistics = simulateInning(firstInning, -1);

        Inning secondInning = cricketMatch.getSecondInning();
        LiveInningStatistics secondInningStatistics = simulateInning(secondInning, firstInningStatistics.getTotalRuns());

        if(displayResult) {
            if (firstInningStatistics.getTotalRuns() > secondInningStatistics.getTotalRuns()) {
                System.out.println(firstInning.getTeamToBat().getName() + " Won the match by " + (firstInningStatistics.getTotalRuns() - secondInningStatistics.getTotalRuns()) + " runs");
            } else {
                System.out.println(secondInning.getTeamToBat().getName() + " Won the match by " + (10 - secondInningStatistics.getTotalWickets()) + " wickets");
            }
        }
    }

    private <T> T randomOneOf(T... values) {
        int randomIndex = new Random().nextInt(values.length);
        return values[randomIndex - 1];
    }

    private void validateOver(Over over, boolean isInningOver) {
        long normalDeliveredBallCount = over.getBallsDelivered().stream()
                .filter(ballDelivery -> ballDelivery.getDeliveryType() == Normal)
                .count();
        if (!isInningOver) {
            throwExceptionIfFalse(normalDeliveredBallCount == 6, "An over must have 6 valid balls");
        } else {
            throwExceptionIfFalse(normalDeliveredBallCount <= 6, "If current over is last over of the inning, it should have <= 6 ball deliveries");
        }
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