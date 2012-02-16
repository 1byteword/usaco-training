import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {

	protected dualpal solution;

	@Before
	public void setUp() {
		solution = new dualpal();
	}

	@Test
	public void testCase0() {
		int n = 3;
		int s = 25;
		int[] expected = new int[] { 26, 27, 28 };
		int[] actual = solution.solve(n, s);
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void testCase1() {
		int n = 9;
		int s = 10;
		int[] expected = new int[] { 15, 16, 17, 18, 20, 21, 24, 26, 27 };
		int[] actual = solution.solve(n, s);
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void testConvert0() {
		int n = 10;
		int b = 10;
		String expected = "10";
		String actual = solution.convert(n, b);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testConvert1() {
		int n = 7;
		int b = 2;
		String expected = "111";
		String actual = solution.convert(n, b);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testConvert2() {
		int n = 255;
		int b = 16;
		String expected = "FF";
		String actual = solution.convert(n, b);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testConvert3() {
		int n = 1521;
		int b = 10;
		String expected = "1521";
		String actual = solution.convert(n, b);
		Assert.assertEquals(expected, actual);
	}

}
