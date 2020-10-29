import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = s.nextInt();
        }
        
        int x = s.nextInt();
        
        System.out.println(lastIndex(arr, 0, x));
    }

    public static int lastIndex(int[] arr, int idx, int x){
        if(idx==arr.length){
            return -1;
        }
        
        int li = lastIndex(arr, idx+1, x);
        
        if(arr[idx]==x && li==-1){
            return idx;
        }else{
            return li;
        }
        
    }

}