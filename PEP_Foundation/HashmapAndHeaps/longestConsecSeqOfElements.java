import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }

        longestConsecSeqOfElements(arr);
    }

    private static void longestConsecSeqOfElements(int[] arr) {
        // ** map of int, boolean to avoid duplicates **
        HashMap<Integer, Boolean> map = new HashMap<>();

        // make all as starting point
        for (int val : arr) {
            map.put(val, true);
        }

        // starting point is valid if val-1 is absent from map
        for (int val : arr) {
            if (map.containsKey(val - 1)) {
                map.put(val, false);
            }
        }

        // finding maximum out of all possible starting points

        int msp = 0; // maximum length starting point
        int ml = 0; // maximum length

        for (int val : arr) {
            if (map.get(val)) {
                int tsp = val; // temp starting point
                int tl = 1; // temp length

                while (map.containsKey(tsp + tl)) {
                    tl++;
                }

                if (tl > ml) {
                    msp = tsp;
                    ml = tl;
                }
            }
        }

        for (int i = 0; i < ml; i++) {
            System.out.println(msp + i);
        }
    }

}