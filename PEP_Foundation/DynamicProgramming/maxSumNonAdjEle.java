import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        
        for(int i = 0; i < arr.length; i++){
            arr[i] = scn.nextInt();
        }
        
        int ans = maxSumNonAdjElement(arr);
        System.out.println(ans);
    }
    private static int maxSumNonAdjElement(int[] arr){
        int inc = arr[0];
        int exc = 0;
        
        for(int i = 1; i < arr.length; i++){
            int newInc = exc + arr[i];
            int newExc = Math.max(inc, exc);
            
            exc = newExc;
            inc = newInc;
        }
        return Math.max(inc, exc);
    }
}