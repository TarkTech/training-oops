package com.tarktech.training.ipl.domain;

import java.util.Random;

public enum Coin {
    Head,
    Tail;

    public static Coin toss(){
        int randomValue = new Random().nextInt(2);
        return randomValue == 0 ? Head : Tail;
    }
}
