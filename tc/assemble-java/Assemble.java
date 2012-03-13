

public class Assemble {
	
	public class Component {
		public int inp;
		public int size;
		public int outp;
		public int cost;
		
		public Component(int inp, int outp, int size, int cost) {
			this.inp = inp;
			this.outp = outp;
			this.size = size;
			this.cost = cost;
		}
		
		public String toString() {
			return String.format("(%d, %d, %d, %d)", inp, outp, size, cost); 
		}
	}

	public int minCost(int[] connect) {
		int n = connect.length - 1; // Num of components
		
		//min_cost from i to j
		Component components[][] = new Component[n][n];
		
		for (int i = 0; i < n; i++) {
			components[i][i] = new Component(connect[i], connect[i + 1], 1, 0);
		}
		
		for (int inc = 1;  inc < n; inc++) {
			for (int i = 0; i < n; i++) {
				int j = i + inc;
				if (j >= n) continue;
				Component cheapest_component = new Component(0, 0, 1, Integer.MAX_VALUE); //dummy
				for (int k = i; k < j; k++) {
					Component new_component = assemble(components[i][k], components[k + 1][j]);
					if (new_component.cost < cheapest_component.cost) {
						cheapest_component = new_component;
					}
				}
				components[i][j] = cheapest_component;
			}
		}
		      
		return components[0][n - 1].cost;
	}
	
	
	private Component assemble(Component A, Component B) {
		return new Component(A.inp, B.outp, A.size + B.size, A.cost + B.cost + cost(A, B));
	}

	private int cost(Component A, Component B) {
		return (A.inp + A.size) * A.outp * (B.outp + B.size);
	}

}
