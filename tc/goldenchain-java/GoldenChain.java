import java.util.Arrays;

public class GoldenChain {

	public int minCuts(int[] sections) {
		int l = sections.length;
		Arrays.sort(sections);
		int needed = l;
		
		int res = 0;
		for (int i = 0; i < l; i++) {
			if (sections[i] <= needed - 1) {
				needed -= sections[i];
				needed -= 1;
				res += sections[i];
			} else {
				res += needed;
				break;
			}
			
		}
		return res;

	}

}
