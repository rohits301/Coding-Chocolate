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
    subarr(arr);
 }
 
 public static void subarr(int[] arr) {
     for(int i=0; i<arr.length; i++) {
         for(int j=i; j<arr.length; j++) {
             for(int k=i; k<=j; k++) {
                System.out.print(arr[k]+"	");
             }
             System.out.println();
         }
     }
 }

}