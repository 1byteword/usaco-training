public class Speller {

	private final static String[] NAMES = new String[] { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven",
			"twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty", "twenty-one", "twenty-two",
			"twenty-three", "twenty-four", "twenty-five", "twenty-six", "twenty-seven", "twenty-eight", "twenty-nine", "thirty", "thirty-one",
			"thirty-two", "thirty-three", "thirty-four", "thirty-five", "thirty-six", "thirty-seven", "thirty-eight", "thirty-nine", "forty",
			"forty-one", "forty-two", "forty-three", "forty-four", "forty-five", "forty-six", "forty-seven", "forty-eight", "forty-nine", "fifty",
			"fifty-one", "fifty-two", "fifty-three", "fifty-four", "fifty-five", "fifty-six", "fifty-seven", "fifty-eight", "fifty-nine", "sixty",
			"sixty-one", "sixty-two", "sixty-three", "sixty-four", "sixty-five", "sixty-six", "sixty-seven", "sixty-eight", "sixty-nine", "seventy",
			"seventy-one", "seventy-two", "seventy-three", "seventy-four", "seventy-five", "seventy-six", "seventy-seven", "seventy-eight",
			"seventy-nine", "eighty", "eighty-one", "eighty-two", "eighty-three", "eighty-four", "eighty-five", "eighty-six", "eighty-seven",
			"eighty-eight", "eighty-nine", "ninety", "ninety-one", "ninety-two", "ninety-three", "ninety-four", "ninety-five", "ninety-six",
			"ninety-seven", "ninety-eight", "ninety-nine" };

	public int value(String number) {
		int[] dist = new int[100];

		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= 99; i++) {
			dist[i] = dist(NAMES[i], number);
			min = Math.min(min, dist[i]);
		}

		if (min == Integer.MAX_VALUE) return -1;

		int res = 0;
		boolean found = false;
		for (int i = 1; i <= 99; i++) {
			if (dist[i] == min) {
				if (found) {
					return -1;
				} else {
					found = true;
					res = i;
				}
			}
		}

		return res;
	}

	private int dist(String string, String number) {
		if (string.length() != number.length()) return Integer.MAX_VALUE;
		int res = 0;
		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) != number.charAt(i)) {
				res++;
			}
		}
		return res;
	}

}
