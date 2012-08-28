// BEGIN CUT HERE

// END CUT HERE
using System;
using System.Text;
using System.Text.RegularExpressions;
using System.Collections;
using System.Collections.Generic;


public class DequeSort {
    public int minDeques(int[] data) {
        int l = data.Length;
        int[] sorted = new int[l];
        data.CopyTo(sorted, 0);
        Array.Sort(sorted);

        List<List<int>> deques = new List<List<int>>();

        foreach (int d in data) {
            int p = Array.IndexOf(sorted, d);
            bool found = false;
            for (int i = 0; i < deques.Count; i++) {
                int cnt = deques[i].Count;
                if (deques[i][0] == p + 1) {
                    deques[i].Insert(0, p);
                    found = true;
                    break;
                } else if (deques[i][cnt - 1] == p - 1) {
                    deques[i].Add(p);
                    found = true;
                    break;
                }
            }
            if (!found) {
                deques.Add(new List<int>());
                deques[deques.Count - 1].Add(p);
            }
        }

        return deques.Count;
    }

    // BEGIN CUT HERE
    public static void Main(String[] args) {
        eq(0, (new DequeSort()).minDeques(new int[] {50, 45, 55, 60, 65,
                40, 70, 35, 30, 75}), 1);
        eq(1, (new DequeSort()).minDeques(new int[] { 3, 6, 0, 9, 5, 4 }), 2);
        eq(2, (new DequeSort()).minDeques(new int[] { 0, 2, 1, 4, 3, 6, 5, 8, 7, 9 }), 5);
    }
    private static void eq(int n, object have, object need) {
        if (eq(have, need)) {
            Console.WriteLine("Case " + n + " passed.");
        } else {
            Console.Write("Case " + n + " failed: expected ");
            print(need);
            Console.Write(", received ");
            print(have);
            Console.WriteLine();
        }
    }
    private static void eq(int n, Array have, Array need) {
        if (have == null || have.Length != need.Length) {
            Console.WriteLine("Case " + n + " failed: returned " + have.Length + " elements; expected " + need.Length + " elements.");
            print(have);
            print(need);
            return;
        }
        for (int i = 0; i < have.Length; i++) {
            if (!eq(have.GetValue(i), need.GetValue(i))) {
                Console.WriteLine("Case " + n + " failed. Expected and returned array differ in position " + i);
                print(have);
                print(need);
                return;
            }
        }
        Console.WriteLine("Case " + n + " passed.");
    }
    private static bool eq(object a, object b) {
        if (a is double && b is double) {
            return Math.Abs((double)a - (double)b) < 1E-9;
        } else {
            return a != null && b != null && a.Equals(b);
        }
    }
    private static void print(object a) {
        if (a is string) {
            Console.Write("\"{0}\"", a);
        } else if (a is long) {
            Console.Write("{0}L", a);
        } else {
            Console.Write(a);
        }
    }
    private static void print(Array a) {
        if (a == null) {
            Console.WriteLine("<NULL>");
        }
        Console.Write('{');
        for (int i = 0; i < a.Length; i++) {
            print(a.GetValue(i));
            if (i != a.Length - 1) {
                Console.Write(", ");
            }
        }
        Console.WriteLine('}');
    }
    // END CUT HERE
}
