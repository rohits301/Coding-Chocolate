import java.util.*;

public class Main {
    // ~~~~~~~~~~~~~~User Section~~~~~~~~~~~~
    
    // T: O(n), S: O(1), passed on LeetCode
    public static String reverseVowels(String s) {
        // write your code here

        int n = s.length();
        char[] arr = s.toCharArray();

        int i = 0, j = n - 1;
        while (i < j) {

            while (i < j && !isVowel(arr[i])) {
                i++;
            }
            while (j > i && !isVowel(arr[j])) {
                j--;
            }

            // both are at vowels, swap
            swap(arr, i, j);
            i++;
            j--;
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : arr) {
            sb.append(ch);
        }
        return sb.toString();
    }

    private static void swap(char[] arr, int i, int j) {
        char t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static boolean isVowel(char ch) {
        if (ch == 'a' || ch == 'A' || ch == 'e' || ch == 'E' || ch == 'i' || ch == 'I' || ch == 'o' || ch == 'O' || ch == 'u' || ch == 'U') {

            return true;
        }
        return false;
    }

    // ~~~~~~~~~~~~Input Management~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();

        String res = reverseVowels(str);
        System.out.println(res);
    }
}
