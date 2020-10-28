import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[][] arr = new int[n][n];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = s.nextInt();
            }
        }
        
        int x = s.nextInt();
        
        // sortedsearch(arr, x);
        smartercode(arr,x);
    }
    
    public static void sortedsearch(int[][] arr, int x){
        int row = -1;
        for(int i=0; i<arr.length; i++) {
            int lastofrow = arr[i][arr[0].length-1];
            if(x < lastofrow) {
                row=i;
                break;
            }else if(x > lastofrow) {
                continue;
            }else if(x == lastofrow) {
                System.out.println(i);
                System.out.println(arr[0].length-1);
                return;
            }
        }
        
        if(row == -1) {    //larger than max so not found(last row se bhi continue kar gya)
            System.out.println("Not Found");
            return;
        } else {    
            //apply binary search NOT linear!! [SORTED ARRAY!]
            int left=0, right=arr[row].length-1;
            
            while(left <= right) {
                int mid = (left+right)/2;
                if(arr[row][mid]==x){
                    System.out.println(row);
                    System.out.println(mid);
                    return;
                }else if(arr[row][mid]<x){
                    left = mid+1;
                }else{
                    right=mid-1;
                }
            }
            
        }
        
        System.out.println("Not Found");    //not found in the row
    }
    
    public static void smartercode(int[][] arr, int x){ 
        int row=0, col=arr[0].length-1;
        
        while(row < arr.length && col >= 0) {    //both together!
            if(x == arr[row][col]){
                System.out.println(row);
                System.out.println(col);
                return;
            }else if(x > arr[row][col]){    //goto next row
                row++;
            }else{  //go back in same row
                col--;
            }
        }
        
        System.out.println("Not Found");
    }

}