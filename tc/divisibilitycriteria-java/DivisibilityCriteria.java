public class DivisibilityCriteria {

	public int[] multipliers(int N, int P) {
		int[] res = new int[N];
		int pow = 1;
		for (int i = 0; i < N; i++) {
			res[N - 1 - i] = pow;
			pow = pow * 10 % P;
		}
		
		return res;
	}

}
