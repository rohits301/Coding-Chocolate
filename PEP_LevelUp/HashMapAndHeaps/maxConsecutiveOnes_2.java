import java.util.*;

public class Main {

    // T: O(n), S: O(1)
    public static int solution(int[] arr, int k) {
        // write your code here

        int ans = 0;

        int countZeros = 0;
        int j = -1;
        int len = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                countZeros++;
            }

            while (countZeros > k) {
                j++;
                if (arr[j] == 0) {
                    countZeros--;
                }
            }

            len = i - j;
            if (len > ans) {
                ans = len;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        System.out.println(solution(arr, k));
    }

}
