import java.io.*;
import java.util.*;

public class Main{
  public static void display(int[] a){
    StringBuilder sb = new StringBuilder();

    for(int val: a){
      sb.append(val + " ");
    }
    System.out.println(sb);
  }

  public static void rotate(int[] a, int k){
    // write your code here
    k %= a.length;  //FIRST MODULUS
    if(k < 0) {     //THEN ADD A.LENGTH
        k += a.length;
    }
    
    int lo1 = 0, hi1=a.length-k-1;
    int lo2 = a.length-k, hi2 = a.length-1;
    
    reverse(a, lo1, hi1);
    reverse(a, lo2, hi2);
    reverse(a, lo1, hi2);
  }
  
  public static void reverse(int[] arr, int lo, int hi){
    while(lo<hi){   //lo==hi not needed coz no change on swap
        int temp=arr[lo];
        arr[lo]=arr[hi];
        arr[hi]=temp;
        
        lo++;
        hi--;
    }
  }

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }
    int k = Integer.parseInt(br.readLine());

    rotate(a, k);
    display(a);
 }

}