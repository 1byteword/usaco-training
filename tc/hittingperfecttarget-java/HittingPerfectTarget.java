public class HittingPerfectTarget {

	class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public String toString() {
			return String.format("(%d, %d)", x, y);
		}

		public boolean equals(Object obj) {
			if (!(obj instanceof Point))
				return false;
			Point other = (Point) obj;
			if (other.x != x)
				return false;
			return (other.y == y);
		}
	}

	class Vector extends Point {
		public Vector(Point start, Point end) {
			super(end.x - start.x, end.y - start.y);
		}

		public int cross(Vector other) {
			return x * other.y - y * other.x;
		}
	}

	private int pointOnLineSide(Point p, Point lineStart, Point lineEnd) {
		Vector line = new Vector(lineStart, p);
		Vector point = new Vector(lineStart, lineEnd);
		return sign(line.cross(point));
	}

	private int sign(int x) {
		if (x > 0)
			return 1;
		if (x < 0)
			return -1;
		return 0;
	}

	private boolean pointInPolygon(Point p, Point[] polygon) {
		int l = polygon.length;
		int side = pointOnLineSide(p, polygon[0], polygon[1]);
		for (int i = 0; i < l; i++) {
			int nextSide = pointOnLineSide(p, polygon[i], polygon[(i + 1) % l]);
			if (nextSide != 0) {
				if (side == 0) {
					side = nextSide;
				}
				if (side != nextSide) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean pointInPolygon(int px, int py, int[] x, int[] y) {
		Point p = new Point(px, py);
		int l = x.length;
		Point[] polygon = new Point[l];
		for (int i = 0; i < l; i++) {
			polygon[i] = new Point(x[i], y[i]);
		}
		return pointInPolygon(p, hull(polygon));
	}

	private Point[] hull(Point[] points) {
		int l = points.length;
		Point[] res = new Point[l];
		res[0] = leftmost(points);
		for (int i = 0; i < l - 1;) {
			Point p = leftmost(res[i], points);
			res[++i] = p;
		}

		return res;
	}

	private Point leftmost(Point point, Point[] points) {
		boolean onRight;
		for (Point p : points) {
			if (p.equals(point))
				continue;
			onRight = true;
			for (Point q : points) {
				if (pointOnLineSide(q, point, p) == -1) {
					onRight = false;
					break;
				}
			}
			if (onRight) {
				return p;
			}
		}
		return null;
	}

	private Point leftmost(Point[] points) {
		int minp = 0;
		int minx = points[0].x;
		for (int i = 0; i < points.length; i++) {
			if (points[i].x < minx) {
				minp = i;
				minx = points[i].x;
			}
		}
		return points[minp];
	}

	public double getProbability(int[] x1, int[] y1, int[] x2, int[] y2) {
		double hit = 0;
		double fire = 0;

		for (int px = -100; px <= 100; px++) {
			for (int py = -100; py <= 100; py++) {
				fire++;
				if (pointInPolygon(px, py, x1, y1)
						&& pointInPolygon(px, py, x2, y2)) {
					hit++;
				}
			}
		}

		return hit / fire;
	}

}
