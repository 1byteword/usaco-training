import java.util.ArrayList;
import java.util.Collections;

public class ProgramSchedule {
	private class Program implements Comparable<Program> {
		int prep;
		int run;
		
		public Program(int p, int r) {
			prep = p;
			run = r;
		}

		public int compareTo(Program other) {
			if (run == other.run) return prep - other.prep;
			return other.run  - run;
		}
		
	}

	public int schedule(int[] A, int[] B) {
		
		ArrayList<Program> programs = new ArrayList<Program>();
		for (int i = 0; i < A.length; i++) {
			programs.add(new Program(A[i], B[i]));
		}
		
		int start = 0;
		int end = 0;
		
		Collections.sort(programs);
		
		for (Program next : programs) {
			start += next.prep;
			end = Math.max(end, start + next.run);
		}
		
		return end;
	}

}
