package com.tarktech.training.ipl.util;

import com.tarktech.training.ipl.domain.Player;
import com.tarktech.training.ipl.domain.PlayerRole;
import com.tarktech.training.ipl.domain.Team;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class TeamRepository {
    public List<Team> findAllTeams() {
        List<Team> teams = new ArrayList<>();
        try {
            List<String> teamCsvRows = Files.readAllLines(Paths.get("src/resources", "Teams.csv"));
            teamCsvRows.remove(0); //Remove header

            for (String teamCsvRow : teamCsvRows) {
                String[] teamRow = teamCsvRow.split(",");// use comma as separator
                String teamName = teamRow[0].trim();
                List<Player> players = findPlayersForTeam(teamRow[0]);
                teams.add(new Team(teamName, players));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return teams;
    }

    private PlayerRole getPlayerRole(String playerRole) {
        playerRole = playerRole.trim();
        if (playerRole.equals("Batsman") || playerRole.equals("WK-Batsman")) {
            return PlayerRole.Batsman;
        } else if (playerRole.equals("Bowlers") || playerRole.equals("Bowler")) {
            return PlayerRole.Bowler;
        } else {
            return PlayerRole.AllRounder;
        }
    }

    private List<Player> findPlayersForTeam(String teamName) throws IOException {
        ArrayList<Player> players = new ArrayList<Player>();
        //parsing a CSV file into BufferedReader class constructor
        List<String> playersCsvRows = Files.readAllLines(Paths.get("src/resources", "Players.csv"));
        playersCsvRows.remove(0);

        List<Integer> jerseyNumbers = randomJerseyNumbers();

        int jerseyCount=0;
        for (String playerRow : playersCsvRows) {
            String[] playerAttributes = playerRow.split(",");    // use comma as separator
            String teamOfPlayer = playerAttributes[0];
            if (teamOfPlayer.equals(teamName)) {
                String playerName = playerAttributes[1].trim();
                PlayerRole playerRole = getPlayerRole(playerAttributes[3]);
                players.add(new Player(playerName, playerRole, jerseyNumbers.get(jerseyCount)));
                jerseyCount++;
            }
        }

        if (players.size() != 11) {
            throw new RuntimeException("There are " + players.size() + " players in " + teamName);
        }

        return players.stream()
                .sorted(Comparator.comparing(Player::getRole))
                .collect(Collectors.toList());
    }

    private List<Integer> randomJerseyNumbers() {
        Set<Integer> jerseyCount = new HashSet<>();
        Random random = new Random();
        while (jerseyCount.size() < 11) {
            jerseyCount.add(random.nextInt(100) % 100 + 1);
        }
        return new ArrayList<>(jerseyCount);
    }
}