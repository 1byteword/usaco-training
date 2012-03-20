public class BinarySearchable {

	public int howMany(int[] sequence) {
		int l = sequence.length;

		int res = 0;
		for (int i = 0; i < l; i++) {
			boolean searchable = true;
			for (int j = i + 1; j < l; j++) {
				if (sequence[j] < sequence[i]) {
					searchable = false;
					break;
				}
			}

			for (int j = 0; j < i; j++) {
				if (sequence[j] > sequence[i]) {
					searchable = false;
					break;
				}
			}

			if (searchable) res++;

		}

		return res;
	}

}
