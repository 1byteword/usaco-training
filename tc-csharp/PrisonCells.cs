// BEGIN CUT HERE

// END CUT HERE
using System;
using System.Text;
using System.Text.RegularExpressions;
using System.Collections;
using System.Collections.Generic;


public class PrisonCells {

    private int res = 0;
    private int[] xs;
    private int[] ys;
    private int m, n, nr;
    private bool[,] taken;

    public int scatter(int m, int n, int nr) {
        xs = new int[nr];
        ys = new int[nr];
        this.m = m;
        this.n = n;
        this.nr = nr;
        taken = new bool[m, n];

        xs[0] = ys[0] = 0;
        taken[0, 0] = true;
        fill(1);

        return res;
    }

    private void fill(int p) {
        if (p == nr) {
            res = Math.Max(res, calDist(p));
            return;
        }
        for (int nx = 0; nx < m; nx++) {
            for (int ny = 0; ny < n; ny++) {
                if (taken[nx, ny])
                    continue;
                taken[nx, ny] = true;
                xs[p] = nx;
                ys[p] = ny;
                if (p > 1) {
                    int d = calDist(p);
                    if (d <= res) {
                        taken[nx, ny] = false;
                        return;
                    }
                }
                fill(p + 1);
                taken[nx, ny] = false;
            }
        }
    }

    private int calDist(int p) {
        int res = dist(0, 1);
        for (int i = 0; i < p; i++) {
            for (int j = i + 1; j < p; j++) {
                res = Math.Min(res, dist(i, j));
            }
        }
        return res;
    }

    private int dist(int p1, int p2) {
        return Math.Abs(xs[p1] - xs[p2]) + Math.Abs(ys[p1] - ys[p2]);
    }

    // BEGIN CUT HERE
    public static void Main(String[] args) {
        //eq(0, (new PrisonCells()).scatter(3, 4, 2), 5);
        //eq(1, (new PrisonCells()).scatter(4, 4, 3), 4);
        //eq(2, (new PrisonCells()).scatter(4, 4, 4), 3);
        eq(3, (new PrisonCells()).scatter(4, 4, 16), 1);
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
