class Solution {
    // T: O(log(n+m)), S: O(1)
    // expln by striver
    // diff. from GFG, GFG one is LC.240
    public boolean searchMatrix(int[][] matrix, int target) {
        // here we can use binary search on 1d array of size n*m
        // so instead of explicitly making it
        // we are handling it thru indices

        int n = matrix.length;
        int m = matrix[0].length;

        int lo = 0, hi = n * m - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            int row = mid / m, col = mid % m;

            if (target == matrix[row][col]) {
                return true;
            }

            if (target > matrix[row][col]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return false;
    }
}