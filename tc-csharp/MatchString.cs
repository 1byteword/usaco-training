// BEGIN CUT HERE

// END CUT HERE
using System;
using System.Text;
using System.Text.RegularExpressions;
using System.Collections;
using System.Collections.Generic;


public class MatchString {
    public int placeWords(string matchString, string[] matchWords) {
        int l = matchWords.Length;
        List<int>[] positions = new List<int>[l];
        List<int> allPositions = new List<int>();
        for (int i = 0; i < l; i++) {
            positions[i] = findPositions(matchWords[i], matchString[i]);
            if (positions[i].Count == 0)
                return -1;
            allPositions.AddRange(positions[i]);
        }

        allPositions.Sort();
        int res = int.MaxValue;

        foreach (int max in allPositions) {
            int shifts = 0;
            bool inAllLines = true;
            for (int i = 0; i < l; i++) {
                int pos = -1;
                bool inThisLine = false;
                for (int j = 0; j < positions[i].Count; j++) {
                    if (positions[i][j] > max) {
                        break;
                    }
                    pos = positions[i][j];
                    inThisLine = true;
                }
                if (!inThisLine) {
                    inAllLines = false;
                    break;
                }
                shifts += (max - pos);
            }
            if (!inAllLines) {
                continue;
            } else {
                res = Math.Min(res, shifts);
            }
        }

        return res;
    }

    private List<int> findPositions(string s, char c) {
        List<int> res = new List<int>();
        int pos = s.IndexOf(c);
        while (pos != -1) {
            res.Add(pos);
            pos = s.IndexOf(c, pos + 1);
        }
        return res;
    }

    // BEGIN CUT HERE
    public static void Main(String[] args) {
        eq(0, (new MatchString()).placeWords("TOP", new string[] {"TIK", 
                "PPPO", 
                "OP"}), 5);
        eq(1, (new MatchString()).placeWords("EEA", new string[] {"GEGA", 
                "TOPCODER", 
                "TEST"}), -1);
        eq(2, (new MatchString()).placeWords("AB", new string[] {"ABA", 
                "ABAB"}), 1);
        eq(3, (new MatchString()).placeWords("FIND", new string[] {"VERYFAST", 
                "OPINION", 
                "SPENDING", 
                "ODD"}), 3);
        eq(4, (new MatchString()).placeWords("TOP", new string[] {"OUTTHERE", 
                "FROM", 
                "NOPQRSTU"}), 0);
        eq(5, (new MatchString()).placeWords("PP", new string[] {"PAAAP", 
                "AAPP", 
                }), 1);

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
