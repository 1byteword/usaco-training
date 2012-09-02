// BEGIN CUT HERE

// END CUT HERE
using System;
using System.Text;
using System.Text.RegularExpressions;
using System.Collections;
using System.Collections.Generic;


public class MatrixTransforming {

    class Matrix : IEquatable<Matrix> {
        int height;
        int width;
        BitArray array;

        public int Height {
            get {
                return height;
            }
        }
        public int Width {
            get {
                return width;
            }
        }

        public Matrix(string[] s) {
            width = s[0].Length;
            height = s.Length;
            array = new BitArray(width * height);
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    setBit(i, j, s[i][j] == '1');
                }
            }
        }

        private void setBit(int i, int j, bool b) {
            array[i * width + j] = b;
        }

        public bool getBit(int i, int j) {
            return array[i * width + j];
        }

        private static bool bitEquals(BitArray a, BitArray b) {
            if (a.Length != b.Length)
                return false;
            for (int i = 0; i < a.Length; i++) {
                if (a[i] != b[i]) {
                    return false;
                }
            }
            return true;
        }

        public bool Equals(Matrix other) {
            return bitEquals(array, other.array);
        }

        internal void flipBits(int r, int c) {
            for (int i = r; i < r + 3; i++) {
                for (int j = c; j < c + 3; j++) {
                    setBit(i, j, !getBit(i, j));
                }
            }
        }
    }

    public int minPushes(string[] a, string[] b) {
        Matrix start = new Matrix(a);
        Matrix goal = new Matrix(b);

        int res = 0;
        for (int i = 0; i <= start.Height - 3; i++) {
            for (int j = 0; j <= start.Width - 3; j++) {
                if (start.getBit(i, j) != goal.getBit(i, j)) {
                    res++;
                    start.flipBits(i, j);
                }
            }
        }

        if (start.Equals(goal)) {
            return res;
        } else {
            return -1;
        }
    }


    // BEGIN CUT HERE
    public static void Main(String[] args) {
        eq(0, (new MatrixTransforming()).minPushes(new string[] { "111", "111", "111" }, new string[] { "000", "000", "000" }), 1);
        eq(1, (new MatrixTransforming()).minPushes(new string[] { "1" }, new string[] { "0" }), -1);
        eq(2, (new MatrixTransforming()).minPushes(new string[] {"001","100","100","000","011","010","100","100","010",
               "010","010","110","101","101","000","110","000","110"}, new string[] {"001","100","011","000","100","010","011","100","101",
               "101","010","001","010","010","111","110","111","001"}), 7);
        eq(3, (new MatrixTransforming()).minPushes(new string[] {
               "0000",
               "0010",
               "0000"
               }, new string[] {
               "1001",
               "1011",
               "1001"
               }), 2);
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
