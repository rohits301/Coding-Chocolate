import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    int[] arr = new int[n];
    for(int i=0; i<n; i++){
        arr[i]=s.nextInt();
    }
    
    barchart(arr);
 }
 
 public static void barchart(int[] arr){
     int max = arr[0];
     for(int i=1; i<arr.length; i++){
         if(arr[i]>max){
             max = arr[i];
         }
     }
     
     for(int i = max; i >= 1; i--){
         for(int j=0; j<arr.length; j++){
             if(arr[j]>=i){
                 System.out.print("*	");
             }else{
                 System.out.print("	");
             }
         }
         System.out.println();
     }
     
     
 }

}