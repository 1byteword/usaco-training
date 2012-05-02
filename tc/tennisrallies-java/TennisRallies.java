public class TennisRallies {
	private int numLength;
	private String[] forbidden;

	public int howMany(int numLength, String[] forbidden, int allowed) {
		this.numLength = numLength;
		this.forbidden = forbidden;
		
		int res = dfs("", allowed);
		return res;
	}

	private int dfs(String s, int allowed) {
		for (String f : forbidden) {
			if (s.endsWith(f)) {
				allowed--;
			}
		}
		if (allowed <= 0) {
			return 0;
		}
		if (s.length() == numLength) {
			return 1;
		}
		int res = 0;
		res += dfs(s + "c", allowed);
		res += dfs(s + "d", allowed);
		return res;
	}
}
