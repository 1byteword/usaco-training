import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WhatSortTest {

    protected WhatSort solution;

    @Before
    public void setUp() {
        solution = new WhatSort();
    }

    @Test(timeout = 2000)
    public void testCase0() {
        String[] name = new String[]{"BOB", "BOB", "DAVE", "JOE"};
        int[] age = new int[]{22, 35, 35, 30};
        int[] wt = new int[]{122, 122, 195, 200};

        String expected = "IND";
        String actual = solution.sortType(name, age, wt);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase1() {
        String[] name = new String[]{"BOB", "BOB", "DAVE", "DAVE"};
        int[] age = new int[]{22, 35, 35, 30};
        int[] wt = new int[]{122, 122, 195, 200};

        String expected = "NOT";
        String actual = solution.sortType(name, age, wt);

        Assert.assertEquals(expected, actual);
    }

    @Test(timeout = 2000)
    public void testCase2() {
        String[] name = new String[]{"BOB", "BOB", "DAVE", "DAVE"};
        int[] age = new int[]{22, 35, 35, 30};
        int[] wt = new int[]{122, 122, 195, 190};

        String expected = "NWA";
        String actual = solution.sortType(name, age, wt);

        Assert.assertEquals(expected, actual);
    }

}
