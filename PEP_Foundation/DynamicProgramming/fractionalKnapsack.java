/*
The code passes 4/5 test cases, the failed test case is as follows
20
1 43 22 25 10 7 17 16 7 2 12 11 37 40 48 35 1 35 3 25 
8 5 5 2 7 3 2 4 5 6 10 3 9 6 10 4 7 7 10 3 
4
My ans = 42.5, same as gfg answer
Expected = 42.2
PEP solution is wrong passes only 3 test cases
*/

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[] wts = new int[n];
        int[] val = new int[n];

        for (int i = 0; i < n; i++) {
            val[i] = scn.nextInt();
        }
        for (int i = 0; i < n; i++) {
            wts[i] = scn.nextInt();
        }

        int cap = scn.nextInt();

        double maxValue = fractionalKnapsack(wts, val, cap);
        System.out.println(maxValue);
    }

    public static class Pair implements Comparable<Pair> {
        int v; // val[i]
        int wt;
        double cpwt; // cost per weight

        Pair(int v, int wt, double cpwt) {
            this.v = v;
            this.wt = wt;
            this.cpwt = cpwt;
        }

        public int compareTo(Pair o) {
            return (int) (o.cpwt) - (int) (this.cpwt); // descending order
        }
    }

    public static void print(Pair[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(
                    "[ " + "Weight: " + arr[i].wt + " Value: " + arr[i].v + " Cost per wt: " + arr[i].cpwt + " ]");
        }
        System.out.println();
    }

    private static double fractionalKnapsack(int[] wts, int[] val, int cap) {
        int n = wts.length;

        Pair[] p = new Pair[n];

        for (int i = 0; i < n; i++) {
            p[i] = new Pair(val[i], wts[i], (double) (val[i]) / (double) (wts[i]));
        }
        // print(p);
        Arrays.sort(p);
        // print(p);

        double totalValue = 0.0;

        for (int i = 0; i < p.length; i++) {

            int weight = p[i].wt;
            int value = p[i].v;

            if (cap - weight >= 0) {

                // this weight can be picked whole
                cap = cap - weight;
                totalValue += value;
            } else {

                // item can't be picked whole
                double fraction = ((double) cap / (double) weight);
                totalValue += ((double) value * fraction);
                cap = (int) (cap - ((double) weight * fraction));
                break;
            }
        }

        return totalValue;
    }
}