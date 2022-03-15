class Solution {
    // T: O(logn), S: O(n) 
    // expln by PEP, striver
    public boolean searchMatrix(int[][] matrix, int target) {
        // row and coln of matrix are sorted in inc. order
        int lo = 0;
        if(matrix.length == 0) return false;
        
        int n = matrix.length; 
        int m = matrix[0].length; 
        
        int hi = (n * m) - 1;
        
        while(lo <= hi) {
            int mid = (lo + (hi - lo) / 2);
            if(matrix[mid/m][mid % m] == target) {
                return true;
            }
            if(matrix[mid/m][mid % m] < target) {
                lo = mid + 1;
            }
            else {
                hi = mid - 1;
            }
        }
        return false;
    }
}