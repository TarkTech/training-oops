package com.tarktech.training.ipl.util;

import com.tarktech.training.ipl.domain.BallDeliveryType;
import com.tarktech.training.ipl.domain.WicketDismissal;

import java.util.Random;

import static com.tarktech.training.ipl.domain.BallDeliveryType.NoBall;
import static com.tarktech.training.ipl.domain.BallDeliveryType.Wide;
import static com.tarktech.training.ipl.domain.WicketDismissal.*;
import static com.tarktech.training.ipl.domain.WicketDismissal.LegBeforeWicket;

public class LiveBallStatistics {
    private int runsScoredByBatsman;
    private BallDeliveryType ballDeliveryType;
    private int extraRuns;
    private WicketDismissal wicketDismissal;
    private boolean isWicket;

    public LiveBallStatistics() {
        this.runsScoredByBatsman = 0;
        this.ballDeliveryType = null;
        this.extraRuns = 0;
        this.wicketDismissal = null;
        this.isWicket = false;
    }

    public void setDeliveryType(BallDeliveryType deliveryType) {
        this.ballDeliveryType = deliveryType;
    }

    public void setWicketDismissal() {
        this.isWicket = true;
        this.wicketDismissal = randomOneOf(Bowled, Caught, RunOut, LegBeforeWicket);
        this.runsScoredByBatsman = 0;
    }

    public void setRunsScoredByBatsman() {
        this.runsScoredByBatsman = randomOneOfInt(0, 1, 2, 3, 4, 6);
    }

    public void setBallDeliveryTypeAndRuns() {
        this.ballDeliveryType = randomOneOf(Wide, NoBall);
        this.extraRuns += 1;
        this.runsScoredByBatsman = ballDeliveryType == Wide ? 0 : randomOneOfInt(0, 1, 2, 3, 4, 6);
    }

    public BallDeliveryType getBallDeliveryType() {
        return ballDeliveryType;
    }

    public int getRunsScoredByBatsman() {
        return runsScoredByBatsman;
    }

    public int getExtraRuns() {
        return extraRuns;
    }

    public WicketDismissal getWicketDismissal() {
        return wicketDismissal;
    }

    public boolean getIsWicket() {
        return isWicket;
    }

    public int getTotalRunsScoredInBall() {
        return (this.runsScoredByBatsman + this.extraRuns);
    }

    private <T> T randomOneOf(T... values) {
        int randomIndex = new Random().nextInt(values.length);
        return values[randomIndex];
    }

    private int randomOneOfInt(int... values) {
        int randomIndex = new Random().nextInt(values.length);
        return values[randomIndex];
    }
}
