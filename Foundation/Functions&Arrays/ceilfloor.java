import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    int[] arr = new int[n];
    for(int i=0; i<n; i++) {
        arr[i]=s.nextInt();
    }
    int d = s.nextInt();
    ceilfloor(arr,d);
 }
 
 public static void ceilfloor(int[] arr, int d){
     int ceil = Integer.MAX_VALUE;
     int floor = Integer.MIN_VALUE;
     
     int lo = 0;
     int hi = arr.length-1;
     while(lo <= hi) {
         int mid = (lo+hi)/2;
         if(arr[mid] > d) { //compare d w arr[mid] & not mid 0_0
             ceil = arr[mid];
             hi = mid-1;
         }else if(arr[mid] < d) {
             floor = arr[mid];
             lo = mid+1;
         }else {
             floor = arr[mid-1];
             ceil = arr[mid+1];
             break;
         }
         //DON'T DO LO++ & HI-- LIKE AN IDIOT :)
     }
     
     System.out.println(ceil);
     System.out.println(floor);
 }

}