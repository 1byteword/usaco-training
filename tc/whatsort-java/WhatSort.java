import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class WhatSort {

	private class Person {
		String name;
		int age;
		int wt;

		public Person(String n, int a, int w) {
			name = n;
			age = a;
			wt = w;
		}
		
		public String toString() {
			return String.format("(%s, %d, %d)", name, age, wt);
		}
	}

	private class PersonComparer implements Comparator<Person> {
		private String type;

		public PersonComparer(String type) {
			this.type = type;
		}

		private static final String DIMS = "NAW";

		public int compare(Person p1, Person p2) {
			int[] cmps = new int[] { p1.name.compareTo(p2.name),
					p1.age - p2.age, p2.wt - p1.wt };

			for (int i = 0; i < 3; i++) {
				for (int dim = 0; dim < 3; dim++) {
					if (type.charAt(i) == DIMS.charAt(dim) && cmps[dim] != 0)
						return cmps[dim];
				}
			}

			return 0;
		}
	}

	private static final String[] SORT_TYPES = new String[] { "NAW", "NWA",
			"ANW", "AWN", "WAN", "WNA" };

	public String sortType(String[] name, int[] age, int[] wt) {
		ArrayList<Person> people = new ArrayList<Person>();
		for (int i = 0; i < name.length; i++) {
			people.add(new Person(name[i], age[i], wt[i]));
		}

		String res = "NOT";
		for (String type : SORT_TYPES) {
			PersonComparer comparer = new PersonComparer(type);
			ArrayList<Person> sorted = new ArrayList<Person>(people);
			Collections.sort(sorted, comparer);
			if (same(people, sorted)) {
				if (res.equals("NOT")) {
					res = type;
				} else {
					return "IND";
				}
			}
		}
		return res;
	}

	private static boolean same(ArrayList<Person> people,
			ArrayList<Person> sorted) {
		assert (people.size() == sorted.size());
		for (int i = 0; i < people.size(); i++) {
			if (!people.get(i).equals(sorted.get(i)))
				return false;
		}
		return true;
	}
}
