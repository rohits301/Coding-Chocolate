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

        int maxProfit = buySellStockInfiniteTxn(prices);
        System.out.println(maxProfit);
    }

    private static int buySellStockInfiniteTxn(int[] prices) {
        int profit = 0;
        int bd = 0; // buying Day
        int sd = 0; // selling Day

        for (int i = 1; i < prices.length; i++) {
            // rise, inc. sd
            if (prices[i] >= prices[i - 1]) {
                sd++;
            } else {
                // collect profit and bd and sd = i
                profit += prices[sd] - prices[bd];
                bd = sd = i;
            }
        }

        // collecting the last rise profit
        profit += prices[sd] - prices[bd];
        return profit;
    }
}