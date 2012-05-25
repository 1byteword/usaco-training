public class OneFight {

	public int monsterKilling(int[] life, int[] damage, int yourDamage) {
		int l = life.length;
		boolean[] killed = new boolean[l];
		return 1 + killing(life, damage, yourDamage, killed);
	}

	private int killing(int[] life, int[] damage, int yourDamage,
			boolean[] killed) {
		int res = Integer.MAX_VALUE;
		int l = life.length;
		for (int i = 0; i < l; i++) {
			if (killed[i]) continue;
			int hits = life[i] / yourDamage + (life[i] % yourDamage > 0 ? 1 : 0);
			int killThis = hits * damage( damage, killed);
			
			killed[i] = true;
			res = Math.min(res, killThis + killing(life, damage, yourDamage, killed));
			killed[i] = false;
		}
		return res == Integer.MAX_VALUE ? 0 : res;
	}

	private int damage(int[] damage, boolean[] killed) {
		int res = 0;
		int l = damage.length;
		for (int i = 0; i < l; i++) {
			res += killed[i] ? 0 : damage[i];
		}
		return res;
	}

}
