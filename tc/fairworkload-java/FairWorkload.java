public class FairWorkload {

	public int getMostWork(int[] folders, int workers) {
		return most(folders, 0, workers);
	}

	private int most(int[] folders, int start, int workers) {
		   int firstWork = 0;
		   if (workers == 1) {
		       for (int first = start; first < folders.length; first++) {
		             firstWork += folders[first];
		       }
		       return firstWork; 
		   }

		   int min = Integer.MAX_VALUE;
		   for (int first = start; first < folders.length; first++) {
			      firstWork += folders[first];
			      int max = Math.max(firstWork, most(folders, first + 1, workers - 1));
			      min = Math.min(min, max);
		   }
		   
		   return min;


	}
}
