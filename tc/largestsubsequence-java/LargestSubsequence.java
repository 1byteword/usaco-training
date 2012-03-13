public class LargestSubsequence {

	public String getLargest(String s) {
		String res = "";
		int start = 0;
		while( start < s.length()  ) {
			
			// find max
			char maxChar = 'a' - 1;
			for (int j = start; j < s.length(); j++) {
				if (s.charAt(j) > maxChar) {
					start = j + 1;
					maxChar = s.charAt(j);
				}
			}
			if (maxChar == 'a' - 1) break;
			res += maxChar;
		}
		return res;
	}

}
