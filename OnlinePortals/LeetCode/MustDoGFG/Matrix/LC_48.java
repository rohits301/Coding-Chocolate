class Solution {
    // T: O(n*n), S: O(1)
    // READ LEETCODE SOLN - V.V.IMP
    
    // in GFG version, 2. changes to swap row for every col
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // 1. transpose

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // swap i,j with j,i for half matrix only

                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // 2. swap cols for every row
        for (int i = 0; i < n; i++) {

            int left = 0;
            int right = n - 1;

            // left < right works, since swapping at equality won't make any differ.
            while (left < right) {

                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;

                left++;
                right--;
            }
        }

    }
}