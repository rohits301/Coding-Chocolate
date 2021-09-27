import java.util.*;

public class Main {

    // ~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~
    public static List<Integer> partitionLabels(String s) {
        // write your code here

        // 1. Put last occurrences of characters in array
        int[] loarr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            loarr[ch - 'a'] = i;
        }

        // 2. add chunk-length to result
        List<Integer> res = new ArrayList<>();
        int prev = -1;
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            max = Math.max(max, loarr[ch - 'a']);

            if (max == i) {
                res.add(max - prev);
                prev = max;
            }
        }

        return res;
    }

    // ~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();

        List<Integer> res = partitionLabels(str);
        for (int val : res) {
            System.out.print(val + " ");
        }
    }
}