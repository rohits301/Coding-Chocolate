import java.io.*;
import java.util.*;

public class Main {
    static int max = 0;

    public static void getMaxGold(int[][] arr) {
        // write your code here

        // int maxGold = Integer.MIN_VALUE;
        boolean[][] visited = new boolean[arr.length][arr[0].length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                int compGold = 0;
                if (arr[i][j] != 0 && visited[i][j] == false) {
                    compGold = dfs(arr, i, j, visited);
                    // if(compGold > maxGold){
                    // maxGold = compGold;
                    // }

                    if (compGold > max) {
                        max = compGold;
                        // System.out.println("Max Gold = " + max);
                    }
                    // else {
                    // System.out.println("Max Gold not updated");
                    // }
                }
            }
        }
        // System.out.println(maxGold);
    }

    private static int dfs(int[][] arr, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= arr.length || j < 0 || j >= arr[0].length || visited[i][j] == true || arr[i][j] == 0) {
            return 0;
        }

        visited[i][j] = true;
        int lg = dfs(arr, i, j - 1, visited); // left, e
        int ug = dfs(arr, i - 1, j, visited); // up, n
        int rg = dfs(arr, i, j + 1, visited); // right, w
        int dg = dfs(arr, i + 1, j, visited); // down, s

        int tg = arr[i][j] + lg + ug + rg + dg;
        // System.out.println("Total Gold = " + tg);
        return tg;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[m][n];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        getMaxGold(arr);
        System.out.println(max);
    }

}