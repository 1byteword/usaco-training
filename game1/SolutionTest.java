import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {

	protected game1 solution;

	@Before
	public void setUp() {
		solution = new game1();
	}

	@Test
	public void test0() {
		int[] numbers = new int[] { 4, 7, 2, 9, 5, 2 };
		int[] expected = new int[] { 18, 11 };
		int[] actual = solution.solve(numbers);
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void test1() {
		int[] numbers = new int[] { 105, 57, 64, 79, 188, 102, 52, 145, 188, 2, 163, 147, 174, 163, 198, 9, 133, 159, 184, 104, 70, 19, 57, 174, 184, 57, 154, 123, 106, 129 };
		int[] expected = new int[] { 2043, 1446 };
		int[] actual = solution.solve(numbers);
		Assert.assertArrayEquals(expected, actual);
	}

	
	
}
