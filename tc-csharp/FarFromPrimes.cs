// BEGIN CUT HERE

// END CUT HERE
using System;
using System.Text;
using System.Text.RegularExpressions;
using System.Collections;

public class FarFromPrimes {
    const int M = 100000 + 10;
    bool[] composite = new bool[M + 1];


    public int count(int A, int B) {
        for (int i = 2; i <= M; i++) {
            for (int j = 2; i * j <= M; j++) {
                composite[i * j] = true;
            }
        }

        int res = 0;
        for (int i = A; i <= B; i++) {
            if (far(i))
                res++;
        }
        return res;
    }

    private bool far(int n) {
        for (int i = -10; i <= 10; i++) {
            if (n + i < 2)
                continue;
            if (!composite[n + i])
                return false;
        }
        return true;
    }

    // BEGIN CUT HERE
    public static void Main(String[] args) {
        eq(0, (new FarFromPrimes()).count(3328, 4100), 4);
        eq(1, (new FarFromPrimes()).count(10, 1000), 0);
        eq(2, (new FarFromPrimes()).count(19240, 19710), 53);
        eq(3, (new FarFromPrimes()).count(23659, 24065), 20);
        eq(4, (new FarFromPrimes()).count(97001, 97691), 89);
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
