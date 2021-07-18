import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner s = new Scanner(System.in);
    int n1 = s.nextInt();
    int[] arr1 = new int[n1];
    for(int i=0; i<n1; i++){
        arr1[i]=s.nextInt();
    }
    
    int n2 = s.nextInt();
    int[] arr2 = new int[n2];
    for(int i=0; i<n2; i++){
        arr2[i]=s.nextInt();
    }
    
    int[] sum = sum(arr1,arr2);
    for(int i=0;i<sum.length; i++){
        if(i==0 && sum[i]==0){
            continue;
        }
        System.out.println(sum[i]);
    }
 }
 
 public static int[] sum(int[] a1, int[] a2){
     int[] res = new int[Math.max(a1.length, a2.length) + 1];
     int carry = 0;
     int i = a1.length-1;
     int j = a2.length-1;
     int k = res.length-1;
     
     while(k >= 0) {
         int sum = 0;
         if(i >= 0){
             sum += a1[i];
         }
         if(j >= 0){
             sum += a2[j];
         }
         if(carry != 0){
             sum += carry;
         }
         
         res[k] = sum % 10;
         carry = sum / 10;
         
         i--;
         j--;
         k--;
     }
     
     return res;
     
 }

}