import java.math.BigInteger;

public class NextPalindromicNumber {

	public String getNext(String n) {
		int l = n.length();
		StringBuilder res = new StringBuilder();
		if (allNines(n)) {
			res.append(1);
			for (int i = 0; i < l - 1; i++) {
				res.append(0);
			}
			res.append(1);
			return res.toString();
		}

		String firstHalf = n.substring(0, l / 2);
		String newSecondHalf = reverse(firstHalf);
		String secondHalf = n.substring(l / 2 + (l % 2));
		String mid = "";
		boolean canUseNewSecondHalf = larger(newSecondHalf, secondHalf);

		if (l % 2 == 1) {
			int inc = canUseNewSecondHalf ? 0 : 1;
			char c = (char) (n.charAt(l / 2) + inc);
			if (c > '9') {
				c = '0';
				firstHalf = addOne(firstHalf);
				newSecondHalf = reverse(firstHalf);
			}
			mid = String.valueOf(c);
		} else {
			if (!canUseNewSecondHalf) {
				firstHalf = addOne(firstHalf);
				newSecondHalf = reverse(firstHalf);
			}
		}

		res.append(firstHalf);
		res.append(mid);
		res.append(newSecondHalf);
		return res.toString();
	}

	private String addOne(String s) {
		BigInteger bi = new BigInteger(s);
		bi = bi.add(BigInteger.ONE);
		return bi.toString();
	}

	private boolean larger(String a, String b) {
		assert (a.length() == b.length());
		if (a.length() == 0) return false;
		BigInteger ba = new BigInteger(a);
		BigInteger bb = new BigInteger(b);
		return ba.compareTo(bb) > 0;
	}

	private String reverse(String n) {
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < n.length(); i++) {
			res.insert(0, n.charAt(i));
		}
		return res.toString();
	}

	private boolean allNines(String n) {
		for (char c : n.toCharArray()) {
			if (c != '9')
				return false;
		}
		return true;
	}
}
