// BEGIN CUT HERE

// END CUT HERE
using System;
using System.Text;
using System.Text.RegularExpressions;
using System.Collections;
using System.Collections.Generic;


public class IntegerSequence {
    public int maxSubsequence(int[] numbers) {
        int l = numbers.Length;
        int[] maxAsc = new int[l];
        int[] maxDesc = new int[l];
        for (int i = 0; i < l; i++) {
            maxAsc[i] = maxDesc[i] = 1;
        }

        for (int i = 1; i < l; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (numbers[i] > numbers[j]) {
                    maxAsc[i] = Math.Max(maxAsc[j] + 1, maxAsc[i]);
                }
            }
        }

        for (int i = l - 2; i >= 0; i--) {
            for (int j = i + 1; j < l; j++) {
                if (numbers[i] > numbers[j]) {
                    maxDesc[i] = Math.Max(maxDesc[j] + 1, maxDesc[i]);
                }
            }
        }

        int res = l + 1 - (maxAsc[0] + maxDesc[0]);
        for (int i = 1; i < l; i++) {
            res = Math.Min(res, l + 1 - maxAsc[i] - maxDesc[i]);
        }

        return res;
    }

    // BEGIN CUT HERE
    public static void Main(String[] args) {
        eq(0, (new IntegerSequence()).maxSubsequence(new int[] { 1, 4, 6, 5, 2, 1 }), 0);
        eq(1, (new IntegerSequence()).maxSubsequence(new int[] { 1, 2, 1, 2, 3, 2, 1, 2, 1 }), 4);
        eq(2, (new IntegerSequence()).maxSubsequence(new int[] { 2, 2, 2, 2, 2 }), 4);
        eq(3, (new IntegerSequence()).maxSubsequence(new int[] { 4, 5, 65, 34, 786, 45678, 987, 543, 2, 6, 98, 580, 4326, 754, 54, 2, 1, 3, 5, 6, 8, 765, 43, 3, 54 }), 14);
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
