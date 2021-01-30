import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int count = binaryStrings(n);
        System.out.println(count);
    }
    private static int binaryStrings(int n) {
        int countZeros = 0;
        int countOnes = 0;

        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                countZeros = 1;
                countOnes = 1;
                continue;
            }
            int temp = countZeros;
            countZeros = countOnes;
            countOnes = temp + countOnes;
        }
        return countZeros + countOnes;
    }
}