import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {

	protected transform solution;

	@Before
	public void setUp() {
		solution = new transform();
	}

	@Test
	public void testCase0() {
		int expected = 1;
		int n = 3;
		String[] from = new String[] {
				"@-@", 
				"---", 
				"@@-"
		};
		String[] to = new String[] {
				"@-@", 
				"@--", 
				"--@" 
		};
		
		int actual = solution.solve(n, from, to);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testCase2() {
		int expected = 7;
		int n = 3;
		String[] from = new String[] {
				"---", 
				"---", 
				"---"
		};
		String[] to = new String[] {
				"---", 
				"-@-", 
				"---"
		};
		
		int actual = solution.solve(n, from, to);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testCase1() {
		int expected = 5;
		int n = 5;
		String[] from = new String[] {
				"-@@@-", 
		        "-@@--", 
		        "-@---", 
		        "-----", 
		        "-----", 
		};
		String[] to = new String[] {
		        "-----", 
		        "----@", 
		        "---@@", 
		        "--@@@", 
		        "-----"
		};
		
		int actual = solution.solve(n, from, to);
		Assert.assertEquals(expected, actual);
	}

}
