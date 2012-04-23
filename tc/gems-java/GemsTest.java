import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GemsTest {

    protected Gems solution;

    @Before
    public void setUp() {
        solution = new Gems();
    }

    @Test//(timeout = 2000)
    public void testCase0() {
        String[] board = new String[]{"ABC", "ABC", "BAD"};

        int expected = 1;
        int actual = solution.numMoves(board);

        Assert.assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase1() {
        String[] board = new String[]{"ABB", "BAA", "ABB"};

        int expected = 3;
        int actual = solution.numMoves(board);

        Assert.assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase2() {
        String[] board = new String[]{"ABA", "BAB", "ABA"};

        int expected = 4;
        int actual = solution.numMoves(board);

        Assert.assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase3() {
        String[] board = new String[]{"ABC", "DEF", "GHI"};

        int expected = 0;
        int actual = solution.numMoves(board);

        Assert.assertEquals(expected, actual);
    }

    @Test//(timeout = 2000)
    public void testCase4() {
        String[] board = new String[]{"SUMEEMEEPGPPG", "USPMIPSUSIISG", "UPSPGEGGPKEII", "KEMGISMKKIUIG", "MGSIIKMSISGKM", "SPGMSMIGMSMGM", "SSIIUKMPEPPUI", "UKUIUEMEEIGKE", "IPUPGUSEGSSUS", "EUPMKGGUKKEMI", "PEPSMUUEUSSIP", "SUMEEUSESUEKG", "EPSKUISGMSKGI", "IUGGUGGSIGUUP", "IUPIKKSGPPEEP", "KGEESGISPGGEM", "UEIUSSKPSSGPE", "KSUMKGEIMKPSE", "ESKEUEMMPPIGG", "UUIEUGGIGMEMK", "GPGMPPIUMEPMU", "IKIGGPIUEMIGS", "IPUSGUMKPKIPP", "UEEMUUEEGIPUS", "PPEKIKEMGGMSS", "EMKPMPUUMKEPU", "UKPGPKSUIEUPM", "PSUUMUKGIIPMS", "ESMGSKUEPGGEM", "SMEEIKGKGGPEG", "UEIEKPMESMEPP", "IPUIMGGMIPKMG", "ISSEKPKGKIUGU", "SSESKUGKISPUK"};

        int expected = 83;
        int actual = solution.numMoves(board);

        Assert.assertEquals(expected, actual);
    }

}
