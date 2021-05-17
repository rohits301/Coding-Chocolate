// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver_class {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int grid[][] = new int[9][9];
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++)
                    grid[i][j] = sc.nextInt();
            }

            Solution ob = new Solution();

            if (ob.SolveSudoku(grid) == true)
                ob.printGrid(grid);
            else
                System.out.print("NO solution exists");
            System.out.println();

        }
    }
}

// } Driver Code Ends

// User function Template for Java

class Solution {
    static boolean flag;

    static boolean SolveSudoku(int grid[][]) {
        // add your code here
        flag = false;
        solve(grid, 0, 0);

        // System.out.println(flag);
        // if(flag){
        // printGrid(grid);
        // }
        return flag;

    }

    static void solve(int grid[][], int i, int j) {
        // i == 9
        if (i == grid.length) {
            flag = true;
            // System.out.println("Flag is " + flag);
            // printGrid(grid);
            // System.out.println();
            return;
        }

        int ni = 0;
        int nj = 0;

        // next box indices
        if (j == grid[0].length - 1) {
            ni = i + 1;
            nj = 0;
        } else {
            ni = i;
            nj = j + 1;
        }

        if (grid[i][j] == 0) {
            // try options
            for (int options = 1; options <= 9; options++) {
                if (isValid(grid, i, j, options)) {
                    grid[i][j] = options;
                    solve(grid, ni, nj);
                    grid[i][j] = 0;
                }
            }
        } else {
            solve(grid, ni, nj);
        }
    }

    static boolean isValid(int[][] grid, int row, int col, int options) {
        // row check && col check
        for (int k = 0; k < grid[0].length; k++) {
            if (grid[row][k] == options || grid[k][col] == options) {
                return false;
            }
        }

        // sub-matrix check
        int smi = row / 3 * 3; // sub-matrix corner row
        int smj = col / 3 * 3; // sub-matrix corner col

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (grid[smi + r][smj + c] == options) {
                    return false;
                }
            }
        }

        return true;
    }

    static void printGrid(int[][] grid) {
        // add your code here
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
        }
    }
}