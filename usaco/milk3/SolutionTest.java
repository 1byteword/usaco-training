import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {

	protected milk3 solution;

	@Before
	public void setUp() {
		solution = new milk3();
	}

	@Test
	public void test0() {
		int[] milk3 = new int[] { 8, 9 , 10 };
		int[] expected = new int [] {1, 2, 8, 9, 10};
		int[] actual = solution.solve(milk3);
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void test1() {
		int[] milk3 = new int[] { 2, 5 , 10 };
		int[] expected = new int [] {5, 6, 7, 8, 9, 10};
		int[] actual = solution.solve(milk3);
		Assert.assertArrayEquals(expected, actual);
	}

	

}
