public class RunLengthEncoding {

	public String decode(String text) {
		String res = "";
		int prev = 0;
		for (int i = 0 ; i < text.length(); i++) {
			char c = text.charAt(i);
			if (!Character.isDigit(c)) {
				int n  = 1;
				if (prev < i) {
					if (i - prev > 3) return "TOO LONG";
					n = Integer.parseInt(text.substring(prev, i));
				}
				for (int j = 0 ; j < n; j++) {
					res += String.valueOf(c);
				}
				prev = i + 1;
			}
			if (res.length() > 50) return "TOO LONG";
		}
		return res;
	}

}
