import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {

	protected calfflac solution;

	@Before
	public void setUp() {
		solution = new calfflac();
	}

	@Test
	public void testCase0() {
		String input = "Confucius say: Madam, I'm Adam.";
		String[] expected = new String[] { "11", "Madam, I'm Adam" };
		String[] actual = solution.solve(input);
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void testTwoMax() {
		String input = "if (abs(terms[lv][lv2]) != 1 || (lv == 0 && lv2 == 0))";
		String[] expected = new String[] { "7", "lv][lv2]) != 1 || (lv == 0 && l" };
		String[] actual = solution.solve(input);
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void testLongSame() {
		String input = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		String[] expected = new String[] { String.valueOf(input.length()), input };
		String[] actual = solution.solve(input);
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void testNewline() {
		String input = "oVWQdDOCVvYDkddLvOvKjXMuMkgXUXjmNuefqh{hOUCIqRnCDhzSMqZxNGGJTtCeqKwdBTQmFqFGXCsc\n"
				+ "qwOSqnZhPOVQRqWpdViEWDoxgWcRd[XJzqQfjFqZMwgfsFUOr{wrLbXwTUDFeJXr[Tu{dEZHqP[nEBRN\n"
				+ "imnEmpHCVPlXWnPDEX[hIVQkNFyKZFwKvQGfS{wtHfZXmlJhZytqBSzfgjybhRFsUiRWNoXrBHfhT[Ub\n"
				+ "hZFPieTHsRUhuJybRBVoRhkc[YpfkxWlxJBUM[nxTexrvOKekyHBqodODD[GGMRVBki[m[XJgze{yY[P\n"
				+ "[pgNtDJeBjnxDxkdKTyGhMF{pinIdypWSOUfCqFLWuvYFKvsuczNxgRvHuOZmmouJucHj[DlhLwnSocm\n"
				+ "crMCltuwhvqjEnDpeIeKjbFdCNEzsNkZhepYP[uD[mlkVwXt[NiLjoNxgPTSVSivgWtjRdNQjjePpQrE\n"
				+ "RjGKobNUvWdXqnWbqWbSSpizKcDDKyGTIruwbqSmioKDG{YiGMhlSroLOFpRHhIjMMCBWdsdlDPUK[nF\n"
				+ "DsMyjPOG{XClqcsBWzKOxsVIejVqCMyOebKeRqRFc[GgHbDxCtMrrnEdfbsRXCGgWrvjOTOWXBCMIynt\n"
				+ "cQRgUvUYMePMdJnXljKfNkpWGNPRHGbgOMD[qwQERqoXgoEQipSzXmLiGHeofoubFLcEELFqPD[bRoTM\n"
				+ "MToRb[DPqFLEEcLFbuofoeHGiLmXzSpiQEogXoqREQwq[DMOgbGHRPNGWpkNfKjlXnJdMPeMYUvUgRQc\n"
				+ "tnyIMCBXWOTOjvrWgGCXRsbfdEnrrMtCxDbHgG[cFRqReKbeOyMCqVjeIVsxOKzWBscqlCX{GOPjyMsD\n"
				+ "Fn[KUPDldsdWBCMMjIhHRpFOLorSlhMGiY{GDKoimSqbwurITGyKDDcKzipSSbWqbWnqXdWvUNboKGjR\n"
				+ "ErQpPejjQNdRjtWgviSVSTPgxNojLiN[tXwVklm[Du[PYpehZkNszENCdFbjKeIepDnEjqvhwutlCMrc\n"
				+ "mcoSnwLhlD[jHcuJuommZOuHvRgxNzcusvKFYvuWLFqCfUOSWpydInip{FMhGyTKdkxDxnjBeJDtNgp[\n"
				+ "OLebjbJLTfpDgTRylEkXJUngwpTKcQXywvExPfuHU{mkKgnndozu[PIjrnRpWgWR{FOLViUdYMmoUQmo\n"
				+ "LJQmSmJveThW{qrxvzzVdbVRcnpIT{BKbGSPGGLyeUtiyUdtMcYygDYbLvvOirlOI{Gi{BkZVWujRmJY\n"
				+ "PUtGlQGogRTcyknwDVRpgwrMtxCUkGkxRjSI{INnxQhZmNgHBDmpOBQfXlctnIOPEGC[QpOsnMmBjRxj";

		String[] expected = new String[] {
				"776",
				"pgNtDJeBjnxDxkdKTyGhMF{pinIdypWSOUfCqFLWuvYFKvsuczNxgRvHuOZmmouJucHj[DlhLwnSocm\n"
						+ "crMCltuwhvqjEnDpeIeKjbFdCNEzsNkZhepYP[uD[mlkVwXt[NiLjoNxgPTSVSivgWtjRdNQjjePpQrE\n"
						+ "RjGKobNUvWdXqnWbqWbSSpizKcDDKyGTIruwbqSmioKDG{YiGMhlSroLOFpRHhIjMMCBWdsdlDPUK[nF\n"
						+ "DsMyjPOG{XClqcsBWzKOxsVIejVqCMyOebKeRqRFc[GgHbDxCtMrrnEdfbsRXCGgWrvjOTOWXBCMIynt\n"
						+ "cQRgUvUYMePMdJnXljKfNkpWGNPRHGbgOMD[qwQERqoXgoEQipSzXmLiGHeofoubFLcEELFqPD[bRoTM\n"
						+ "MToRb[DPqFLEEcLFbuofoeHGiLmXzSpiQEogXoqREQwq[DMOgbGHRPNGWpkNfKjlXnJdMPeMYUvUgRQc\n"
						+ "tnyIMCBXWOTOjvrWgGCXRsbfdEnrrMtCxDbHgG[cFRqReKbeOyMCqVjeIVsxOKzWBscqlCX{GOPjyMsD\n"
						+ "Fn[KUPDldsdWBCMMjIhHRpFOLorSlhMGiY{GDKoimSqbwurITGyKDDcKzipSSbWqbWnqXdWvUNboKGjR\n"
						+ "ErQpPejjQNdRjtWgviSVSTPgxNojLiN[tXwVklm[Du[PYpehZkNszENCdFbjKeIepDnEjqvhwutlCMrc\n"
						+ "mcoSnwLhlD[jHcuJuommZOuHvRgxNzcusvKFYvuWLFqCfUOSWpydInip{FMhGyTKdkxDxnjBeJDtNgp" };
		String[] actual = solution.solve(input);
		Assert.assertArrayEquals(expected, actual);
	}

}
