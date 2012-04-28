public class DivisorDigits {

	public int howMany(int number) {
		int res = 0;

		int t = number;
		while (t > 0) {
			int s = (t % 10);
			if (s > 0) {
				if (number % s == 0) res++;
			}
			t /= 10;
		}

		return res;
	}

}
