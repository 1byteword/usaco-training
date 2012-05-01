import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class ContestSchedule {
	class Contest implements Comparable<Contest> {
		int start;
		int end;
		double p;
		
		public Contest(String s) {
			StringTokenizer st = new StringTokenizer(s);
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			p = Double.parseDouble(st.nextToken()) / 100.0;
		}

		public int compareTo(Contest other) {
			return end - other.end;
		}
	}

	public double expectedWinnings(String[] cts) {
		ArrayList<Contest> contests = new ArrayList<Contest>();
		for (String s : cts) {
			contests.add(new Contest(s));
		}
		Collections.sort(contests);
		
		int n = cts.length;
		double[] dp = new double[n];
		dp[0] = contests.get(0).p;
		for (int i = 1; i < n; i++) {
			dp[i] = contests.get(i).p; 
			for (int j = i - 1; j >= 0; j--) {
				if (contests.get(j).end <= contests.get(i).start) {
					dp[i] = Math.max(dp[i], contests.get(i).p + dp[j]);
				}
			}
		}
		double res = 0.0;
		for (int i = 0; i < n; i++) {
			res = Math.max(dp[i], res); 
		}
		return res;

	}

}
