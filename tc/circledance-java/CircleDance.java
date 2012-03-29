import java.util.Arrays;

public class CircleDance {

	public int arrangeDancers(int[] heights) {

		Arrays.sort(heights);
		int l = heights.length;
		int[] dancers = new int[l];
		dancers[0] = heights[0];
		int picking = 1;
		int left = l-1;
		int right = 1;
		for (int off = 1;left > right ; off++) {
			left = l - off;
			right = off;
			if (dancers[left] > 0 || dancers[right] > 0) break;
			if (picking == l) break;
			dancers[left] = heights[picking++];
			if (picking == l) break;
			dancers[right] = heights[picking++];
		}

		int res = 0;
		for (int i = 0; i < l - 1; i++) {
			res = Math.max(res, Math.abs(dancers[i + 1] - dancers[i]));
		}
		res = Math.max(res, Math.abs(dancers[l - 1] - dancers[0]));

		return res;
	}

}
