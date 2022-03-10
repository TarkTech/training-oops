package com.tarktech.training.ipl.domain;

public class BallDelivery {
    private int runsScored;
    private Player strikerPlayer;
    private Player nonStrikerPlayer;

    private BallDeliveryType deliveryType;

    private WicketDismissal wicketDismissal;

    private Player bowledBy;


    public BallDelivery(
            int runsScored,
            Player strikerPlayer,
            Player nonStrikerPlayer,
            BallDeliveryType deliveryType,
            WicketDismissal wicketDismissal,
            Player bowledBy) {
        this.runsScored = runsScored;
        this.strikerPlayer = strikerPlayer;
        this.nonStrikerPlayer = nonStrikerPlayer;
        this.deliveryType = deliveryType;
        this.wicketDismissal = wicketDismissal;
        this.bowledBy = bowledBy;
    }
}
