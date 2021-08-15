import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        int[] wts = new int[n];
        int[] val = new int[n];
        
        for(int i = 0; i < n; i++){
            val[i] = scn.nextInt();
        }
        for(int i = 0; i < n; i++){
            wts[i] = scn.nextInt();
        }
        
        int cap = scn.nextInt();
        
        double maxValue = fractionalKnapsack(wts, val, cap);
        System.out.println(maxValue);
    }
    
    static class Pair {
        int value, weight;
        
        Pair(int value, int weight){
            this.value = value;
            this.weight = weight;
        }
    }
    
    static class PairComparator implements Comparator<Pair> {
        @Override
        
        public int compare(Pair a, Pair b){
            double v1 = (double)a.value / (double)a.weight;
            double v2 = (double)b.value / (double)b.weight;
            
            if(v1 < v2) return 1;
            else if(v1 > v2) return -1;
            else return 0;
        }
    }
    
    static double fractionalKnapsack(int[] wts, int[] val, int cap) 
    {
        // Your code here
        int n = wts.length;
        Pair[] arr = new Pair[n];
        for(int i = 0; i < n; i++){
            arr[i] = new Pair(val[i], wts[i]);
        }
        
        Arrays.sort(arr, new PairComparator()); //sort desc
        
        int cwt = 0; // curr weight
        double profit = 0;
        
        for(int i = 0; i < arr.length; i++){
            
            if(cwt + arr[i].weight <= cap){
                cwt += arr[i].weight;
                profit += arr[i].value;
            } 
            else {
                int rem = cap - cwt; // remaining weight
                profit += ((double)arr[i].value / (double)arr[i].weight) * (double)rem;
                break; // Now since knapsack is filled, hence break
            }
        }
        
        return profit;
    }
}