class Solution {
    // Similar to GFG Ques
    // expln by Striver
    // T: O(n+m), S: O(1)
    public boolean searchMatrix(int[][] matrix, int target) {

        // cannot represent the whole matrix as a 1d array unlike LC.74, hence no
        // BinarySearch

        int n = matrix.length, m = matrix[0].length;

        int i = 0, j = m - 1;
        while (i < n && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            }

            if (target > matrix[i][j]) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}