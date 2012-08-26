// BEGIN CUT HERE

// END CUT HERE
using System;
using System.Text;
using System.Text.RegularExpressions;
using System.Collections;
using System.Collections.Generic;


public class BitStrings {
    public int maxStrings(String[] strings, int zeros, int ones) {
        return maxStrings(0, strings, zeros, ones);
    }

    private int maxStrings(int start, string[] strings, int zeros, int ones) {
        if (start == strings.Length)
            return 0;
        int z = countZeros(strings[start]);
        int o = strings[start].Length - z;

        int with = 1 + maxStrings(start + 1, strings, zeros - z, ones - o);
        if (zeros < z || ones < o)
            with = 0;
        int without = maxStrings(start + 1, strings, zeros, ones);
        return Math.Max(with, without);
    }

    private int countZeros(string p) {
        int count = 0;
        foreach (char c in p)
            count += (c == '0' ? 1 : 0);
        return count;
    }


    // BEGIN CUT HERE
    public static void Main(String[] args) {
        //eq(0, (new BitStrings()).maxStrings(new string[] { "1", "00", "100" }, 3, 1), 2);
        //eq(1, (new BitStrings()).maxStrings(new string[] { "00", "110", "101" }, 2, 4), 2);
        eq(2, (new BitStrings()).maxStrings(new string[] { "111", "01", "11", "10", "101" }, 3, 9), 5);
        eq(3, (new BitStrings()).maxStrings(new string[] {"10101010101010101010101010101010101010101010101010",
               "10101010101010101010101010101010101010101010101010",
               "10101010101010101010101010101010101010101010101010",
               "10101010101010101010101010101010101010101010101010",
               "10101010101010101010101010101010101010101010101010",
               "10101010101010101010101010101010101010101010101010",
               "10101010101010101010101010101010101010101010101010",
               "10101010101010101010101010101010101010101010101010",
               "10101010101010101010101010101010101010101010101010",
               "10101010101010101010101010101010101010101010101010",
               "10101010101010101010101010101010101010101010101010",
               "10101010101010101010101010101010101010101010101010",
               "10101010101010101010101010101010101010101010101010",
               "10101010101010101010101010101010101010101010101010",
               "10101010101010101010101010101010101010101010101010",
               "10101010101010101010101010101010101010101010101010",
               "10101010101010101010101010101010101010101010101010",
               "10101010101010101010101010101010101010101010101010",
               "10101010101010101010101010101010101010101010101010",
               "10101010101010101010101010101010101010101010101010"}, 500, 500), 20);
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
