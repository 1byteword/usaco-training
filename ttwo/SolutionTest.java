import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {

	protected ttwo solution;

	@Before
	public void setUp() {
		solution = new ttwo();
	}

	@Test
	public void test0() {
		String[] map = new String[] {
				"*...*.....", 
				"......*...", 
				"...*...*..", 
				"..........", 
				"...*.F....", 
				"*.....*...", 
				"...*......", 
				"..C......*", 
				"...*.*....", 
				".*.*......"
		};

		int expected = 49;
		int actual = solution.solve(map);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void test1() {
		String[] map = new String[] {
				".****...*. ", 
				"..*......* ", 
				"*......... ", 
				".......... ", 
				"*........* ", 
				"*.**.*..** ", 
				"F..*...... ", 
				"***....*.* ", 
				".C.......* ", 
				".......*.* " 
		};

		int expected = 58;
		int actual = solution.solve(map);
		Assert.assertEquals(expected, actual);
	}
	
	

}
