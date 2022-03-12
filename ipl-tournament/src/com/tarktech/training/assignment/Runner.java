package com.tarktech.training.assignment;


import com.tarktech.training.ipl.domain.Player;
import com.tarktech.training.ipl.domain.Team;
import com.tarktech.training.ipl.util.TeamRepository;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Runner {
    public static void run()
    {
        Scanner scanner = new Scanner(System.in);
        TeamRepository teamRepository = new TeamRepository();

        // Take first 2 teams
        List<Team> teams = teamRepository.findAllTeams().stream().limit(2).collect(Collectors.toList());
        int noOfMatchesPlayed = 5;

        for(Team team : teams)
        {
            for(int match = 1; match <= noOfMatchesPlayed; match++)
            {
                System.out.println("Enter score of team: " + team.getName() + ", match: " + match);
                String matchScore = scanner.nextLine();

                /**
                 * Input format:
                 * comma separated string of player jersey number and scores.
                 * e.g. 1001 10, 1002 40, 1003 30, 1004 24, 1005 2, 1006 4
                 * Assuming players with jersey numbers 1001, 1002, 1003 and 1004 are batsman, they scored 10, 40, 30 and 24 runs each
                 * Players with jersey numbers 1005 and 1006 being bowlers, they took 2 and 4 wickets
                 */
                // TODO: Parse the input and fill objects of players/scores
            }
        }

        System.out.println("Enter jersey number of the player to find base price for: ");
        String jerseyNumber = scanner.nextLine();
        // TODO: Find base price
        long basePrice = 0;

        System.out.println("Base price for player with jersey number " + jerseyNumber + " is: " + basePrice);
    }
}
