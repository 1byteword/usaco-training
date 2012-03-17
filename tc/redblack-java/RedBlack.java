public class RedBlack {

	private final static int RED = 0;
	private final static int BLACK = 1;

	class Node {
		int value;
		int color;
		Node[] children = new Node[2];
		Node parent;

		public Node(int value, Node parent) {
			this.value = value;
			this.color = RED;
			this.parent = parent;
		}
	}

	Node root = null;

	private Node treeInsert(int value) {
		if (root == null) {
			root = new Node(value, null);
			return root;
		} else {
			Node parent = null;
			Node current = root;
			int dir = 0;
			while (current != null) {
				dir = current.value > value ? 0 : 1;
				parent = current;
				current = current.children[dir];
			}
			Node inserted = new Node(value, parent);
			parent.children[dir] = inserted;
			return inserted;
		}
	}

	int twistCount = 0;

	private void balanceInsert(int value) {
		Node node = treeInsert(value);
		if (node.parent != null) {
			if (node.parent.color == RED) {
				// TODO: recursively twist
				twist(node);
			}
		}
	}

	private void twist(Node node) {
		Node parent = node.parent;
		Node grandparent = parent.parent;
		if (grandparent == null) return;
		twistCount++;

		Node x, y, z;
		Node T1, T2, T3, T4;
		if (parent == grandparent.children[0]) {
			if (node == parent.children[0]) {
				z = grandparent;
				y = parent;
				x = node;
				T4 = z.children[1];
				T3 = y.children[1];
				T2 = x.children[1];
				T1 = x.children[0];
			} else {
				z = grandparent;
				x = parent;
				y = node;
				T4 = z.children[1];
				T3 = y.children[1];
				T2 = y.children[0];
				T1 = x.children[0];
			}
		} else {
			if (node == parent.children[0]) {
				x = grandparent;
				z = parent;
				y = node;
				T4 = z.children[1];
				T3 = y.children[1];
				T2 = y.children[0];
				T1 = x.children[0];
			} else {
				x = grandparent;
				y = parent;
				z = node;
				T4 = z.children[1];
				T3 = z.children[0];
				T2 = y.children[0];
				T1 = x.children[0];
			}
		}

		Node upper = grandparent.parent;
		if (upper != null) {
			int dir = upper.children[0] == grandparent ? 0 : 1;
			upper.children[dir] = y;
		}
		y.parent = upper;
		y.children[0] = x;
		x.parent = y;
		y.children[1] = z;
		z.parent = y;
		x.children[0] = T1;
		if (T1 != null) T1.parent = x;
		x.children[1] = T2;
		if (T2 != null) T2.parent = x;
		z.children[0] = T3;
		if (T3 != null) T3.parent = z;
		z.children[1] = T4;
		if (T4 != null) T4.parent = z;

		y.color = RED;
		x.color = BLACK;
		z.color = BLACK;

		if (y.parent != null) {
			if (y.parent.color == RED) {
				twist(y);
			}
		} else {
			root = y;
			root.color = BLACK;
		}
	}

	public int numTwists(int[] keys) {
		for (int i : keys) {
			balanceInsert(i);
		}
		return twistCount;
	}

}
