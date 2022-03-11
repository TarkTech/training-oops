package com.tarktech.training.ipl.domain;

public class BallDelivery {
    private int runsScoredByBatsman;
    private Player strikerPlayer;
    private Player nonStrikerPlayer;

    private BallDeliveryType deliveryType;
    private int extraRuns;

    private WicketDismissal wicketDismissal;

    private Player bowledBy;


    public BallDelivery(
            int runsScoredByBatsman,
            Player strikerPlayer,
            Player nonStrikerPlayer,
            BallDeliveryType deliveryType,
            int extraRuns,
            WicketDismissal wicketDismissal,
            Player bowledBy) {
        this.runsScoredByBatsman = runsScoredByBatsman;
        this.strikerPlayer = strikerPlayer;
        this.nonStrikerPlayer = nonStrikerPlayer;
        this.deliveryType = deliveryType;
        this.wicketDismissal = wicketDismissal;
        this.bowledBy = bowledBy;
        this.extraRuns = extraRuns;
    }

    public int getRunsScoredByBatsman() {
        return runsScoredByBatsman;
    }

    public Player getStrikerPlayer() {
        return strikerPlayer;
    }

    public Player getNonStrikerPlayer() {
        return nonStrikerPlayer;
    }

    public BallDeliveryType getDeliveryType() {
        return deliveryType;
    }

    public int getExtraRuns() {
        return extraRuns;
    }

    public WicketDismissal getWicketDismissal() {
        return wicketDismissal;
    }

    public Player getBowledBy() {
        return bowledBy;
    }
}
