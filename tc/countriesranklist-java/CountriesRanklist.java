import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class CountriesRanklist {
	
	private class Team implements Comparable<Team>{
		String name;
		int score;
		int empty = 4;
		
		public void addScore(int s) {
			score += s;
			empty--;
			assert(empty > 0);
		}
		
		public Team(String n, int s) {
			name = n;
			addScore(s);
		}
		
		public Team(Team other) {
			this.name = other.name;
			this.score = other.score;
			this.empty = other.empty;
		}
		
		public void fillScore(int s) {
			while (empty > 0) {
				addScore(s);
			}
		}

		public int compareTo(Team other) {
			return other.score - score;
		}
	}

	public String[] findPlaces(String[] knownPoints) {
		
		HashMap<String, Team> teams = new HashMap<String, Team>();
		int maxScore = 600;
		for (String s : knownPoints) {
			StringTokenizer st = new StringTokenizer(s);
			String name = st.nextToken();
			st.nextToken();
			int score = Integer.parseInt(st.nextToken()	);
			maxScore = Math.min(score - 1, maxScore);
			if (teams.containsKey(name)) {
				teams.get(name).addScore(score);
			} else {
				teams.put(name, new Team(name, score));
			}
		}
		
		ArrayList<String> res = new ArrayList<String>();
		
		for (String name : teams.keySet()) {
			res.add(findBestWorst(teams, maxScore, name));
		}
		
		Collections.sort(res);
		
		return res.toArray(new String[0]);
	}

	private String findBestWorst(HashMap<String, Team> teams, int maxScore, String teamName) {
		int best = findPlace(teams, teamName, true, maxScore);
		int worst = findPlace(teams, teamName, false, maxScore);
		return String.format("%s %d %d", teamName, best, worst);
	}

	private int findPlace(HashMap<String, Team> teams, String teamName, boolean isBest, int maxScore) {
		ArrayList<Team> ts = new ArrayList<Team>();
		for (String name : teams.keySet()) {
			Team t = new Team(teams.get(name));
			if (t.name.equals(teamName)) {
				t.fillScore(isBest?maxScore : 0);
			} else {
				t.fillScore(isBest? 0 : maxScore);
			}
			ts.add(t);
		}
		
		Collections.sort(ts);
		int place = 1;
		if (ts.get(0).name.equals(teamName)) return place;
		
		for (int i = 1; i < ts.size(); i++) {
			if (ts.get(i).score != ts.get(i - 1).score) {
				place = i + 1;
			}
			if (ts.get(i).name.equals(teamName)) return place;
		}
		
		return -1;
		
	}

}
