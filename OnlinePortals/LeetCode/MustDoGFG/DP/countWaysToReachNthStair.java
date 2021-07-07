class Solution
{
    //Function to count number of ways to reach the nth stair.
    int countWays(int n)
    {
        // your code here
        
        int m = 1000000007;

        int[] ways = new int[2];
        ways[0] = 1; // 0 to 0 => 1 way
        ways[1] = 1; // 0 to 1 => 1 way (step = 1)
        
        for (int i = 2; i <= n; i++) {
            ways[i % 2] = ((ways[(i - 1) % 2] % m) + 
                           (ways[(i - 2) % 2] % m)) % m;
        }

        return ways[n % 2];
    }
}