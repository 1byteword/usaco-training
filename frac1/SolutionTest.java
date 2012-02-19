import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {

	protected frac1 solution;

	@Before
	public void setUp() {
		solution = new frac1();
	}

	@Test
	public void test0() {
		int n = 5;
		String[] expected = new String[] { "0/1", "1/5", "1/4", "1/3", "2/5", "1/2", "3/5", "2/3", "3/4", "4/5", "1/1" };
		String[] actual = solution.solve(n);
		Assert.assertArrayEquals(expected, actual);
	}
	
	@Test
	public void testGcd0() {
		int x = 5;
		int y = 2;
		int expected = 1;
		int actual = solution.gcd(x, y);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testGcd1() {
		int x = 5;
		int y = 8;
		int expected = 1;
		int actual = solution.gcd(x, y);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testGcd2() {
		int x = 6;
		int y = 8;
		int expected = 2;
		int actual = solution.gcd(x, y);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testGcd3() {
		int x = 1;
		int y = 8;
		int expected = 1;
		int actual = solution.gcd(x, y);
		Assert.assertEquals(expected, actual);
	}
	

}
