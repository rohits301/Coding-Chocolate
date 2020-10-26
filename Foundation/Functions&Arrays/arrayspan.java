import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    int[] arr = new int[n];
    for(int i=0; i<n; i++){
        arr[i] = s.nextInt();
    }
    System.out.println(span(arr));
 }
 
 public static int span(int[] arr){
     int max = Integer.MIN_VALUE;
     int min = Integer.MAX_VALUE;
     
     for(int i=0; i<arr.length; i++){
         if(arr[i]>max) max=arr[i];
         if(arr[i]<min) min=arr[i];
     }
     
     return max-min;
 }

}