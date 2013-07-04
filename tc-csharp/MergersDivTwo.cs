// BEGIN CUT HERE

// END CUT HERE
using System;
using System.Text;
using System.Text.RegularExpressions;
using System.Collections;
using System.Collections.Generic;

public class MergersDivTwo
{

    public double findMaximum(int[] revenues, int k)
    {
        Array.Sort(revenues);
        int l = revenues.Length;

        double[] maxAt = new double[l];
        for (int i = k - 1; i < l; i++)
        {
            maxAt[i] = merge(revenues, 0, i);
        }

        for (int i = 2 * k - 2; i < l; i++)
        {
            for (int j = k - 1; j < i - k + 2; j++)
            {
                maxAt[i] = Math.Max(maxAt[i], merge(revenues, j + 1, i, maxAt[j]));
            }
        }

        return maxAt[l - 1];
    }

    private double merge(int[] revenues, int start, int end)
    {
        double sum = 0;
        double count = 0;
        for (int i = start; i <= end; i++)
        {
            sum += revenues[i];
            count++;
        }
        return sum / count;
    }

    private double merge(int[] revenues, int start, int end, double prev)
    {
        double sum = prev;
        double count = 1;
        for (int i = start; i <= end; i++)
        {
            sum += revenues[i];
            count++;
        }
        return sum / count;
    }

    // BEGIN CUT HERE
    public static void Main(String[] args)
    {
        eq(0, (new MergersDivTwo()).findMaximum(new int[] { 5, -7, 3 }, 2), 1.5);
        eq(1, (new MergersDivTwo()).findMaximum(new int[] { 5, -7, 3 }, 3), 0.3333333333333333);
        eq(2, (new MergersDivTwo()).findMaximum(new int[] { 1, 2, 2, 3, -10, 7 }, 3), 2.9166666666666665);
        eq(3, (new MergersDivTwo()).findMaximum(new int[] { -100, -100, -100, -100, -100, 100 }, 4), -66.66666666666667);
        eq(4, (new MergersDivTwo()).findMaximum(new int[] {869, 857, -938, -290, 79, -901, 32, -907, 256, -167, 510, -965, -826, 808, 890,
                -233, -881, 255, -709, 506, 334, -184, 726, -406, 204, -912, 325, -445, 440, -368}, 7), 706.0369290573373);
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
