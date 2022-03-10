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
}
