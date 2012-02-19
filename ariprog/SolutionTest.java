import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {

	protected ariprog solution;

	@Before
	public void setUp() {
		solution = new ariprog();
	}

	@Test
	public void testSimple() {
		int n = 5;
		int m = 7;
		String[] expected = new String[] { "1 4", "37 4", "2 8", "29 8", "1 12", "5 12", "13 12", "17 12", "5 20", "2 24" };
		String[] actual = solution.solve(n, m);
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void testMid() {
		int n = 12;
		int m = 50;
		String[] expected = new String[] { "37 84", "521 84", "901 84", "1217 84", "1301 84", "1385 84", "1469 84", "1553 84", "1637 84", "1721 84", "74 168", "41 252" };
		String[] actual = solution.solve(n, m);
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void testLong() {
		int n = 18;
		int m = 100;
		String[] expected = new String[] { "1217 84", "1301 84", "1385 84", "1469 84", "2434 168", "2602 168", "2770 168", "2938 168", "4868 336", "361 588" };
		String[] actual = solution.solve(n, m);
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void testGenerate() {
		solution.generate(250);
	}

	@Test
	public void testMax() {
		solution.generate(250);
		int m = solution.max();
		Assert.assertEquals(125000, m);
	}

}
