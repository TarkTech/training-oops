package com.tarktech.training.ipl.domain;

import java.util.ArrayList;
import java.util.List;

public class Over {
    private final List<BallDelivery> ballsDelivered;
    private final int overNumber;

    public Over(int overNumber) {
        this.overNumber = overNumber;
        ballsDelivered = new ArrayList<>();
    }

    public void deliveredBall(BallDelivery ballDelivery) {
        ballsDelivered.add(ballDelivery);
    }

    public int getOverNumber() {
        return overNumber;
    }

    public List<BallDelivery> getBallsDelivered() {
        return ballsDelivered;
    }

    public int getTotalRuns() {
        int totalRuns = 0;
        for (BallDelivery ballDelivered : ballsDelivered) {
            totalRuns += ballDelivered.getTotalRuns();
        }
        return totalRuns;
    }

    public int getTotalWickets() {
        int totalWickets = 0;
        for (BallDelivery ballDelivered : ballsDelivered) {
            if(ballDelivered.getWicketDismissal() != null){
                totalWickets++;
            }
        }
        return totalWickets;
    }
}
