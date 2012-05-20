import java.util.StringTokenizer;

public class BagsQuiz {

	public int checkIfProper(int n, String[] actions) {
		int[] in = new int[n + 1];
		for (String act : actions) {

			StringTokenizer st = new StringTokenizer(act);
			String middle;
			String front =st.nextToken(); 

			if (front.startsWith("PUT")) {
				int small = Integer.parseInt(st.nextToken());
				middle = st.nextToken();
				assert (middle.equals("INSIDE"));
				int big = Integer.parseInt(st.nextToken());

				if (in[small] != 0 || in[big] != 0)
					return -1;
				in[small] = big;

			} else if (front.startsWith("SWAP")) {
				int first = Integer.parseInt(st.nextToken());
				middle = st.nextToken();
				assert (middle.equals("WITH"));
				int second = Integer.parseInt(st.nextToken());

				if (in[first] != 0 || in[second] != 0)
					return -1;

				for (int i = 1; i <= n; i++) {
					if (in[i] == first) {
						in[i] = second;
					} else if (in[i] == second) {
						in[i] = first;
					}
				}

			} else { // if ("SET")) {
				int bag = Integer.parseInt(st.nextToken());
				middle = st.nextToken();
				assert (middle.equals("LOOSE"));

				if (in[bag] != 0)
					return -1;

				for (int i = 1; i <= n; i++) {
					if (in[i] == bag) {
						in[i] = 0;
					}
				}
			}
		}

		int res = 0;
		for (int i = 1; i <= n; i++) {
			if (in[i] == 0) {
				res++;
			} else if (in[i] < i) {
				return -1;
			}
		}
		
		return res;

	}
}
