// BEGIN CUT HERE

// END CUT HERE
using System;
using System.Text;
using System.Text.RegularExpressions;
using System.Collections;
using System.Collections.Generic;


public class WordParts {
    int l;
    string compound, original;
    public int partCount(string original, string compound) {
        this.original = original;
        this.compound = compound;
        l = compound.Length;
        if (l == 0)
            return 0;
        int[] dp = new int[l];
        for (int i = 0; i < l; i++) {
            dp[i] = isPreSuffix(0, i) ? 1 : int.MaxValue;
            if (dp[i] == int.MaxValue) {
                for (int j = i - 1; j >= 0; j--) {
                    if (isPreSuffix(j + 1, i) && dp[j] < int.MaxValue) {
                        dp[i] = Math.Min(dp[i], dp[j] + 1);
                    }
                }
            }
        }
        return dp[l - 1] == int.MaxValue ? -1 : dp[l - 1];
    }

    private bool isPreSuffix(int start, int end) {
        string s = compound.Substring(start, end - start + 1);
        return original.StartsWith(s) || original.EndsWith(s);
    }

    // BEGIN CUT HERE
    public static void Main(String[] args) {
        eq(0, (new WordParts()).partCount("ANTIDISESTABLISHMENTARIANISM", "ANTIDISIANISMISM"), 3);
        eq(1, (new WordParts()).partCount("ANTIDISESTABLISHMENTARIANISM", "ESTABLISHMENT"), -1);
        eq(2, (new WordParts()).partCount("TOPCODERDOTCOM", "TOMTMODERDOTCOM"), 5);
        eq(3, (new WordParts()).partCount("HELLO", "HELLOHEHELLOLOHELLO"), 5);
        eq(4, (new WordParts()).partCount("DONTFORGETTHEEMPTYCASE", ""), 0);
        eq(5, (new WordParts()).partCount("BAAABA", "BAAABAAA"), 2);
        eq(6, (new WordParts()).partCount("ABBBAABABBBAABBABBABABBABAABBAABBBBBABBABABBABAABB", "BBBAABABBBAABBABBABABBABAABBAABBBBBABBABABBABAABAA"), 17);
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
