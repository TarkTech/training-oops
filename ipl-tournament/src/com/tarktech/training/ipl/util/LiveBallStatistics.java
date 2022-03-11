package com.tarktech.training.ipl.util;

import com.tarktech.training.ipl.domain.BallDeliveryType;
import com.tarktech.training.ipl.domain.WicketDismissal;

import java.util.Random;

import static com.tarktech.training.ipl.domain.BallDeliveryType.NoBall;
import static com.tarktech.training.ipl.domain.BallDeliveryType.Wide;
import static com.tarktech.training.ipl.domain.WicketDismissal.*;

public class LiveBallStatistics {
    private int runsScoredByBatsman;
    private BallDeliveryType ballDeliveryType;
    private int extraRuns;
    private WicketDismissal wicketDismissal;

    public LiveBallStatistics() {
        this.runsScoredByBatsman = 0;
        this.ballDeliveryType = null;
        this.extraRuns = 0;
        this.wicketDismissal = null;
    }

    public void setDeliveryType(BallDeliveryType deliveryType) {
        this.ballDeliveryType = deliveryType;
    }

    public void setWicketDismissal() {
        this.wicketDismissal = randomOneOf(Bowled, Caught, RunOut, LegBeforeWicket);
        this.runsScoredByBatsman = 0;
    }

    public void setRunsScoredByBatsman() {
        this.runsScoredByBatsman = randomRunsScoredByBatsman();
    }

    public void setWideOrNoBallDelivery() {
        this.ballDeliveryType = randomOneOf(Wide, NoBall);
        this.extraRuns += 1;
        this.runsScoredByBatsman = ballDeliveryType == Wide ? 0 : randomRunsScoredByBatsman();
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

    public boolean isWicketDismissal() {
        return wicketDismissal != null;
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

    private int randomRunsScoredByBatsman() {
        int probabilityInPercentage = new Random().nextInt(100) + 1;
        if (probabilityInPercentage <= 70) {
            return randomOneOfInt(0, 0, 1, 1, 2);
        } else if (probabilityInPercentage < 90) {
            return randomOneOfInt(3, 3, 4);
        }
        return randomOneOfInt( 4, 6);
    }
}
