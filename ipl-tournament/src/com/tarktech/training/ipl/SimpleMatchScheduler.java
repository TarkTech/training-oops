package com.tarktech.training.ipl;

import com.tarktech.training.ipl.domain.CricketMatch;
import com.tarktech.training.ipl.domain.Team;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SimpleMatchScheduler {
    public List<CricketMatch> scheduleLeagueRound(List<Team> teams, LocalDate startDate) {
        List<CricketMatch> scheduledMatches = new ArrayList<>();

        LocalDate matchScheduleDate = startDate;

        for (int i = 0; i < teams.size(); ++i) {
            for (int j = i + 1; j < teams.size(); ++j) {
                CricketMatch cricketMatch = new CricketMatch(teams.get(i), teams.get(j));
                cricketMatch.scheduleOn(matchScheduleDate);

                scheduledMatches.add(cricketMatch);

                matchScheduleDate = matchScheduleDate.plusDays(1);
            }
        }

        return scheduledMatches;
    }
}
