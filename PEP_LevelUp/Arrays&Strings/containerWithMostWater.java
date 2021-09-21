import java.util.*;

public class Main {

    // ~~~~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~~~~
    // T: O(n), S: O(1), passes on LeetCode
    public static int mostWater(int[] heights) {
        // write your code here

        int i = 0;
        int j = heights.length - 1;

        int maxArea = 0;

        while (i < j) {
            int width = j - i;
            int minht = Math.min(heights[i], heights[j]);

            int area = width * minht;

            if (area > maxArea) maxArea = area;

            if (heights[i] <= heights[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxArea;
    }

    // ~~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~~~

    public static void main(String[] args) {
        // Write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = scn.nextInt();
        }

        int res = mostWater(heights);
        System.out.println(res);
    }
}