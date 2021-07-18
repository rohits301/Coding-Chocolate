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
    subsets(arr);
 }
 
 public static void subsets(int[] arr){
     int pow = (int)Math.pow(2, arr.length);
     String ans = "";
     
     for(int i=0; i < pow; i++){
         ans = ""; //imp
         int temp = i; //imp. dont alter i bec i controls outer loop
         for(int j = arr.length-1; j>=0; j--){ //ulta loop bec first rem is for last element while conv to bin
             int r = temp % 2;
             temp /= 2;
             if(r == 0) {
                 ans = "-	" + ans; //imp. append in front
             } else {
                 ans = arr[j] + "	" + ans;
             }
         }
         System.out.println(ans); //imp. print after one subset is formed
     }
 }
}