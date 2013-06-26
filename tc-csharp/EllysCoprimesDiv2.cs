// BEGIN CUT HERE

// END CUT HERE
using System;
using System.Text;
using System.Text.RegularExpressions;
using System.Collections;

public class EllysCoprimesDiv2
{
    private int gcd(int a, int b)
    {
        if (a < b) return gcd(b, a);
        if (a % b == 0) return b;
        return gcd(b, a % b);
    }

    private int insert(int a, int b)
    {
        if (a > b) return insert(b, a);
        if (gcd(a, b) == 1) return 0;
        for (int c = a + 1; c < b; c++)
        {
            if (gcd(a, c) == 1 && gcd(c, b) == 1) return 1;
        }
        // No formal proof but works for n <= 100,000
        return 2;
    }

    public int getCount(int[] numbers)
    {
        Array.Sort(numbers);

        int res = 0;

        for (int i = 0; i < numbers.Length - 1; i++)
        {
            res += insert(numbers[i], numbers[i + 1]);
        }

        return res;
    }

    // BEGIN CUT HERE
    public static void Main(String[] args)
    {
        eq(0, (new EllysCoprimesDiv2()).getCount(new int[] { 2200, 42, 2184, 17 }), 3);
        eq(1, (new EllysCoprimesDiv2()).getCount(new int[] { 13, 1, 6, 20, 33 }), 0);
        eq(2, (new EllysCoprimesDiv2()).getCount(new int[] { 7, 42 }), 1);
        eq(3, (new EllysCoprimesDiv2()).getCount(new int[] {55780, 44918, 55653, 4762, 41536, 40083, 79260, 7374, 24124, 91858, 7856,
                12999, 64025, 12706, 19770, 71495, 32817, 79309, 53779, 8421, 97984, 34586,
                893, 64549, 77792, 12143, 52732, 94416, 54207, 51811, 80845, 67079, 14829,
                25350, 22976, 23932, 62273, 58871, 82358, 13283, 33667, 64263, 1337, 42666}), 15);
    }
    private static void eq(int n, object have, object need)
    {
        if (eq(have, need))
        {
            Console.WriteLine("Case " + n + " passed.");
        }
        else
        {
            Console.Write("Case " + n + " failed: expected ");
            print(need);
            Console.Write(", received ");
            print(have);
            Console.WriteLine();
        }
    }
    private static void eq(int n, Array have, Array need)
    {
        if (have == null || have.Length != need.Length)
        {
            Console.WriteLine("Case " + n + " failed: returned " + have.Length + " elements; expected " + need.Length + " elements.");
            print(have);
            print(need);
            return;
        }
        for (int i = 0; i < have.Length; i++)
        {
            if (!eq(have.GetValue(i), need.GetValue(i)))
            {
                Console.WriteLine("Case " + n + " failed. Expected and returned array differ in position " + i);
                print(have);
                print(need);
                return;
            }
        }
        Console.WriteLine("Case " + n + " passed.");
    }
    private static bool eq(object a, object b)
    {
        if (a is double && b is double)
        {
            return Math.Abs((double)a - (double)b) < 1E-9;
        }
        else
        {
            return a != null && b != null && a.Equals(b);
        }
    }
    private static void print(object a)
    {
        if (a is string)
        {
            Console.Write("\"{0}\"", a);
        }
        else if (a is long)
        {
            Console.Write("{0}L", a);
        }
        else
        {
            Console.Write(a);
        }
    }
    private static void print(Array a)
    {
        if (a == null)
        {
            Console.WriteLine("<NULL>");
        }
        Console.Write('{');
        for (int i = 0; i < a.Length; i++)
        {
            print(a.GetValue(i));
            if (i != a.Length - 1)
            {
                Console.Write(", ");
            }
        }
        Console.WriteLine('}');
    }
    // END CUT HERE
}
