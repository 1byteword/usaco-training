import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {

	protected stamps solution;

	@Before
	public void setUp() {
		solution = new stamps();
	}

	@Test
	public void test0() {
		int n = 5;
		int[] stamps = new int[] {1,3};

		int expected = 13;
		int actual = solution.solve(n, stamps);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test1() {
		int n = 20;
		int[] stamps = new int[] {1};

		int expected = 20;
		int actual = solution.solve(n, stamps);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test2() {
		int n = 1;
		int[] stamps = new int[] {1, 2, 3, 5};

		int expected = 3;
		int actual = solution.solve(n, stamps);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testBig1() {
		int n = 1;
		int[] stamps = new int[] {1, 2, 4, 15, 9, 31, 63, 2100, 3500, 127, 255, 511, 1000, 1999};

		int expected = 2;
		int actual = solution.solve(n, stamps);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testBig2() {
		int n = 2;
		int[] stamps = new int[] {1, 2, 4, 15, 9, 31, 63, 2100, 3500, 127, 255, 511, 1000, 1999};

		int expected = 6;
		int actual = solution.solve(n, stamps);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testBig3() {
		int n = 3;
		int[] stamps = new int[] {1, 2, 4, 15, 9, 31, 63, 2100, 3500, 127, 255, 511, 1000, 1999};

		int expected = 28;
		int actual = solution.solve(n, stamps);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testBig() {
		int n = 200;
		int[] stamps = new int[] {1, 2, 4, 15, 9, 31, 63, 2100, 3500, 127, 255, 511, 1000, 1999};

		int expected = 682938;
		int actual = solution.solve(n, stamps);
		Assert.assertEquals(expected, actual);
	}


}
