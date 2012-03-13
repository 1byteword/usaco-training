import java.util.Arrays;
import java.util.Comparator;

public class Barbecue {
	
	class Member {
		public int voted = 0;
		public int received = 0;
		public int index = 0;
	}

	public int eliminate(int n, int[] voter, int[] excluded) {
		Member[] smiths = new Member[n];
		
		for (int i = 0; i < n; i++) {
			smiths[i] = new Member();
			smiths[i].index = i;
		}
		
		for (int i = 0; i < voter.length; i++) {
			smiths[voter[i]].voted++;
			smiths[excluded[i]].received++;
		}
		
		Arrays.sort(smiths, new Comparator<Member>() {
			public int compare(Member arg0, Member arg1) {
				if (arg0.received != arg1.received) {
					return arg0.received - arg1.received;
				} else if (arg0.voted != arg1.voted) {
					return arg0.voted - arg1.voted;
				} else {
					return arg1.index - arg0.index;
				}
			}
		});
		
		return smiths[n - 1].index;
	}

}
