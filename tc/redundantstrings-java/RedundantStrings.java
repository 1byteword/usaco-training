public class RedundantStrings {

	int[] cache = new int[61];
	
	public int howMany(int length) {
		if (cache[length] > 0) return cache[length];
		
		int res = 0;
		for (int i = 1; i < length; i++) {
			if (length % i > 0) continue;
			res += (1 << i);
			res -= howMany(i);
		}
		
		cache[length] = res;
		return res;
	}

}
