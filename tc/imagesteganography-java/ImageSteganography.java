public class ImageSteganography {

	public String[] encode(String[] image, String message) {
		int n = image.length;
		String original = "";
		for (String s : image) {
			original += s;
		}

		String encoded = encode(original, message);

		String[] res = new String[n];
		int start = 0;
		for (int i = 0; i < n; i++) {
			int l = image[i].length();
			res[i] = encoded.substring(start, start + l);
			start += l;
		}
		return res;
	}

	private String encode(String original, String message) {
		int po = 0;
		String res = "";
		for (int i = 0; i < message.length(); i++) {
			int[] bits = encode(message.charAt(i));
			for (int j = 0; j < 3; j++) {
				int value = Integer.parseInt(original.substring(po, po + 3));
				String s = printPadded(bits[j], value);
				res += s;
				po += 3;
			}
		}
		
		while( po < original.length()) {
			int value = Integer.parseInt(original.substring(po, po + 3));
			String s = printPadded(3, value);
			res += s;
			po += 3;
		}
		
		return res;
	}

	private String printPadded(int bit, int value) {
		String s = String.valueOf(value & 252 | bit);
		int diff = 3 - s.length();
		for (int k = 0; k < diff ; k++) {
			s = "0" + s;
		}
		return s;
	}

	private int[] encode(char c) {
		int[] res = new int[3];

		int b = 0;
		if (c == ' ') {
			b = 0;
		} else if (c >= 'A' && c <= 'Z') {
			b = 1 + (c - 'A');
		} else if (c >= 'a' && c <= 'z') {
			b = 27 + (c - 'a');
		} else if (c >= '0' && c <= '9') {
			b = 53 + (c - '0');
		}
		
		for (int i = 0; i < 3; i++) {
			res[i] = b & 3;
			b = b >> 2;
		}

		return res;
	}

}
