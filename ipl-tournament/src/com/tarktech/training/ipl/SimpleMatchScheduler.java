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

        ArrayList<String> schedule = new ArrayList<>();
        int r = 0;
        int i = 0;
        int j = teams.size()-1;

        if (teams.size() % 2 == 0) {
            while (r < teams.size() - 1) {
                while (i < j) {
                    schedule.add(teams.get(i) + " " + teams.get(j));

                    CricketMatch cricketMatch = new CricketMatch(teams.get(i), teams.get(j));
                    cricketMatch.scheduleOn(matchScheduleDate);
                    scheduledMatches.add(cricketMatch);
                    matchScheduleDate = matchScheduleDate.plusDays(1);

                    i++;
                    j--;
                }
                i = 0;
                j = teams.size() - 1;

                //right shifting of teams...
                List<Team> temp = new ArrayList<>(teams);
                teams.set(1, temp.get(temp.size()-1));

                for (int k=2; k<temp.size(); k++){
                    teams.set(k, temp.get(k-1));
                }

                r++;
            }
            //System.out.println(schedule);
        }

        //System.out.println(scheduledMatches);
        return scheduledMatches;
    }
}
