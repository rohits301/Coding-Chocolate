import java.util.*;

public class Main {

    // ~~~~~~~~~~~~~User Section~~~~~~~~~~~~~
    
    // T: O(n^2), S: O(1), passed on LeetCode
    public static void rotate(int[][] matrix) {
        // write your code here

        int n = matrix.length;

        // 1. Transpose of square matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (i != j) {
                    // swap a [i,j] and a [j,i]
                    int t = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = t;
                }
            }
        }

        // 2. row reverse for all rows
        for (int i = 0; i < n; i++) {

            int left = 0, right = n - 1;

            while (left < right) {

                int t = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = t;

                left++;
                right--;
            }
        }
    }

    // ~~~~~~~~~~~Input Management~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scn.nextInt();
            }
        }
        rotate(matrix);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}