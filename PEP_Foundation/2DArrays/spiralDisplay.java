import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int m = scn.nextInt();

        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scn.nextInt();
            }
        }

        int minc = 0;
        int maxc = arr[0].length - 1;
        int minr = 0;
        int maxr = arr.length - 1;

        int count = 0;
        int tne = (arr.length) * (arr[0].length);

        while (count < tne) {
            for (int i = minr; i <= maxr && count < tne; i++) {
                System.out.println(arr[i][minc]);
                count++;
            }
            minc++;

            for (int j = minc; j <= maxc && count < tne; j++) {
                System.out.println(arr[maxr][j]);
                count++;
            }
            maxr--;

            for (int i = maxr; i >= minr && count < tne; i--) {
                System.out.println(arr[i][maxc]);
                count++;
            }
            maxc--;

            for (int j = maxc; j >= minc && count < tne; j--) {
                System.out.println(arr[minr][j]);
                count++;
            }
            minr++;

        }
    }

}