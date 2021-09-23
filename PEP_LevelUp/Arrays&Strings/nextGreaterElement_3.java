import java.util.*;

public class Main {

    // ~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~
    // T: O(n), S: O(n), LC.556 is little different, done seperately
    public static String nextGreaterElement(String str) {
        // write your code here

        char[] arr = str.toCharArray();

        int i = arr.length - 2;

        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }
        // already max number
        if (i == -1) {
            return "-1";
        }

        // swap case
        int j = arr.length - 1;
        while (arr[i] >= arr[j]) {
            j--;
        }
        // now swap i and j (next greater value)
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        StringBuilder res = new StringBuilder();
        // concatenate from 0 to i
        for (int k = 0; k <= i; k++) {
            res.append(arr[k]);
        }

        // concatenate from arr.length-1 to i-1 (reverse order)
        for (int k = arr.length - 1; k > i; k--) {
            res.append(arr[k]);
        }

        return res.toString();
    }

    // ~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String num = scn.next();
        String res = nextGreaterElement(num);

        System.out.println(res);
    }
}