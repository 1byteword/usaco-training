import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import javax.swing.event.ListSelectionEvent;

public class Diving {

	public String needed(String difficulty_str, String need_str, String ratings_str) {
		
		double difficulty  = Double.parseDouble(difficulty_str);
		double need = Double.parseDouble(need_str);
		
		ArrayList<Double> ratings = new ArrayList<Double>();  
		for (String s : ratings_str.split(" ")) {
			if (! s.equalsIgnoreCase("?.?")) {
				ratings.add(Double.parseDouble(s));
			}
		}
		
		for (int i = 0; i <= 10; i++) {
			for (int j = 0; j <= 5;j += 5) {
				String missing_str = String.format("%d.%d", i, j);
				double missing = Double.parseDouble(missing_str);
				ArrayList<Double> ratings_temp = new ArrayList<Double>();
				ratings_temp.addAll(ratings);
				if (cal_rating(difficulty, ratings_temp, missing) >= need) {
					return missing_str;
				}
			}
		}
		
		return "-1.0";
	}

	private double cal_rating(double difficulty, ArrayList<Double> ratings, double missing) {
		Collections.sort(ratings);
		if (missing <= ratings.get(0)) {
			ratings.remove(ratings.size() - 1);
		} else if (missing >= ratings.get(ratings.size() - 1)) {
			ratings.remove(0);
		} else {
			ratings.remove(ratings.size() - 1);
			ratings.remove(0);
			ratings.add(missing);
		}
		
		double sum = 0.0;
		for (double r : ratings) {
			sum += r;
		}
		
		double res = sum * difficulty;
		
		res = Math.round(res * 100.0) / 100.0;
		
		return res;
	}

}
