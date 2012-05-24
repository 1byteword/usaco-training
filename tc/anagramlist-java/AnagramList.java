import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

public class AnagramList {

	public String getAnagram(String s, int idx) {
		ArrayList<Character> text = new ArrayList<Character>();
		for (char c : s.toCharArray()) {
			text.add(c);
		}
		Collections.sort(text);
		s = "";
		for (char c : text) {
			s += c;
		}

		int wantCount = idx + 1;

		BigInteger bigInteger = new BigInteger(String.valueOf(wantCount));
		if (bigInteger.compareTo(count(s)) > 0)
			return "";
		if (s.length() == 1) {
			assert (wantCount == 1);
			return s;
		}

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (i > 0 && c == s.charAt(i - 1))
				continue;
			String next = s.substring(0, i) + s.substring(i + 1);
			BigInteger count = count(next);
			if (count.compareTo(bigInteger) >= 0) {
				return "" + c + getAnagram(next, wantCount - 1);
			} else {// if (count < wantCount) {
				wantCount -= count.intValue();
				bigInteger = new BigInteger(String.valueOf(wantCount));
			}
		}
		return "xxxx";
	}

	private BigInteger count(String s) {
		int l = s.length();
		if (l == 0)
			return BigInteger.ZERO;
		int rep = 1;
		BigInteger res = factorial(l);

		for (int i = 0; i < l; i++) {
			if (i > 0) {
				if (s.charAt(i) == s.charAt(i - 1)) {
					rep++;
				} else {
					if (rep > 1) {
						res = res.divide(factorial(rep));
						rep = 1;
					}
				}
			}
		}
		if (rep > 1) {
			res = res.divide(factorial(rep));
			rep = 1;
		}
		return res;
	}

	private static final int M = 22;
	private static final BigInteger[] cache = new BigInteger[M];
	static {
		cache[1] = BigInteger.ONE;
	}

	private BigInteger factorial(int l) {
		if (cache[l] != null) {
			return cache[l];
		}
		BigInteger res = factorial(l - 1).multiply(
				new BigInteger(String.valueOf(l)));
		cache[l] = res;
		return res;
	}

}
