import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CountriesRanklistTest {

    protected CountriesRanklist solution;

    @Before
    public void setUp() {
        solution = new CountriesRanklist();
    }

    @Test//(timeout = 2000)
    public void testCase0() {
        String[] knownPoints = new String[]{"Poland Krzysztof 101", "Ukraine Evgeni 30", "Ukraine Ivan 24"};

        String[] expected = new String[]{"Poland 1 1", "Ukraine 2 2"};
        String[] actual = solution.findPlaces(knownPoints);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase1() {
        String[] knownPoints = new String[]{"Poland Krzysztof 100", "CzechRep Martin 30", "CzechRep Jirka 25"};

        String[] expected = new String[]{"CzechRep 1 2", "Poland 1 2"};
        String[] actual = solution.findPlaces(knownPoints);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase2() {
        String[] knownPoints = new String[]{"Slovakia Marian 270", "Hungary Istvan 24", "Poland Krzysztof 100", "Hungary Gyula 30", "Germany Tobias 27", "Germany Juergen 27"};

        String[] expected = new String[]{"Germany 2 4", "Hungary 2 4", "Poland 2 2", "Slovakia 1 1"};
        String[] actual = solution.findPlaces(knownPoints);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase3() {
        String[] knownPoints = new String[]{"usa Jack 14", "USA Jim 10", "USA Jim 10", "USA Jim 10", "USA Jim 10", "usa Jack 14", "usa Jack 14", "Zimbabwe Jack 10"};

        String[] expected = new String[]{"USA 2 2", "Zimbabwe 3 3", "usa 1 1"};
        String[] actual = solution.findPlaces(knownPoints);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase4() {
        String[] knownPoints = new String[]{"A a 9", "A b 9", "A c 9", "A d 9", "B e 9", "B f 9", "B g 8", "B h 8", "C i 9", "C j 9", "C k 9", "C l 7", "D m 1", "D n 1", "D o 1", "D p 1"};

        String[] expected = new String[]{"A 1 1", "B 2 2", "C 2 2", "D 4 4"};
        String[] actual = solution.findPlaces(knownPoints);

        Assert.assertArrayEquals(expected, actual);
    }

}
