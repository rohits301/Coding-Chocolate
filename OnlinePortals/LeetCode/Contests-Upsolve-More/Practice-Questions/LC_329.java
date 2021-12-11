class Solution {
    // T: O(n*m), S: O(n*m)
    public int longestIncreasingPath(int[][] matrix) {

        int n = matrix.length, m = matrix[0].length;
        int[][] qb = new int[n][m]; // question bank

        int omax = 0;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {

                int lip = lipHelper(matrix, i, j, qb);
                if (lip > omax) {
                    omax = lip;
                }
            }
        }

        return omax;
    }

    int lipHelper(int[][] matrix, int i, int j, int[][] qb) {
        if (qb[i][j] != 0)
            return qb[i][j]; // memoization

        int[] xdir = { 0, -1, 0, 1 };
        int[] ydir = { -1, 0, 1, 0 };

        int max = 0;
        for (int d = 0; d < 4; ++d) {
            int x = i + xdir[d];
            int y = j + ydir[d];

            if (x >= 0 && y >= 0 &&
                x < matrix.length && y < matrix[0].length &&
                matrix[x][y] > matrix[i][j]) {

                int path = lipHelper(matrix, x, y, qb);
                if (path > max)
                    max = path; // max of all directions
            }
        }
        qb[i][j] = max + 1; // every cell is path of 1 unit.

        return qb[i][j];
    }
}