import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {

	protected palsquare solution;

	@Before
	public void setUp() {
		solution = new palsquare();
	}

	@Test
	public void testCase0() {
		int b = 10;
		String[] expected = new String[] { "1 1", "2 4", "3 9", "11 121", "22 484", "26 676", "101 10201", "111 12321", "121 14641", "202 40804",
				"212 44944", "264 69696" };
		String[] actual = solution.solve(b);
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
