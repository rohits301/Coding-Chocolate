class Solution {

    long numberOfPaths(int m, int n) {
        // Code Here

        // m-rows, n-cols
        long ans = solve(0, 0, m - 1, n - 1, m, n);
        return ans;
    }

    long solve(int sr, int sc, int dr, int dc, int m, int n) {
        if (sr == dr && sc == dc) {
            return 1;
        }

        long p1 = 0; // paths for down call
        long p2 = 0; // paths for right call

        if (sr + 1 < m)
            p1 = solve(sr + 1, sc, dr, dc, m, n);

        if (sc + 1 < n)
            p2 = solve(sr, sc + 1, dr, dc, m, n);

        return p1 + p2;
    }

}