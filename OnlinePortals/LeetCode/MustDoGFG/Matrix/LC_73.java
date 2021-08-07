class Solution {
    
    // T: O(m * n), S: O(1)
    public void setZeroes(int[][] arr) {
        
        boolean zerothCol = false; // for arr[0][0]
        int m = arr.length;
        int n = arr[0].length;
        
        for(int i = 0; i < m; i++){
            
            if(arr[i][0] == 0) zerothCol = true;
            
            for(int j = 1; j < n; j++){
                if(arr[i][j] == 0){
                    arr[i][0] = 0;
                    arr[0][j] = 0;
                }
            }
        }
        
        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 1; j--){
                if(arr[i][0] == 0 || arr[0][j] == 0){
                    arr[i][j] = 0;
                }
            }
            
            if(zerothCol == true) arr[i][0] = 0;
        }
    }
}