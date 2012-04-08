

public class RSABreaker {

	public int decrypt(int e, int n, int b) {
		int m = f(n);
		int d = findR1(e, m);
		

		return dec(b, d, n);
	}

	private int dec(int b, int d, int n) {
		int res = 1;
		for (int i = 0; i < d; i++) {
			res *= b;
			res %= n;
		}
		return res;
	}

	private int findR1(int e, int m) {
		int res = 0;
		while (true) {
			res++;
			if ((res * e) % m == 1) {
				return res;
			}
		}
	}

	private int f(int n) {
		int res = 0;
		for (int i = 1; i < n; i++) {
			if (shareFactor(i, n)) continue;
			res++;
		}

		return res;
	}

	private boolean shareFactor(int x, int n) {
		if (x == 1 || n == 1) return false;
		for (int p = 2; p <= Math.min(x, n); p++) {
			if (x % p == 0 && n % p == 0) {
				return true;
			}
		}

		return false;
	}

}
