import java.io.*;
import java.util.*;
import java.lang.Math;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        // write your code here

        // 2's complement => n" =  -n
        int rsbm = n & -n;
        System.out.println(Integer.toBinaryString(rsbm));
    }

}