public class QuickSums {

	int l;
	int sum;
	String numbers;
	
	int res = Integer.MAX_VALUE;
	public int minSums(String numbers, int sum){
		l = numbers.length();
		this.sum  = sum;
		this.numbers = numbers;
		
		boolean[] plus = new boolean[l - 1]; // has plus sign after s[i]
		dfs(plus);
		
		return (res == Integer.MAX_VALUE) ? -1 : res;
	}
	
	private void dfs(boolean[] plus) {
		int c = count(plus);
		if (c >= res) return;
		if (evaluate(plus) == sum) {
			res = Math.min(res, c);
			return;
		}
		for (int i = 0; i < plus.length; i++) {
			if (plus[i]) continue;
			plus[i] = true;
			dfs(plus);
			plus[i] = false;
		}
	}

	private long evaluate(boolean[] plus) {
		long res = 0;
		int prev = 0;
		for (int i = 0; i < plus.length; i++) {
			if (plus[i]) {
				res += Long.parseLong(numbers.substring(prev, i + 1));
				prev = i + 1;
			}
		}
		res += Long.parseLong(numbers.substring(prev)); 
		return res;
	}

	private int count(boolean[] plus) {
		int res = 0;
		for (boolean b : plus) {
			res += b ? 1 : 0;
		}
		return res;
	}

}
