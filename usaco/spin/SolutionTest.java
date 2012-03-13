
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {

	protected spin solution;

	@Before
	public void setUp() {
		solution = new spin();
	}

	@Test
	public void test0() {
		int[] speeds  = new int[] {30, 50, 60, 70, 90};
		int[][] starts  = new int[][] {
				new int[] {0}, 	
				new int[] {150}, 	
				new int[] {60}, 	
				new int[] {180}, 	
				new int[] {180}, 	
		};
		int[][] widths  = new int[][] {
				new int[] {120}, 	
				new int[] {90}, 	
				new int[] {90}, 	
				new int[] {180}, 	
				new int[] {60}, 	
		};
		
		int expected = 9;
		int actual = solution.solve(speeds, starts, widths);
		Assert.assertEquals(expected, actual);
	}


}
