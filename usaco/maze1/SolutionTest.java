import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {

	protected maze1 solution;

	@Before
	public void setUp() {
		solution = new maze1();
	}

	@Test
	public void test0() {
		int w = 5;
		int h = 3;
		String[] map = new String[] {
				"+-+-+-+-+-+", 
				"|         |", 
				"+-+ +-+ + +", 
				"|     | | |", 
				"+ +-+-+ + +", 
				"| |     |  ", 
				"+-+ +-+-+-+"
		};

		int expected = 9;
		int actual = solution.solve(w, h, map);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test1() {
		int w = 1;
		int h = 1;
		String[] map = new String[] {
		        "+-+",  
		        "   ", 
		        "+-+" 
		};

		int expected = 1;
		int actual = solution.solve(w, h, map);
		Assert.assertEquals(expected, actual);
	}

}
