
// m is the given matrix and n is the order of matrix
class Solution {
    // T: O(3^(N^2)), S: O(L*X), L=length of path, X=no. of paths
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        // 0-blocked, 1-go
        ArrayList<String> ans = new ArrayList<>();
        boolean[][] vis = new boolean[n][n];

        pathHelper(m, 0, 0, n - 1, n - 1, ans, "", vis);

        return ans;
    }

    static void pathHelper(int[][] m, int sr, int sc, int dr, int dc, ArrayList<String> ans,
            String asf, boolean[][] vis) {

        // reactive style code
        if (sr < 0 || sc < 0 || sr >= m.length || sc >= m[0].length ||
            m[sr][sc] == 0 || vis[sr][sc] == true) {

            return;
        }

        if (sr == dr && sc == dc) {
            ans.add(asf);
            return;
        }

        vis[sr][sc] = true;
        pathHelper(m, sr - 1, sc, dr, dc, ans, asf + "U", vis);
        pathHelper(m, sr, sc + 1, dr, dc, ans, asf + "R", vis);
        pathHelper(m, sr + 1, sc, dr, dc, ans, asf + "D", vis);
        pathHelper(m, sr, sc - 1, dr, dc, ans, asf + "L", vis);
        vis[sr][sc] = false;
    }
}