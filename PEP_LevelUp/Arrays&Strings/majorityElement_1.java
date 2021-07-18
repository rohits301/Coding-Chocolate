import java.util.*;

public class Main {

    // ~~~~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~~~~

    private static int potentialCanditate(int[] arr) {
        int val = arr[0];
        int count = 1;

        for (int i = 1; i < arr.length; i++) {
            if (val == arr[i]) {
                // same element, increment freq.
                count++;
            } else {
                // distinct element, map it
                count--;
            }

            if (count == 0) {
                val = arr[i]; // last value in array
                count = 1;
            }
        }
        return val;
    }

    public static void printMajorityElement(int[] arr) {
        // write your code here

        int val = potentialCanditate(arr);
        int freq = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == val) {
                freq++;
            }
        }

        if (freq > arr.length / 2) {
            System.out.println(val);
        } else {
            System.out.println("No Majority Element exist");
        }
    }

    // ~~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~~~

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        printMajorityElement(arr);
    }
}