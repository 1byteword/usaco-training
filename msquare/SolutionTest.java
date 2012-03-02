
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
		int state = 12345678;
		String expected = "";
		String actual = solution.solve(state);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test1() {
		int state = 26845731;
		String expected = "BCABCCB";
		String actual = solution.solve(state);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test2() {
		int state = 61543278;
		String expected = "ABBBCABBBCBBBC";
		String actual = solution.solve(state);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test3() {
		int state = 41235876;
		String expected = "CCBCBCBBCBCBCCB";
		String actual = solution.solve(state);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test4() {
		int state = 34215678;
		String expected = "ABCABBBCBBBCBCABCB";
		String actual = solution.solve(state);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test5() {
		int state = 43125678;
		String expected = "ABBBCABBBCBBBCBCABCBBB";
		String actual = solution.solve(state);
		Assert.assertEquals(expected, actual);
	}


}
