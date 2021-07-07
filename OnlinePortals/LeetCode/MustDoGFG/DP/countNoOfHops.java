class Solution {
    // Function to count the number of ways in which frog can reach the top.
    static long countWays(int n) {
        // cannot handle overflow in top-down dp
        // since 0 % m = 0
        // therefore will always go out of bounds

        int m = 1000000007;

        long[] ways = new long[3];
        ways[0] = 1; // 0 to 0 => 1 way
        ways[1] = 1; // 0 to 1 => 1 way (step = 1)
        ways[2] = 2; // 0 to 2 => 2 ways
        // (step = 2 (0 to 2) and step = 1 (1 to 2))

        for (int i = 3; i <= n; i++) {
            ways[i % 3] = ((ways[(i - 1) % 3] % m) + 
                           (ways[(i - 2) % 3] % m) + 
                           (ways[(i - 3) % 3] % m)) % m;
        }

        return ways[n % 3];
    }
}
