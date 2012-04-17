import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class PolynomialMultiplier {

	public String product(String f1, String f2) {
		HashMap<Integer, Integer> p1 = read(f1);
		HashMap<Integer, Integer> p2 = read(f2);

		HashMap<Integer, Integer> prod = new HashMap<Integer, Integer>();

		for (int m1 : p1.keySet()) {
			for (int m2 : p2.keySet()) {
				int m = m1 + m2;
				if (!prod.containsKey(m)) {
					prod.put(m, 0);
				}
				prod.put(m, prod.get(m) + (p1.get(m1) * p2.get(m2)));
			}
		}

		String res = write(prod);

		return res;
	}

	private String write(HashMap<Integer, Integer> p) {
		ArrayList<Integer> powers = new ArrayList<Integer>(p.keySet());
		Collections.sort(powers);
		Collections.reverse(powers);

		String f = "";
		for (int i = 0; i < powers.size(); i++) {
			int pow = powers.get(i);
			int c = p.get(pow);
			if (pow == 0) {
				f += String.format("%d", c);
			} else {
				f += String.format("%sx%s", c == 1 ? "" : String.format("%d*", c), pow == 1 ? "" : String.format("^%d", pow));
			}
			if (i < powers.size() - 1) f += " + ";
		}

		return f;
	}

	private HashMap<Integer, Integer> read(String f) {
		HashMap<Integer, Integer> p = new HashMap<Integer, Integer>();
		StringTokenizer st = new StringTokenizer(f, "+");
		while (st.hasMoreTokens()) {
			String s = st.nextToken().trim();
			int pow = -1;
			int c = -1;
			if (s.equals("x")) {
				pow = 1;
				c = 1;
			} else if (s.length() == 1) {
				pow = 0;
				c = Integer.parseInt(s);
			} else if (s.length() == 3) {
				if (s.contains("^")) {
					StringTokenizer st1 = new StringTokenizer(s, "^");
					st1.nextToken();
					pow = Integer.parseInt(st1.nextToken());
					c = 1;
				} else {
					StringTokenizer st1 = new StringTokenizer(s, "*");
					pow = 1;
					c = Integer.parseInt(st1.nextToken());
				}
			} else {
				StringTokenizer st1 = new StringTokenizer(s, "*x^");
				c = Integer.parseInt(st1.nextToken());
				pow = Integer.parseInt(st1.nextToken());
			}

			if (pow > -1) {
				if (!p.containsKey(pow)) p.put(pow, 0);
				p.put(pow, c + p.get(pow));
			}

		}

		return p;
	}
}
