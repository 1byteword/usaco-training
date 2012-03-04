import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {

	protected msquare solution;

	@Before
	public void setUp() {
		solution = new msquare();
	}

	@Test
	public void test0() {
		short[] state = new short[] { 1, 2, 3, 4, 5, 6, 7, 8 };
		String expected = "";
		String actual = solution.solve(state);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test1() {
		short[] state = new short[] { 2, 6, 8, 4, 5, 7, 3, 1};
		String expected = "BCABCCB";
		String actual = solution.solve(state);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test2() {
		short[] state = new short[] { 6, 1, 5, 4, 3, 2, 7, 8};
		String expected = "ABBBCABBBCBBBC";
		String actual = solution.solve(state);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test3() {
		short[] state = new short[] { 4, 1, 2, 3, 5, 8, 7, 6};
		String expected = "CCBCBCBBCBCBCCB";
		String actual = solution.solve(state);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test4() {
		short[] state = new short[] {  3, 4, 2, 1, 5, 6, 7, 8};
		String expected = "ABCABBBCBBBCBCABCB";
		String actual = solution.solve(state);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test5() {
		short[] state = new short[] {  4, 3, 1, 2, 5, 6, 7, 8};
		String expected = "ABBBCABBBCBBBCBCABCBBB";
		String actual = solution.solve(state);
		Assert.assertEquals(expected, actual);
	}

}
