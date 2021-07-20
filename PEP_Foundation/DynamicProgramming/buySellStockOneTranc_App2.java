import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = scn.nextInt();
        }

        int maxProfit = buySellOneTxn(prices);
        System.out.println(maxProfit);
    }

    private static int buySellOneTxn(int[] prices) {
        int maxProfit = 0;
        int profitIfSoldToday = 0;
        int leastSoFar = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < leastSoFar) {
                leastSoFar = prices[i];
            }

            profitIfSoldToday = prices[i] - leastSoFar;

            if (profitIfSoldToday > maxProfit) {
                maxProfit = profitIfSoldToday;
            }
        }
        return maxProfit;
    }
}