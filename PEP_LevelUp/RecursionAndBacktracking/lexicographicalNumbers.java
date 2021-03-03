import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        // write your code here

        for (int i = 1; i <= 9; i++) {
            lexicographicalNos(i, n);
        }
    }

    private static void lexicographicalNos(int i, int n) {
        if (i > n) {
            return;
        }

        System.out.println(i); // print in preorder

        for (int j = 0; j <= 9; j++) {
            lexicographicalNos(i * 10 + j, n);
        }
    }
}