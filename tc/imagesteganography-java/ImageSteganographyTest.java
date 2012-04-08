import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ImageSteganographyTest {

    protected ImageSteganography solution;

    @Before
    public void setUp() {
        solution = new ImageSteganography();
    }

    @Test//(timeout = 2000)
    public void testCase0() {
        String[] image = new String[]{"255123212001201222"};
        String message = "hi";

        String[] expected = new String[]{"254120214003200222"};
        String[] actual = solution.encode(image, message);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase1() {
        String[] image = new String[]{"255123212", "001201222"};
        String message = "hi";

        String[] expected = new String[]{"254120214", "003200222"};
        String[] actual = solution.encode(image, message);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase2() {
        String[] image = new String[]{"123234213001023213123145", "222111121101213198009", "121122123124125", "132212093039", "213110"};
        String message = "Hello 1";

        String[] expected = new String[]{"120234212003023213122145", "222110121102213198010", "120120120126125", "135215095039", "215111"};
        String[] actual = solution.encode(image, message);

        Assert.assertArrayEquals(expected, actual);
    }

}
