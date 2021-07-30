import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int i = scn.nextInt();
        int j = scn.nextInt();
        int k = scn.nextInt();
        int m = scn.nextInt();

        // write your code here

        // set bit on => |
        int onmask = (1 << i); // 00001000
        int set = (n | onmask);

        // unset (set bit off) => &
        int offmask = ~(1 << j); // 00001000 -> 11110111
        int unset = (n & offmask);

        // toggle => ^
        int tmask = (1 << k);
        int toggle = (n ^ tmask);

        // check => & (can use | also)
        // oper. is &, mask is OR waala
        int cmask = (1 << m);
        boolean check = ((n & cmask) == 0) ? false : true; // if 0 => off, else on

        System.out.println(set);
        System.out.println(unset);
        System.out.println(toggle);
        System.out.println(check);
    }

}