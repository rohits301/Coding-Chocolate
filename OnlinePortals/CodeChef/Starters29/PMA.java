// MAXIMUM ALTERNATING SUM
// 1. haven taken long to pass test cases
// 1e9L is not written like this, hence, written full
// 2. alternating sum is basically, sperate even and odd
// then to maximise after swapping, observe the changes
// those are the a and b
// 3. Finally, it is possible, b-a is -ve, therefore, take max of initial, final

/* package codechef; // don't place package name! */

import java.util.*;
import java.io.*;

public class Main {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine().trim();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    static class FastWriter {
        private final BufferedWriter bw;

        public FastWriter() {
            this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        public void print(Object object) throws IOException {
            bw.append("" + object);
        }

        public void println(Object object) throws IOException {
            print(object);
            bw.append("\n");
        }

        public void close() throws IOException {
            bw.close();
        }
    }

    public static void main(String[] args) {
        try {
            FastReader in = new FastReader();
            FastWriter out = new FastWriter();
            int testCases = in.nextInt();
            while (testCases-- > 0) {
                // write code here
                int n = in.nextInt();
                long[] arr = new long[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = in.nextLong();
                }

                long ans = solve(arr, n);
                out.println(ans);
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }

    public static long solve(long[] arr, int n) {

        ArrayList<Long> even = new ArrayList<>();
        ArrayList<Long> odd = new ArrayList<>();
        long sumEven = 0, sumOdd = 0;

        for (int i = 1; i <= n; i++) {
            long val = Math.abs(arr[i-1]);
            
            if (i % 2 == 0) {
                even.add(val);
                sumEven += val;
            } else {
                odd.add(val);
                sumOdd += val;
            }
        }

        long sumInitial = sumOdd - sumEven;

        long a = 1000000000L, b = 0L;

        for (long val : odd) {
            a = Math.min(a, val);
        }

        for (long val : even) {
            b = Math.max(b, val);
        }
        
        long sumFinal = sumInitial + 2 * (b - a);

        return Math.max(sumFinal, sumInitial);
    }
}
