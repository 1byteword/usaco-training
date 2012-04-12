import java.util.ArrayList;

public class Crossroads {

	private class Car {
		int angle;
		int index;

		public Car(int index, int angle) {
			this.angle = angle;
			this.index = index;
		}
		
		public String toString() {
			return String.format("(%d, %d)", index, angle);
		}
	}

	public int[] getOut(int[] angles) {
		ArrayList<Car> cars = new ArrayList<Car>();
		
		for (int  i = 0; i < angles.length; i++) {
			cars.add(new Car(i, angles[i]));
		}

		boolean changed = true;
		while (changed) {
			changed = false;
			for (int i = cars.size() - 1; i >= 1; i--) {
				Car curr = cars.get(i);
				Car prev = cars.get(i - 1);

				if (curr.angle > prev.angle) {
					changed = true;
					int currDiff = Math.abs(90 - curr.angle);
					int prevDiff = Math.abs(90 - prev.angle);
					if (currDiff > prevDiff) {
						cars.remove(i);
					} else if (currDiff == prevDiff) {
						cars.remove(i);
					} else {
						cars.remove(i - 1);
					}
				}
			}
		}

		int[] res = new int[cars.size()];
		for (int i = 0; i < cars.size(); i++) {
			res[i] = cars.get(i).index;
		}
		return res;
	}

}
