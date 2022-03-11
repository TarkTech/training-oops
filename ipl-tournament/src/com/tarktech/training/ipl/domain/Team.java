package com.tarktech.training.ipl.domain;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name, List<Player> players){
        this.name = name;
        this.players = players;
    }

    public String getName() {
        return name;
    }
    public List<Player> getPlayerList(){
        return players;
    }

    @Override
    public String toString(){
        return name;
    }
}
