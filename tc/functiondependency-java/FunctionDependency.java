import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class FunctionDependency {

	public String[] scriptingOrder(String[] funcs, String[] depends) {
		int l = funcs.length;
		
		boolean[][] dep = new boolean[l][l];
		for (int i = 0; i < l; i++) {
			StringTokenizer st = new StringTokenizer(depends[i]);
			while(st.hasMoreTokens()) {
				int j = Integer.parseInt(st.nextToken());
				dep[i][j] = true;
			}
		}
		
		PriorityQueue<String> canScript = new PriorityQueue<String>();
		ArrayList<String> scripted = new ArrayList<String>();
		while (scripted.size() + canScript.size() < l) {
			ArrayList<String> nextFuncs = new ArrayList<String>();
			for (int i = 0; i < l; i++) {
				String func = funcs[i];
				if (scripted.contains(func) || canScript.contains(func)) continue;
				boolean allDepIn = true;
				for (int j = 0; j < l; j++) {
					if (i != j && dep[i][j] && !scripted.contains(funcs[j])) {
						allDepIn = false;
						break;
					}
				}	
				if (allDepIn) nextFuncs.add(func);
			}			
			
			canScript.addAll(nextFuncs);
			scripted.add(canScript.remove());
		}
		
		while (!canScript.isEmpty()) 
			scripted.add(canScript.remove());
		
		return scripted.toArray(new String[0]);

	}
}
