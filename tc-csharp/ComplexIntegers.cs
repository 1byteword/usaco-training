// BEGIN CUT HERE

// END CUT HERE
using System;
using System.Text;
using System.Text.RegularExpressions;
using System.Collections;
using System.Collections.Generic;


public class ComplexIntegers {
    public string[] classify(int[] realPart, int[] imaginaryPart) {
        List<string> res = new List<string>();
        for (int i = 0; i < realPart.Length; i++) {
            res.Add(cat(realPart[i], imaginaryPart[i]));
        }
        return res.ToArray();
    }

    private string cat(int real, int img) {
        if (real == 0)
            return catForOneZero(img);
        if (img == 0)
            return catForOneZero(real);
        if (isPrime(norm(real, img)))
            return "prime";
        return "composite";

    }

    private bool isPrime(int x) {
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0)
                return false;
        }
        return true;
    }

    private int norm(int real, int img) {
        return real * real + img * img;
    }

    private string catForOneZero(int img) {
        if (img == 0)
            return "zero";
        if (img == 1 || img == -1)
            return "unit";
        if (isP(Math.Abs(img))) {
            return "prime";
        } else {
            return "composite";
        }
    }

    private bool isP(int p) {
        if (!isPrime(p))
            return false;
        return p % 4 == 3;
    }

    // BEGIN CUT HERE
    public static void Main(String[] args) {
        eq(0, (new ComplexIntegers()).classify(new int[] { 0, 1, 0, 1, -1, 2, 0, 0, -3 }, new int[] { 0, 0, -1, 1, 1, 0, -3, 5, -2 }), new string[] { "zero", "unit", "unit", "prime", "prime", "composite", "prime", "composite", "prime" });
        eq(1, (new ComplexIntegers()).classify(new int[] { 2, 3, 4, 5, 2, 3, 4, 5, 2, 3, 4, 5, 2, 3, 4, 5 }, new int[] { 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5 }), new string[] { "composite", "prime", "composite", "prime", "prime", "composite", "composite", "composite", "composite", "composite", "composite", "prime", "prime", "composite", "prime", "composite" });
        eq(2, (new ComplexIntegers()).classify(new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, -19, 23, 29, 31, 37, -41 }, new int[] { 15, 2, -3, 5, -7, 11, -13, 17, 0, 0, 0, 0, 0, 0, 0 }), new string[] { "composite", "composite", "prime", "composite", "prime", "prime", "composite", "composite", "zero", "prime", "prime", "composite", "prime", "composite", "composite" });
        eq(3, (new ComplexIntegers()).classify(new int[] { 99, -39, 0, 0, 97, 1003, 9998, 1119 }, new int[] { 0, 0, 35, -129, -2, -232, 9997, 1120 }), new string[] { "composite", "composite", "composite", "composite", "prime", "prime", "prime", "prime" });
        eq(4, (new ComplexIntegers()).classify(new int[] {0,  0,0,1,-1,   1,1,-1,-1,   2,-2,0,0,  1,1,2,2,-1,-1,-2,-2, 
                    3,-3,0,0,   1,1,3,3,-1,-1,-3,-3,    2,2,-2,-2,  0,0,4,-4,
                                1,1,4,4,-1,-1,-4,-4 }, new int[] {0,  1,-1,0,0,   1,-1,1,-1,   0,0,2,-2,  2,-2,1,-1,2,-2,1,-1,  
                    0,0,-3,3,   3,-3,1,-1,3,-3,1,-1,     2,-2,2,-2,  4,-4,0,0,
                                4,-4,1,-1,4,-4,1,-1 }), new string[] { "zero", "unit", "unit", "unit", "unit", "prime", "prime", "prime", "prime", "composite", "composite", "composite", "composite", "prime", "prime", "prime", "prime", "prime", "prime", "prime", "prime", "prime", "prime", "prime", "prime", "composite", "composite", "composite", "composite", "composite", "composite", "composite", "composite", "composite", "composite", "composite", "composite", "composite", "composite", "composite", "composite", "prime", "prime", "prime", "prime", "prime", "prime", "prime", "prime" });
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
