public class SMBus {

	public int transmitTime(String[] messages, int[] times) {
		int l = messages.length;
		int sent = 0;
		boolean[] sents = new boolean[l];

		int res = 0;

		while (sent < l) {
			int active = l - sent;
			boolean[] actives = new boolean[l];
			for (int i = 0; i < l; i++)
				actives[i] = !sents[i];

			int lowest, elapse = 0, t;
			for (t = 0; active > 1; t++) {
				lowest = 9;
				elapse = 0;
				for (int i = 0; i < l; i++) {
					if (!actives[i]) continue;
					lowest = Math.min(lowest, messages[i].charAt(t) - '0');
					elapse = Math.max(elapse, times[i]);
				}
				for (int i = 0; i < l; i++) {
					if (!actives[i]) continue;
					actives[i] &= ((messages[i].charAt(t) - '0') == lowest);
					if (!actives[i]) active--;
				}
				res += elapse;
			}

			assert (active == 1);
			for (int i = 0; i < l; i++) {
				if (actives[i]) {
					res += (times[i] * (messages[i].length() - t));
					sents[i] = true;
				}
			}
			sent++;
		}

		return res;
	}

}
