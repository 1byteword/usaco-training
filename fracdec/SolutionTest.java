import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {

	protected fracdec solution;

	@Before
	public void setUp() {
		solution = new fracdec();
	}

	@Test
	public void test0() {
		int n = 45;
		int d = 56;

		String expected = "0.803(571428)";
		String actual = solution.solve(n, d);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test1() {
		int n = 22;
		int d = 5;

		String expected = "4.4";
		String actual = solution.solve(n, d);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test2() {
		int n = 1;
		int d = 7;

		String expected = "0.(142857)";
		String actual = solution.solve(n, d);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test3() {
		int n = 3;
		int d = 3;

		String expected = "1.0";
		String actual = solution.solve(n, d);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testLong() {
		int n = 1;
		int d = 99991;

		String expected = "1.0";
		String actual = solution.solve(n, d);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testGCD0() {
		int x = 2;
		int y = 8;
		int expected = 2; 

		int actual = fracdec.gcd(x, y);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testGCD1() {
		int x = 2;
		int y = 7;
		int expected = 1; 

		int actual = fracdec.gcd(x, y);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testGCD2() {
		int x = 14;
		int y = 21;
		int expected = 7; 

		int actual = fracdec.gcd(x, y);
		Assert.assertEquals(expected, actual);
	}


}
