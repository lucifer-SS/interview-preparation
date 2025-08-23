package com.leetcode.practice;

import java.util.*;

public class RankTeamsVoting {
    Map<Character, Team> teamMap;

    public RankTeamsVoting() {
        teamMap = new HashMap<>();
    }

    public String rankTeams(String[] votes) {
        for (String vote : votes) {
            char[] voteChar = vote.toCharArray();
            for (int i=0; i<voteChar.length; i++) {
                teamMap.putIfAbsent(voteChar[i], new Team(voteChar[i], voteChar.length));
                Team team = teamMap.get(voteChar[i]);
                team.ranks[i]++;
            }
        }

        List<Team> rankedTeams = new ArrayList<>(teamMap.values());

        TreeSet<Team> ranked = new TreeSet<>((t1, t2) -> {
           for (int i=0; i<t1.ranks.length; i++) {
               if (t1.ranks[i] != t2.ranks[i]) {
                   return Integer.compare(t2.ranks[i], t1.ranks[i]);
               }
           }

           return t1.teamName.compareTo(t2.teamName);
        });

        ranked.addAll(teamMap.values());

        StringBuilder result = new StringBuilder();
        for (Team team : ranked) {
            result.append(team.teamName);
        }

        return result.toString();
    }
}

class Team {
    Character teamName;
    int[] ranks;

    Team (char teamName, int teamCount) {
        this.teamName = teamName;
        this.ranks = new int[teamCount];

        Arrays.fill(ranks, 0);
    }
}
