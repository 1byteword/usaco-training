import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {

	protected clocks solution;

	@Before
	public void setUp() {
		solution = new clocks();
	}

	@Test
	public void test0() {
		int[] clocks = new int[] { 12, 12, 12, 12, 12, 12, 12, 12, 12 };
		String expected = "0";
		String actual = solution.solve(clocks);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testTurnA() {
		int[] clocks = new int[] { 3, 12, 12, 12, 12, 12, 12, 12, 12 };
		String expected = "1234566788";
		String actual = solution.solve(clocks);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testTurnB() {
		int[] clocks = new int[] { 12, 3, 12, 12, 12, 12, 12, 12, 12 };
		String expected = "112334556777999";
		String actual = solution.solve(clocks);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testTurnC() {
		int[] clocks = new int[] { 12, 12, 3, 12, 12, 12, 12, 12,  12 };
		String expected = "1234456889";
		String actual = solution.solve(clocks);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testSimple() {
		int[] clocks = new int[] { 9, 9, 12, 6, 6, 6, 6, 3, 6 };
		String expected = "4589";
		String actual = solution.solve(clocks);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testCase2() {
		int[] clocks = new int[] { 6, 9, 3, 3, 3, 9, 12, 12, 12 };
		String expected = "1122248889";
		String actual = solution.solve(clocks);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testCase3() {
		int[] clocks = new int[] { 12, 3, 3, 3, 6, 6, 12, 3, 6 };
		String expected = "11222333444555677788999";
		String actual = solution.solve(clocks);
		Assert.assertEquals(expected, actual);
	}
	
	
	@Test
	public void testBinary() {
		int expected = 6;
		int actual = Integer.parseInt("0110", 2);
		Assert.assertEquals(expected, actual);
	}
	
	
	
	

}
