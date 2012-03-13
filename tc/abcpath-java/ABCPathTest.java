import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ABCPathTest {

    protected ABCPath solution;

    @Before
    public void setUp() {
        solution = new ABCPath();
    }

    @Test
    public void testCase0() {
        String[] grid = new String[]{"ABE", "CFG", "BDH", "ABC"};

        int expected = 4;
        int actual = solution.length(grid);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCase1() {
        String[] grid = new String[]{"A"};

        int expected = 1;
        int actual = solution.length(grid);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCase2() {
        String[] grid = new String[]{"BCDEFGHIJKLMNOPQRSTUVWXYZ"};

        int expected = 0;
        int actual = solution.length(grid);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCase3() {
        String[] grid = new String[]{"C", "D", "B", "A"};

        int expected = 2;
        int actual = solution.length(grid);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCase4() {
        String[] grid = new String[]{"KCBVNRXSPVEGUEUFCODMOAXZYWEEWNYAAXRBKGACSLKYRVRKIO", "DIMCZDMFLAKUUEPMPGRKXSUUDFYETKYQGQHNFFEXFPXNYEFYEX", "DMFRPZCBOWGGHYAPRMXKZPYCSLMWVGMINAVRYUHJKBBRONQEXX", "ORGCBHXWMTIKYNLFHYBVHLZFYRPOLLAMBOPMNODWZUBLSQSDZQ", "QQXUAIPSCEXZTTINEOFTJDAOBVLXZJLYOQREADUWWSRSSJXDBV", "PEDHBZOVMFQQDUCOWVXZELSEBAMBRIKBTJSVMLCAABHAQGBWRP", "FUSMGCSCDLYQNIXTSTPJGZKDIAZGHXIOVGAZHYTMIWAIKPMHTJ", "QMUEDLXSREWNSMEWWRAUBFANSTOOJGFECBIROYCQTVEYGWPMTU", "FFATSKGRQJRIQXGAPLTSXELIHXOPUXIDWZHWNYUMXQEOJIAJDH", "LPUTCFHYQIWIYCVOEYHGQGAYRBTRZINKBOJULGYCULRMEOAOFP", "YOBMTVIKVJOSGRLKTBHEJPKVYNLJQEWNWARPRMZLDPTAVFIDTE", "OOBFZFOXIOZFWNIMLKOTFHGKQAXFCRZHPMPKGZIDFNBGMEAXIJ", "VQQFYCNJDQGJPYBVGESDIAJOBOLFPAOVXKPOVODGPFIYGEWITS", "AGVBSRLBUYOULWGFOFFYAAONJTLUWRGTYWDIXDXTMDTUYESDPK", "AAJOYGCBYTMXQSYSPTBWCSVUMNPRGPOEAVVBGMNHBXCVIQQINJ", "SPEDOAHYIDYUJXGLWGVEBGQSNKCURWYDPNXBZCDKVNRVEMRRXC", "DVESXKXPJBPSJFSZTGTWGAGCXINUXTICUCWLIBCVYDYUPBUKTS", "LPOWAPFNDRJLBUZTHYVFHVUIPOMMPUZFYTVUVDQREFKVWBPQFS", "QEASCLDOHJFTWMUODRKVCOTMUJUNNUYXZEPRHYOPUIKNGXYGBF", "XQUPBSNYOXBPTLOYUJIHFUICVQNAWFMZAQZLTXKBPIAKXGBHXX"};

        int expected = 19;
        int actual = solution.length(grid);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCase5() {
        String[] grid = new String[]{"EDCCBA", "EDCCBA"};

        int expected = 3;
        int actual = solution.length(grid);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCase6() {
        String[] grid = new String[]{"AMNOPA", "ALEFQR", "KDABGS", "AJCHUT", "AAIWVA", "AZYXAA"};

        int expected = 26;
        int actual = solution.length(grid);

        Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void testCase29() {
        String[] grid = new String[]{"ABCDEFGHIJKLMNOPQRTUVWXYZ", "BBCDEFGHIJKLMNOPQRTUVWXYZ", "CCCDEFGHIJKLMNOPQRTUVWXYZ", "DDDDEFGHIJKLMNOPQRTUVWXYZ", "EEEEEFGHIJKLMNOPQRTUVWXYZ", "FFFFFFGHIJKLMNOPQRTUVWXYZ", "GGGGGGGHIJKLMNOPQRTUVWXYZ", "HHHHHHHHIJKLMNOPQRTUVWXYZ", "IIIIIIIIIJKLMNOPQRTUVWXYZ", "JJJJJJJJJJKLMNOPQRTUVWXYZ", "KKKKKKKKKKKLMNOPQRTUVWXYZ", "LLLLLLLLLLLLMNOPQRTUVWXYZ", "MMMMMMMMMMMMMNOPQRTUVWXYZ", "NNNNNNNNNNNNNNOPQRTUVWXYZ", "OOOOOOOOOOOOOOOPQRTUVWXYZ", "PPPPPPPPPPPPPPPPQRTUVWXYZ", "QQQQQQQQQQQQQQQQQRTUVWXYZ", "RRRRRRRRRRRRRRRRRRTUVWXYZ", "TTTTTTTTTTTTTTTTTTTUVWXYZ", "UUUUUUUUUUUUUUUUUUUUVWXYZ", "VVVVVVVVVVVVVVVVVVVVVWXYZ", "WWWWWWWWWWWWWWWWWWWWWWXYZ", "XXXXXXXXXXXXXXXXXXXXXXXYZ", "YYYYYYYYYYYYYYYYYYYYYYYYZ", "ZZZZZZZZZZZZZZZZZZZZZZZZZ"};

        int expected = 18;
        int actual = solution.length(grid);

        Assert.assertEquals(expected, actual);
    }
    

}
