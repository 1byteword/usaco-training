import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class grafixGlobs {


	private static final int M = 1000;
	private static final int ARC = 0;
	private static final int CIRCLE = 1;
	private static final int POLYGON = 2;
	private static final String[] objects = new String[] { "arc", "circle",
			"polygon" };

	int[][] glob = new int[M][3];
	PriorityQueue<Integer> unused = new PriorityQueue<Integer>();

	public int[] execute(String[] commands, int sel) {
		for (int i = 0; i < M; i++) {
			unused.add(i);
		}

		for (String cmd : commands) {
			exec(cmd);
		}

		if (unused.contains(sel))
			return new int[0];

		int[] res = new int[3];
		for (int i = 0; i < 3; i++) {
			res[i] = glob[sel][i];
		}
		return res;

	}

	private void exec(String cmd) {
		StringTokenizer st = new StringTokenizer(cmd);
		String c = st.nextToken();
		if (c.equals("make")) {
			String obj = st.nextToken();
			for (int i = 0; i < 3; i++) {
				if (obj.equals(objects[i])) {
					int id = unused.remove();
					glob[id][i] = 1;
					break;
				}
			}
		} else if (c.equals("delete")) {
			int toDel = Integer.parseInt(st.nextToken());
			for (int i = 0; i < 3; i++) {
				glob[toDel][i] = 0;
			}
			unused.add(toDel);
		} else if (c.equals("merge")) {
			int to = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			for (int i = 0; i < 3; i++) {
				glob[to][i] += glob[from][i];
				glob[from][i] = 0;
			}
			unused.add(from);
		} else if (c.equals("split")) {
			int toSplit = Integer.parseInt( st.nextToken() );
			int[] temp = new int[3];
			for (int i = 0; i < 3; i++) {
				temp[i] = glob[toSplit][i];
				glob[toSplit][i] = 0;
			}
			unused.add(toSplit);
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < temp[i]; j++) {
					int id = unused.remove();
					glob[id][i] = 1;
				}
			}
			
		}
	}

}
