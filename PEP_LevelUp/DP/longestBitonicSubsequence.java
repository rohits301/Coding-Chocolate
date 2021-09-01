import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[] arr = new int[n];
        for(int i = 0;i<n; i++){
            arr[i] = scn.nextInt();
        }
        
        int len = longestBitonicSubseq(arr);
        System.out.println(len);
    }
    
    // T: O(n^2)
    static int longestBitonicSubseq(int[] arr){
        int n = arr.length;
        // lis and lds store length
        
        int[] lis = new int[n];
        for(int i = 0; i < n; i++){
            int max = 0;
            for(int j = 0; j < i; j++){
                if(arr[i] >= arr[j]){
                    max = Math.max(max, lis[j]);
                }
            }
            lis[i] = max + 1;
        }
        
        int[] lds = new int[n];
        for(int i = n-1; i >= 0; i--){
            int max = 0;
            for(int j = n-1; j > i; j--){
                if(arr[i] >= arr[j]){
                    max = Math.max(max, lds[j]);
                }
            }
            lds[i] = max + 1;
        }
        
        int omax = 0;
        for(int i = 0; i < n; i++){
            if(lis[i] + lds[i] - 1 > omax){
                omax = lis[i]+lds[i]-1;
            }
        }
        return omax;
    }

}