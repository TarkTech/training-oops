package com.tarktech.training.ipl.domain;

public class Player {
    private String name;
    private PlayerRole Role;
    private int jerseyNo;

    public Player(String name, PlayerRole Role, int jerseyNo) {
        this.name = name;
        this.Role = Role;
        this.jerseyNo = jerseyNo;
    }

    public PlayerRole getRole() {
        return Role;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public int getJerseyNo() {
        return jerseyNo;
    }
}