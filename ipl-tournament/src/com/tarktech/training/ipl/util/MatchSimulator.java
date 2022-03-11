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

    private LiveInningStatistics simulateInning(Inning inning, int targetToChase) {
        Random random = new Random();
        Team battingTeam = inning.getTeamToBat();
        Team bowlingTeam = inning.getTeamToBowl();

        List<Player> batters = battingTeam.getPlayerList();
        List<Player> bowlers = getBowlerList(bowlingTeam);

        LiveInningStatistics liveInningStatistics = new LiveInningStatistics(batters, bowlers);

        for (int i = 0; i < 20 && !liveInningStatistics.getIsInningOver(); i++) {
            Over over = new Over();
            liveInningStatistics.changeBowler(i); //Pick bowler in round robin fashion
            int ballCount = 0;

            while (ballCount < 6 && !liveInningStatistics.getIsInningOver()) {
                LiveBallStatistics liveBallStatistics = new LiveBallStatistics();

                int randomForDeliveryType = random.nextInt(100);
                if (randomForDeliveryType <= 94) {
                    liveBallStatistics.setDeliveryType(Normal);
                    int randomForWicketDismissal = random.nextInt(100);
                    if (randomForWicketDismissal > 94) {
                        liveBallStatistics.setWicketDismissal();
                    } else {
                        liveBallStatistics.setRunsScoredByBatsman();
                    }
                    ballCount += 1;
                } else {
                    liveBallStatistics.setBallDeliveryTypeAndRuns();
                }

                over.deliveredBall(new BallDelivery(liveBallStatistics.getRunsScoredByBatsman(), liveInningStatistics.getStrikerPlayer(), liveInningStatistics.getNonStrikerPlayer(), liveBallStatistics.getBallDeliveryType(), liveBallStatistics.getExtraRuns(), liveBallStatistics.getWicketDismissal(), liveInningStatistics.getBowler()));
                liveInningStatistics.isTargetChased(targetToChase);

                if (liveBallStatistics.getRunsScoredByBatsman() == 1 || liveBallStatistics.getRunsScoredByBatsman() == 3) {
                    liveInningStatistics.changeStrike();
                }

                //remaining to check which player got out. for now Striker is considered as out
                if (liveBallStatistics.getIsWicket()) {
                    liveInningStatistics.addWicket();
                }
                liveInningStatistics.addRuns(liveBallStatistics.getTotalRunsScoredInBall());
            }
            inning.overPlayed(over);
            liveInningStatistics.changeStrike();
        }
        return liveInningStatistics;
    }

    public void simulateMatch(CricketMatch cricketMatch) {
        cricketMatch.coinTossed();
        Inning firstInning = cricketMatch.getFirstInning();
        LiveInningStatistics firstInningStatistics = simulateInning(firstInning, -1);

        Inning secondInning = cricketMatch.getSecondInning();
        LiveInningStatistics secondInningStatistics = simulateInning(secondInning, firstInningStatistics.getTotalRuns());

        if (firstInningStatistics.getTotalRuns() > secondInningStatistics.getTotalRuns()) {
            System.out.println(firstInning.getTeamToBat().getName() + " Won the match by " + (firstInningStatistics.getTotalRuns() - secondInningStatistics.getTotalRuns()) + " runs");
        } else {
            System.out.println(secondInning.getTeamToBat().getName() + " Won the match by " + (10 - secondInningStatistics.getTotalWickets()) + " wickets");
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
