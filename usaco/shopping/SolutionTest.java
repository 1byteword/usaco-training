import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class SolutionTest {

	protected shopping solution;

	@Before
	public void setUp() {
		solution = new shopping();
	}

	@Test
	public void test0() {
		String[] offers = new String[] { "1 7 3 5", "2 7 1 8 2 10" };
		String[] products = new String[] { "7 3 2", "8 2 5" };
		int expected = 14;
		int actual = solution.solve(offers, products);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testBasket0() {
		int[] content = new int[] { 0, 2, 0, 0, 0 };
		shopping.Basket b = solution.new Basket(content);
		int expected = 2;
		int actual = b.getItem(1);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testBasket1() {
		int[] content = new int[] { 1, 2, 3, 4, 5 };
		shopping.Basket b = solution.new Basket(content);
		int expected = 3;
		int actual = b.getItem(2);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testBasket2() {
		int[] content = new int[] { 1, 2, 3, 4, 5 };
		shopping.Basket b = solution.new Basket(content);
		int expected = 5;
		int actual = b.getItem(4);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testBasket3() {
		int[] content = new int[] { 1, 2, 3, 4, 5 };
		shopping.Basket b = solution.new Basket(content);
		String expected = "1 2 3 4 5";
		String actual = b.toString();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testBasket4() {
		shopping.Basket b1 = solution.new Basket(new int[] { 1, 2, 3, 4, 5 });
		shopping.Basket b2 = solution.new Basket(new int[] { 1, 2, 3, 4, 5 });
		
		boolean actual = b1.contains(b2);
		Assert.assertEquals(true, actual);
	}

	@Test
	public void testBasket5() {
		shopping.Basket b1 = solution.new Basket(new int[] { 5, 4, 3, 2, 1 });
		shopping.Basket b2 = solution.new Basket(new int[] { 1, 2, 3, 4, 5 });
		
		boolean actual = b1.contains(b2);
		Assert.assertEquals(false, actual);
	}

}
