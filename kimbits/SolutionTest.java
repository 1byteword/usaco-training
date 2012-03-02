import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {

	protected kimbits solution;

	@Before
	public void setUp() {
		solution = new kimbits();
	}

	@Test
	public void testMin() {
		int n = 4;
		int l = 2;  
		int k = 1; 
		String expected = "0000";
		String actual = solution.solve(n, l, k);
		Assert.assertEquals(expected, actual);
	}
	

	
	@Test
	public void test0() {
		int n = 5;
		int l = 3; // 01111 ( 1 << (l+1) - 1 = 15 ), 10111 (15 + (1 << l) ), 
		int k = 19; // 19 - 1(0) + 1(8+7) = 19
		String expected = "10011";
		String actual = solution.solve(n, l, k);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void test01() {
		int n = 5;
		int l = 3; // 01111 ( 1 << (l+1) - 1 = 15 ), 10111 (15 + (1 << l) ), 
		int k = 26; // 19 - 1(0) + 1(8+7) = 19
		String expected = "11100";
		String actual = solution.solve(n, l, k);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void test1() {
		int n = 21; // 0|00 01|11 11, 0|00 10|11 11,..., 1|00 00|11 11 
		int l = 10;
		int k = 1048576;
		String expected = "111111111100000000000";
		String actual = solution.solve(n, l, k);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test2() {
		int n = 31;
		int l = 24;
		int k = 10000000;
		String expected = "0000000100110001001011001111111";
		String actual = solution.solve(n, l, k);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void test3() {
		int n = 24;
		int l = 20;
		long k = 12936478;
		String expected = "110001010110011100110000";
		String actual = solution.solve(n, l, k);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test4() {
		int n = 31;
		int l = 26;
		long k = 123456789;
		String expected = "0000111010110111100110100010100";
		String actual = solution.solve(n, l, k);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void test5() {
		int n = 31;
		int l = 30;
		long k = (1L << 30);
		String expected = "0111111111111111111111111111111";
		String actual = solution.solve(n, l, k);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testMax() {
		int n = 31;
		int l = 31;
		long k = 2147483648L;
		String expected = "1111111111111111111111111111111";
		String actual = solution.solve(n, l, k);
		Assert.assertEquals(expected, actual);
	}



	@Test
	public void testPrintBinary0() {
		int n = 2;
		int l = 3;
		String expected = "010";
		String actual = solution.printBinary(n, l);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testPrintBinary1() {
		int n = 19;
		int l = 6;
		String expected = "010011";
		String actual = solution.printBinary(n, l);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testPrintBinaryBig() {
		long n = (1L << 31);
		int l = 31;
		String expected = "10000000000000000000000000000000";
		String actual = solution.printBinary(n, l);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testPrintBinaryMax() {
		long n = 2147483647L;
		int l = 31;
		String expected = "1111111111111111111111111111111";
		String actual = solution.printBinary(n, l);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testNChooseK1() {
		int n = 6;
		int k = 1;
		long expected = 6L;
		long actual = solution.nchoosek(n, k);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testNChooseK2() {
		int n = 6;
		int k = 2;
		long expected = 15L;
		long actual = solution.nchoosek(n, k);
		Assert.assertEquals(expected, actual);
	}
	
	

}
