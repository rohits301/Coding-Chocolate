import java.util.*;

public class Main {

    // ~~~~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~~~~

    public static boolean freqGreaterThanNb3(int[] arr, int val) {
        int count = 0;

        for (int ele : arr) {
            if (ele == val)
                count++;
        }

        return count > arr.length / 3;
    }

    // T: O(n), S: O(1), passed on LeetCode
    public static ArrayList<Integer> majorityElement2(int[] arr) {
        // write your code here

        int val1 = arr[0];
        int count1 = 1;

        int val2 = arr[0]; // can assign any random value
        int count2 = 0; // not processed this till now

        for (int i = 1; i < arr.length; i++) {
            if (val1 == arr[i]) {
                count1++;
            } else if (val2 == arr[i]) {
                count2++;
            } else {
                // merge if possible
                if (count1 == 0) {
                    // reset
                    val1 = arr[i];
                    count1 = 1;
                } else if (count2 == 0) {
                    // reset
                    val2 = arr[i];
                    count2 = 1;
                } else {
                    // both are non-zero, merge the triplet
                    count1--;
                    count2--;
                }
            }
        }
        // val1 and val2 are potential candidates

        ArrayList<Integer> al = new ArrayList<>();

        if (freqGreaterThanNb3(arr, val1) == true)
            al.add(val1);

        // if there is only one majority element, hence check first
        if (val2 != val1 && freqGreaterThanNb3(arr, val2) == true)
            al.add(val2); 

        return al;
    }

    // ~~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        ArrayList<Integer> res = majorityElement2(arr);
        System.out.println(res);
    }
}