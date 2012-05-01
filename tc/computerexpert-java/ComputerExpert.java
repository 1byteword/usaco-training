import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class ComputerExpert {

	public String[] operate(String[] f, String[] rules) {
		ArrayList<String> facts = new ArrayList<String>();
		ArrayList<String> res = new ArrayList<String>();
		for (String fact : f) {
			facts.add(fact);
		}

		boolean changed = true;
		while (changed) {
			changed = false;
			for (String rule : rules) {
				String result = evaluate(rule, facts);
				if (result == null) continue;
				if (!facts.contains(result)) {
					changed = true;
					facts.add(result);
					res.add(result);
				}
			}
		}
		Collections.sort(res);
		return res.toArray(new String[0]);
	}

	private String evaluate(String rule, ArrayList<String> facts) {
		StringTokenizer st  = new StringTokenizer(rule, "->");
		String premise = st.nextToken().trim();
		String result = st.nextToken().trim();
		
		st = new StringTokenizer(premise, ",");
		while (st.hasMoreTokens()) {
			String andRule = st.nextToken().trim();
			if (!evAnd(andRule, facts)) return null;
		}
		return result;
	}

	private boolean evAnd(String rule, ArrayList<String> facts) {
		StringTokenizer st = new StringTokenizer(rule, "/");
		while (st.hasMoreTokens()) {
			String orRule = st.nextToken().trim();
			if (facts.contains(orRule)) return true;
		}
		return false;
	}
}
