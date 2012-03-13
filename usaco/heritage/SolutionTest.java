import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {

	protected heritage solution;

	@Before
	public void setUp() {
		solution = new heritage();
	}

	@Test
	public void test0() {
		char[] in = "ABEDFCHG".toCharArray();
		char[] pre = "CBADEFGH".toCharArray();
		char[] expected = "AEFDBHGC".toCharArray();
		char[] actual = solution.solve(in, pre);
		Assert.assertArrayEquals(expected, actual);
	}
	
	@Test
	public void test1() {
		char[] in = "GOLEAFS".toCharArray();
		char[] pre = "SFAELOG".toCharArray();
		char[] expected = "GOLEAFS".toCharArray();
		char[] actual = solution.solve(in, pre);
		Assert.assertArrayEquals(expected, actual);
	}
	
	 
     

	
	
}
