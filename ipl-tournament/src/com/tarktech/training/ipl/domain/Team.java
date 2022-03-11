package com.tarktech.training.ipl.domain;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;
    private List<CricketMatch> playedMatches;

    public Team(String name, List<Player> players){
        this.name = name;
        this.players = players;
        this.playedMatches = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    public List<Player> getPlayerList(){
        return players;
    }

    public void matchPlayed(CricketMatch cricketMatch) {
        playedMatches.add(cricketMatch);
    }

    @Override
    public String toString(){
        return name;
    }
}
