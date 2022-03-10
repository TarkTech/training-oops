package com.tarktech.training.ipl.util;

import com.tarktech.training.ipl.domain.CricketMatch;
import com.tarktech.training.ipl.domain.Inning;

public class MatchSimulator {
    public void simulateMatch(CricketMatch cricketMatch){
        //TODO:
        //Toss the coin and decide who to bat first (randomly)
        //cricketMatch.coinTossed(teamToBat);

        //Simulate first inning
        Inning firstInning = cricketMatch.getFirstInning();

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
