import java.util.ArrayList;
import java.util.Collections;

public class Apothecary {

	public int[] balance(int W) {
		ArrayList<Integer> res = bal(W);
		return toArray(res);
	}

	private ArrayList<Integer> bal(int W) {
		int pow;
		for (pow = 1;; pow *= 3) {
			if (pow >= W) {
				break;
			}
		}

		ArrayList<Integer> res = new ArrayList<Integer>();
		if (pow == W) {
			res.add(pow);
			return res;
		}

		if (W > pow / 2) {
			res.add(pow);
			res.addAll(inverse(bal(pow - W)));
		} else {
			pow /= 3;
			res.add(pow);
			res.addAll(bal(W - pow));
		}

		Collections.sort(res);
		return res;
	}

	private int[] toArray(ArrayList<Integer> l) {
		int[] res = new int[l.size()];
		for (int i = 0; i < l.size(); i++) {
			res[i] = l.get(i);
		}
		return res;
	}

	private ArrayList<Integer> inverse(ArrayList<Integer> l) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		for (int i : l) {
			res.add(-i);
		}
		return res;
	}

}
