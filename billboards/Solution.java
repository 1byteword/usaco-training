import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

	int maxIncome = 0;
	int maxAdjacent = 0;
	
	int[][] rmqTable;
	
	private static int log2(int x) {
		return (int) (Math.log(x) / Math.log(2));
	}
	
    // 
	// RMQ in O(nlogn)
	//     http://community.topcoder.com/tc?module=Static&d1=tutorials&d2=lowestCommonAncestor#Range_Minimum_Query_%28RMQ%29
	private void initRMQTable(int length, int[] boards) {
		rmqTable = new int[length][log2(length) + 1];
		for (int i = 0; i < length; i++) {
			rmqTable[i][0] = i;
		}
		
		for (int j = 1; 1 << j <= length; j++) {
			for (int i = 0; i + (1 << j) - 1 < length; i++) {
				if (boards[rmqTable[i][j - 1]] <= boards[rmqTable[i + (1 << (j - 1)) - 1][j - 1]]) {
	                  rmqTable[i][j] = rmqTable[i][j - 1];
				}else {
	                  rmqTable[i][j] = rmqTable[i + (1 << (j - 1)) - 1][j - 1];
				}
			}
		}
	}
	
	private int RMQLookUp(int start, int end, int[] boards) {
		int k = log2(end - start + 1);
		int left = rmqTable[start][k];
		int right = rmqTable[end - (1 << k) + 1][k];
		return (boards[left] < boards[right]) ? left : right;
	}
	
	
	public int solve4(int length, int maxAdjacent, int[] boards) {
		initRMQTable(length, boards);
		return 0;
	}

	public int solve3(int length, int maxAdjacent, int[] boards) {

		this.maxAdjacent = maxAdjacent;
		
		int[][] dp = new int[2][maxAdjacent + 1];
		dp[1][0] = 0;
		dp[1][1] = boards[0];
		
		for (int roadLength = 1; roadLength <= length; roadLength++){
			int currentRow = roadLength % 2;
			int prevRow = 1 - currentRow;
			
			dp[currentRow][0] = 0;
			for (int j = 0; j <= Math.min(maxAdjacent, roadLength); j++) {
				if (j > 0) {
					dp[currentRow][j] = dp[prevRow][j - 1] + boards[roadLength - 1];
				}
				dp[currentRow][0] = Math.max(dp[currentRow][0], dp[prevRow][j]);
			}
		}
		
		maxIncome = 0;
		for (int i = 0; i <=maxAdjacent; i++) {
			maxIncome = Math.max(maxIncome, dp[length % 2][i]);
		}

		return maxIncome;
	}
	

	
	public int solve2(int length, int maxAdjacent, int[] boards) {

		this.maxAdjacent = maxAdjacent;
		
		int[][] dp = new int[length + 1][maxAdjacent + 1];
		dp[1][0] = 0;
		dp[1][1] = boards[0];
		
		for (int roadLength = 1; roadLength <= length; roadLength++){
//			// Remove this billboard
//			int max = 0;
//			for (int j = 0; j <= maxAdjacent; j++) {
//				max = Math.max(max, dp[roadLength - 1][j]);
//			}
//			dp[roadLength][0] = max;
//			
//			// include this billboard
//			for (int j = 1; j <= maxAdjacent; j++) {
//				dp[roadLength][j] = dp[roadLength - 1][j - 1] + boards[roadLength - 1];
//			}
			
			for (int j = 0; j <= maxAdjacent; j++) {
				if (j > 0) {
					dp[roadLength][j] = dp[roadLength - 1][j - 1] + boards[roadLength - 1];
				}
				dp[roadLength][0] = Math.max(dp[roadLength][0], dp[roadLength - 1][j]);
			}
			
		}
		
		maxIncome = 0;
		for (int i = 0; i <=maxAdjacent; i++) {
			maxIncome = Math.max(maxIncome, dp[length][i]);
		}

		return maxIncome;
	}
	

	public int solve1(int length, int maxAdjcent, int[] boards) {

		this.maxAdjacent = maxAdjcent;
		dfs(boards);

		return maxIncome;
	}

	private void dfs(int[] boards) {

		if (boardsOkay(boards)) {
			maxIncome = Math.max(maxIncome, income(boards));
			return;
		}

		int[] newBoards = Arrays.copyOf(boards, boards.length);
		for (int i = 0; i < newBoards.length; i++) {
			// Remove one
			if (newBoards[i] != -1) {
				int oldValue = newBoards[i];
				newBoards[i] = -1;
				dfs(newBoards);
				newBoards[i] = oldValue;
			}
		}

	}

	private static int income(int[] boards) {
		int sum = 0;
		for (int b : boards) {
			sum += Math.max(0, b);
		}
		return sum;
	}

	private boolean boardsOkay(int[] boards) {
		int windowLength = maxAdjacent + 1;
		for (int i = 0; i <= boards.length - windowLength; i++) {
			boolean present = true;
			for (int j = 0; j < windowLength; j++) {
				present &= (boards[i + j] > -1);
			}
			if (present) return false;
		}
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		int length = Integer.parseInt(line[0]);
		int maxAdjacent = Integer.parseInt(line[1]);

		int[] boards = new int[length];
		for (int i = 0; i < length; i++) {
			boards[i] = Integer.parseInt(br.readLine());
		}
		br.close();
		System.out.println((new Solution()).solve3(length, maxAdjacent, boards));
	}

	public int solve(int length, int maxAdjcent, int[] boards) {
		return solve3(length, maxAdjcent, boards);
	}

}
