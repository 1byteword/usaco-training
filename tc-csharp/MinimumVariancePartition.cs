// BEGIN CUT HERE

// END CUT HERE
using System;
using System.Text;
using System.Text.RegularExpressions;
using System.Collections;
using System.Collections.Generic;


public class MinimumVariancePartition {
    private double[,] cache;
    private int[] samples;

    public double minDev(int[] mixedSamples, int k) {
        int l = mixedSamples.Length;
        cache = new double[l, l];
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                cache[i, j] = -1;
            }
        }
        samples = mixedSamples;
        Array.Sort(samples);

        double[,] dp = new double[l, k + 1];
        for (int end = 0; end < l; end++) {
            dp[end, 1] = Var(0, end);
            for (int partitions = 2; partitions <= k; partitions++) {
                dp[end, partitions] = double.MaxValue;
                for (int prev = end - 1; prev >= 0; prev--) {
                    dp[end, partitions] = Math.Min(dp[end, partitions], dp[prev, partitions - 1] + Var(prev + 1, end));
                }
            }
        }

        return dp[l - 1, k];
    }

    private double Var(int start, int end) {
        if (cache[start, end] > 0)
            return cache[start, end];
        double sum = 0;
        double sum2 = 0;
        for (int i = start; i <= end; i++) {
            sum += samples[i];
            sum2 += (samples[i] * samples[i]);
        }
        int n = end - start + 1;
        double res = sum2 / n - (sum / n) * (sum / n);
        cache[start, end] = res;
        return res;
    }

    // BEGIN CUT HERE
    public static void Main(String[] args) {
        eq(0, (new MinimumVariancePartition()).minDev(new int[] { 3, 4, 7, 10 }, 1), 7.5);
        eq(1, (new MinimumVariancePartition()).minDev(new int[] { 1000, 500, 1, 500 }, 3), 0.0);
        eq(2, (new MinimumVariancePartition()).minDev(new int[] { 54, 653, 876, 2, 75 }, 5), 0.0);
        eq(3, (new MinimumVariancePartition()).minDev(new int[] { 42, 234, 10, 1, 123, 545, 436, 453, 74, 85, 34, 999 }, 5), 1700.7397959183672);
        eq(4, (new MinimumVariancePartition()).minDev(new int[] { 923, 456, 12, 12, 542, 234, 11, 12, 10, 9 }, 4), 1850.3333333333333);
        eq(5, (new MinimumVariancePartition()).minDev(new int[] { 197, 611, 410, 779, 203, 15, 727, 446, 992, 722, 439, 296, 201, 820, 416, 272, 89, 146, 687, 203, 598, 65, 865, 945, 446, 783, 581, 270, 960, 22, 970, 698, 456, 706, 14, 901, 371, 688, 914, 925, 551, 15, 326, 620, 842, 82, 594, 99, 827, 660 }, 21), 757.3225);
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
