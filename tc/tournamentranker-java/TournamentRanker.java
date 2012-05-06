import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;



public class TournamentRanker {


	class Team implements Comparable<Team> {
		String name;
		Team lostTo;
		int won;

		public int compareTo(Team other) {
			if (won == other.won) {
				return lostTo.compareTo(other.lostTo);
			}
			return other.won - won;
		}

		public Team(String name, int won) {
			this.name = name;
			this.won = won;
		}

		public void lostTo(Team t) {
			lostTo = t;
		}
	}

	public String[] rankTeams(String[] names, String[] lostTo) {
		HashMap<String, Integer> counts = new HashMap<String, Integer>();

		for (String s : names) {
			if (!counts.containsKey(s))
				counts.put(s, 0);
		}

		for (String s : lostTo) {
			if (s.length() == 0)
				continue;
			counts.put(s, counts.get(s) + 1);
		}

		ArrayList<Team> teams = new ArrayList<Team>();
		for (String s : counts.keySet()) {
			teams.add(new Team(s, counts.get(s)));
		}
		int n = names.length;
		for (int i = 0; i < n; i++) {
			Team t = teams.get(i);
			for (int j = 0; j < n; j++) {
				if (names[j].equals(t.name)) {
					for (int k = 0; k < n; k++) {
						if (lostTo[j].equals(teams.get(k).name)) {
							t.lostTo(teams.get(k));
						}
					}
				}
			}
		}
		Collections.sort(teams);

		ArrayList<String> res = new ArrayList<String>();
		for (Team t : teams) {
			res.add(t.name);
		}
		return res.toArray(new String[0]);
	}
}
