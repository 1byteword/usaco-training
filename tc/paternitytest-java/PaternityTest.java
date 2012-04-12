import java.util.ArrayList;

public class PaternityTest {

	public int[] possibleFathers(String child, String mother, String[] men) {
		ArrayList<Integer> res = new ArrayList<Integer>();

		for (int i = 0; i < men.length; i++) {
			if (isFather(child, mother, men[i])) {
				res.add(i);
			}
		}

		return toArray(res);
	}

	private boolean isFather(String child, String mother, String father) {
		int l = child.length();
		int inMother = 0;
		int inFather = 0;

		for (int i = 0; i < l; i++) {
			char cc = child.charAt(i);
			char cm = mother.charAt(i);
			char cf = father.charAt(i);

			if (cc != cm && cc != cf) return false;
			if (cc == cm) inMother++;
			if (cc == cf) inFather++;
		}

		if (inMother >= l / 2 && inFather >= l / 2) return true;

		return false;
	}

	private static int[] toArray(ArrayList<Integer> l) {
		int[] res = new int[l.size()];
		for (int i = 0; i < l.size(); i++) {
			res[i] = l.get(i);
		}
		return res;
	}

}
