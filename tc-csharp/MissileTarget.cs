// BEGIN CUT HERE

// END CUT HERE
using System;
using System.Text;
using System.Text.RegularExpressions;
using System.Collections;
using System.Collections.Generic;


public class MissileTarget {
    public int[] bestFit(int[] x, int[] y) {
        int[] res = new int[2];
        res[0] = best(x);
        res[1] = best(y);
        return res;
    }

    private int best(int[] xs) {
        double sum = 0.0;
        foreach (int x in xs) {
            sum += x;
        }
        sum /= xs.Length;
        return (int)Math.Round(sum);

    }

    // BEGIN CUT HERE
    public static void Main(String[] args) {
        eq(0, (new MissileTarget()).bestFit(new int[] { 750, -500, -250 }, new int[] { -1000, 500, 500 }), new int[] { 0, 0 });
        eq(1, (new MissileTarget()).bestFit(new int[] { 765 }, new int[] { 834 }), new int[] { 765, 834 });
        eq(2, (new MissileTarget()).bestFit(new int[] { 100, 200 }, new int[] { 200, 400 }), new int[] { 150, 300 });
        eq(3, (new MissileTarget()).bestFit(new int[] { 123456, -987654, 97531, -86420 }, new int[] { 14703, 25814, 36924, -47036 }), new int[] { -213272, 7601 });
        eq(4, (new MissileTarget()).bestFit(new int[] { 0, 5, 5, 6, 8, 8 }, new int[] { 0, 0, 0, 0, 0, 0 }), new int[] { 5, 0 });
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
