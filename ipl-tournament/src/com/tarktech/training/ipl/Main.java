package com.tarktech.training.ipl;

import com.tarktech.training.ipl.domain.CricketMatch;
import com.tarktech.training.ipl.domain.Player;
import com.tarktech.training.ipl.domain.Team;
import com.tarktech.training.ipl.util.MatchSimulator;
import com.tarktech.training.ipl.util.TeamRepository;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        TeamRepository teamRepository = new TeamRepository();
        MatchSimulator matchSimulator = new MatchSimulator();
        matchSimulator.simulateMatch(new CricketMatch(teamRepository.findAllTeams().get(0), teamRepository.findAllTeams().get(1)));
    }
}
