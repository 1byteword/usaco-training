// BEGIN CUT HERE

// END CUT HERE
using System;
using System.Text;
using System.Text.RegularExpressions;
using System.Collections;
using System.Collections.Generic;

public class BuildingAdvertise
{

    class Board
    {
        public int Start { get; set; }
        public int Height { get; set; }
    }

    public long getMaxArea(int[] h, int n)
    {
        int[] R = getR(h, n);

        Stack<Board> growingBoards = new Stack<Board>();
        growingBoards.Push(new Board { Start = 0, Height = R[0] });

        long res = 0;
        for (int i = 1; i < n; i++)
        {
            int start = i;
            while (growingBoards.Count > 0 && growingBoards.Peek().Height > R[i])
            {
                Board b = growingBoards.Pop();
                res = Math.Max(res, (i - b.Start) * (long)b.Height);
                start = b.Start;
            }
            growingBoards.Push(new Board { Start = start, Height = R[i] });
        }

        while (growingBoards.Count > 0)
        {
            Board b = growingBoards.Pop();
            res = Math.Max(res, (n - b.Start) * (long)b.Height);
        }

        return res;
    }

    private int[] getR(int[] h, int n)
    {
        int[] R = new int[n];
        int j = 0;
        int m = h.Length;

        for (int i = 0; i < n; i++)
        {
            R[i] = h[j];
            int s = (j + 1) % m;
            h[j] = ((h[j] ^ h[s]) + 13) % 835454957;
            j = s;

        }
        return R;
    }

    // BEGIN CUT HERE
    public static void Main(String[] args)
    {
        eq(0, (new BuildingAdvertise()).getMaxArea(new int[] { 3, 6, 5, 6, 2, 4 }, 6), 15L);
        eq(1, (new BuildingAdvertise()).getMaxArea(new int[] { 5, 0, 7, 0, 2, 6, 2 }, 7), 7L);
        eq(2, (new BuildingAdvertise()).getMaxArea(new int[] { 1048589, 2097165 }, 100000), 104858900000L);
        eq(3, (new BuildingAdvertise()).getMaxArea(new int[] { 1, 7, 2, 5, 3, 1 }, 6), 8L);
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
