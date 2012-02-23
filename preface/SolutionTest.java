import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {

	protected preface solution;

	@Before
	public void setUp() {
		solution = new preface();
	}

	@Test
	public void test0() {
		int n = 5;
		String[] expected = new String[] { "I 7", "V 2" };
		String[] actual = solution.solve(n);
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void testRomans() {
		int[] nums = new int[] { 5, 800, 3, 300 , 268, 39, 490, 99, 990,
				90
				};
		String[] expected = new String[] { "V", "DCCC", "III", "CCC" , "CCLXVIII", "XXXIX", "CDXC", "XCIX", "CMXC",
				"XC"
				};
		String[] actual = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			actual[i] = solution.convert(nums[i]);
		}

		Assert.assertArrayEquals(expected, actual);
	}

}
