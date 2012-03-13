import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {

	protected rect1 solution;

	@Before
	public void setUp() {
		solution = new rect1();
	}

	@Test
	public void test0() {
		int a = 20;
		int b = 20;
		String[] rects = new String[] { "2 2 18 18 2", "0 8 19 19 3", "8 0 10 19 4"};
		String[] expected = new String[] {
				"1 91",
				"2 84",
				"3 187",
				"4 38"
		};
		String[] actual = solution.solve(a, b, rects);
		Assert.assertArrayEquals(expected, actual);
	}
	

	@Test
	public void test1() {
		int a = 800;
		int b = 800;
		String[] rects = new String[] { "10 10 790 790 2", "20 0 30 800 1"};
		String[] expected = new String[] {
				"1 39400",
				"2 600600"
		};
		String[] actual = solution.solve(a, b, rects);
		Assert.assertArrayEquals(expected, actual);
	}
	
     
     

}
