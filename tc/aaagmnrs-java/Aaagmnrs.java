import java.util.ArrayList;
import java.util.Arrays;

public class Aaagmnrs {

	public String[] anagrams(String[] phrases) {
		ArrayList<String> res = new ArrayList<String>();

		for (String phrase : phrases) {
			boolean isAna = false;

			for (String p : res) {
				if (isAnagram(p, phrase)) {
					isAna = true;
					break;
				}
			}

			if (!isAna) {
				res.add(phrase);
			}
		}

		return res.toArray(new String[res.size()]);
	}

	private char[] normalize(String s) {
		s = s.replace(" ", "");
		char[] res = s.toLowerCase().toCharArray();
		Arrays.sort(res);
		return res;
	}

	private boolean isAnagram(String p, String phrase) {
		char[] ap = normalize(p);
		char[] aphrase = normalize(phrase);

		if (ap.length != aphrase.length) return false;

		for (int i = 0; i < ap.length; i++) {
			if (ap[i] != aphrase[i]) return false;
		}
		return true;
	}

}
