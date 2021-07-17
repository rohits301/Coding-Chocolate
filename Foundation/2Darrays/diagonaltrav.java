import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[][] arr = new int[n][n];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = s.nextInt();
            }
        }
        
        diag(arr);
    }
    
    public static void diag(int[][] arr){
        int i=0,j=0,k=0;
        while(k<arr[0].length){
            for(i=0, j=k+i; i<arr.length-k && j<arr[0].length; i++,j++){
                // System.out.println(i+" "+j+" "+k);
                System.out.println(arr[i][j]);
            }
            k++;
        }
        
    }

}