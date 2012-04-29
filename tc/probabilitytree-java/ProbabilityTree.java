import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class ProbabilityTree {

	public int[] getOdds(String[] tree, int lowerBound, int upperBound) {
		int n = tree.length;
		double[] prob = new double[n];
		ArrayList<Integer> res = new  ArrayList<Integer>();
		prob[0] = Double.parseDouble(tree[0]) / 100;
		if (lowerBound /100.0 < prob[0] && prob[0] < upperBound/100.0) res.add(0);
		for (int i = 1; i < n; i++) {
			prob[i] = -1.0;
		}

		boolean unfinishend = true;
		while (unfinishend) {
			unfinishend = false;
			
			for (int i = 1; i < n; i++) {
				if (prob[i] > 0.0) continue;
				StringTokenizer st = new StringTokenizer(tree[i]);
				int parent = Integer.parseInt(st.nextToken());
				if (prob[parent] == -1.0) {
					unfinishend = true;
					continue;
				} 
				
				double prob1 = Double.parseDouble(st.nextToken()) / 100;
				double prob2 = Double.parseDouble(st.nextToken()) / 100;
				
				double probParent = prob[parent];
				// P(A) = P(A|B) * P(B) + P(A|~B) * P(~B)
				double p = prob1 * probParent + prob2 * (1 - probParent);
				if (lowerBound /100.0 < p && p < upperBound/100.0) {
					if (!res.contains(i)) {
						res.add(i);
					}
				}
				prob[i] = p;
			}

		}
		Collections.sort(res);
		return toArray(res);
	}

	private int[] toArray(ArrayList<Integer> l) {
		int n = l.size();
		int[] res = new int[n];
		for (int i = 0; i  < n; i++) {
			res[i] = l.get(i);
		}
		return res;
	}

}
