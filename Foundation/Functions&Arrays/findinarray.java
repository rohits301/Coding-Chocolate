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
    int d=s.nextInt();
    System.out.println(find(arr,d));
 }
 
 public static int find(int[] arr, int d){
     for(int i=0; i<arr.length; i++){
         if(arr[i]==d){
             return i;
         }
     }
     return -1;
 }

}