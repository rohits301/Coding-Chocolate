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
    
    int[] diff = diff(arr1,arr2);
    
    int i=0;
    while(diff[i]==0){
        i++;
    }
    while(i<diff.length){
        System.out.println(diff[i]);
        i++;
    }
    
 }
 
 public static int[] diff(int[] a1, int[] a2){
     /* 
     //in case not told which num is big & lengths of nos are different 
     
     int[] max = a1.length > a2.length ? a1 : a2;
     int[] min = (max == a1 ? a2 : a1);
     
     int[] res = new int[max.length];
     
     int i=max.length-1;
     int j=min.length-1;
     int k=res.length-1;
     
     while(k>=0){
         int diff = 0;
         
         if(i >= 0 && j >= 0) {
             if(max[i] < min[j]) {
                 max[i] += 10;
                 max[i-1] = (max[i-1] == 0 ? 9 : max[i-1] - 1);
             }
             
             diff = max[i] - min[j];
         }
         
         if(j < 0) {
             diff = max[i];
         }
         
         res[k] = diff;
         
         i--; j--; k--;
     }
     */
     
     //find a2-a1
     int[] res = new int[a2.length];
     
     int i=a2.length-1;
     int j=a1.length-1;
     int k=res.length-1;
     
     while(k >= 0) {
         int diff = 0;
         
         if(i >= 0 && j >= 0) {
             if(a2[i] < a1[j]) {
                 a2[i] += 10;
                 a2[i-1] = a2[i-1] - 1;
             }
             
             diff = a2[i] - a1[j];
         }
         
         if(j < 0) {
             diff = a2[i];
         }
         
         res[k] = diff;
         
         i--; j--; k--;
     }
     
     return res;
 }

}