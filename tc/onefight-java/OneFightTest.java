import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OneFightTest {

    protected OneFight solution;

    @Before
    public void setUp() {
        solution = new OneFight();
    }

    @Test//(timeout = 2000)
    public void testCase0() {
        int[] life = new int[]{3};
        int[] damage = new int[]{10};
        int yourDamage = 2;

        int expected = 21;
        int actual = solution.monsterKilling(life, damage, yourDamage);

        Assert.assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase1() {
        int[] life = new int[]{5, 1};
        int[] damage = new int[]{5, 3};
        int yourDamage = 3;

        int expected = 19;
        int actual = solution.monsterKilling(life, damage, yourDamage);

        Assert.assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase2() {
        int[] life = new int[]{5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
        int[] damage = new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        int yourDamage = 100;

        int expected = 2201;
        int actual = solution.monsterKilling(life, damage, yourDamage);

        Assert.assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase3() {
        int[] life = new int[]{6, 34, 21, 79, 31, 5, 8, 23, 9, 100};
        int[] damage = new int[]{1, 65, 95, 32, 48, 9, 3, 13, 100, 4};
        int yourDamage = 4;

        int expected = 6554;
        int actual = solution.monsterKilling(life, damage, yourDamage);

        Assert.assertEquals(expected, actual);
    }

}
