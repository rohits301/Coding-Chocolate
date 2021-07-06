class Solution {
    static int maximumPath(int n, int arr[][]) {
        // code here

        n = arr.length;

        // 0th row as it is, hence no need of seperate dp array
        // to find -> max sum reaching the cells in downward rows
        // if cases for cols in all rows
        // 1. somewhere in middle
        // 2. last col
        // 3. first col

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                
                if (j > 0 && j < n - 1) { //1.
                    int f = Math.max(arr[i - 1][j - 1], arr[i - 1][j + 1]);
                    arr[i][j] += Math.max(arr[i - 1][j], f);
                } else if (j > 0) { //2.
                    arr[i][j] += Math.max(arr[i - 1][j], arr[i - 1][j - 1]);
                } else if (j < n - 1) { //3.
                    arr[i][j] += Math.max(arr[i - 1][j], arr[i - 1][j + 1]);
                }
            }
        }

        // for(int[] ar : arr){
        //     for(int val : ar){
        //         System.out.print(val + " ");
        //     }
        //     System.out.println();
        // }

        int omax = 0;
        for (int j = 0; j < n; j++) {
            omax = Math.max(omax, arr[n - 1][j]);
        }
        return omax;
    }
}