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
    
    int fi = firstidx(arr,d);
    int li = lastidx(arr,d);
    System.out.println(fi);
    System.out.println(li);
 }
 
 public static int firstidx(int[] arr, int d){
     int lo = 0, hi = arr.length-1;
     int fi = -1;
     
     while(lo<=hi){
         int mid = (lo+hi)/2;
         
         if(arr[mid]>d){
             hi = mid - 1;
         }else if(arr[mid]<d){
             lo = mid + 1;
         }else{
             fi = mid;  //it's a potential answer
             hi = mid-1; //still check further left
         }
        //DON'T DO LO++ & HI-- LIKE AN IDIOT :)
     }
     
     return fi;
 }
 
 public static int lastidx(int[] arr, int d){
     int lo = 0, hi = arr.length-1;
     int li = -1;
     
     while(lo<=hi){
         int mid = (lo+hi)/2;
         
         if(arr[mid]>d){
             hi = mid - 1;
         }else if(arr[mid]<d){
             lo = mid + 1;
         }else{
             li = mid;  //it's a potential answer
             lo = mid+1; //still check further right
         }
        //DON'T DO LO++ & HI-- LIKE AN IDIOT :)
     }
     
     return li;
 }

}