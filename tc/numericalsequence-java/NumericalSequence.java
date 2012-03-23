

public class NumericalSequence {

	public int makePalindrome(int[] sequence) {
		int res = 0;
		int left = 0;
		int right = sequence.length - 1;
		int leftSum = sequence[left];
		int rightSum = sequence[right]; 
		
		while (left < right) {
			if (leftSum > rightSum) {
				res++;
				right--;
				rightSum += sequence[right];
			} else if (rightSum > leftSum) {
				res++;
				left++;
				leftSum += sequence[left];
			} else {
				left++;
				right--;
				rightSum = sequence[right];
				leftSum = sequence[left];
			}
		}
		
		return res;
	}

}
