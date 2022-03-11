package com.tarktech.training.ipl;

import com.tarktech.training.ipl.domain.CricketMatch;
import com.tarktech.training.ipl.domain.Team;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RoundRobinMatchScheduler {
    public List<CricketMatch> scheduleLeagueRound(List<Team> teams, LocalDate startDate) {
        boolean isEvenTeamCount = teams.size() % 2 == 0;
        Team firstTeam = teams.get(0);
        Team lastTeam = teams.get(teams.size() - 1);

        if (isEvenTeamCount) {
            teams.remove(teams.size() - 1); //Remove last team from array (as per algorithm)
        }

        List<CricketMatch> scheduledMatches = new ArrayList<>();
        LocalDate matchScheduleDate = startDate;
        do {
            for (int i = 0; i < teams.size() / 2; ++i) {
                Team team1 = teams.get(i);
                Team team2 = teams.get(teams.size() - (i + 1));

                CricketMatch scheduledMatch = new CricketMatch(team1, team2);
                scheduledMatch.scheduleOn(matchScheduleDate);

                matchScheduleDate = matchScheduleDate.plusDays(1); //For next match

                scheduledMatches.add(scheduledMatch);
            }

            if (isEvenTeamCount) {
                Team teamYetToPlay = teams.get(teams.size() / 2);
                CricketMatch scheduledMatch = new CricketMatch(teamYetToPlay, lastTeam);
                scheduledMatch.scheduleOn(matchScheduleDate);

                matchScheduleDate = matchScheduleDate.plusDays(1);

                scheduledMatches.add(scheduledMatch);
            }

            Team teamAtLastIndex = teams.remove(teams.size() / 2);
            teams.add(0, teamAtLastIndex);

        } while (teams.get(0) != firstTeam);
        return scheduledMatches;
    }
}
