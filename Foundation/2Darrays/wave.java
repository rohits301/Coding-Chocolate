import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    int m = s.nextInt();
    int[][] arr = new int[n][m];
    
    for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
            arr[i][j]=s.nextInt();
        }
    }
    
    //wavedisplay(arr);
    wave(arr);
 }
 
 public static void wave(int[][] arr){
     
     for(int col=0; col<arr[0].length; col++){
         if(col%2==0){  //even
            for(int row=0; row<arr.length; row++){
                System.out.println(arr[row][col]);
            }
         }else{ //odd
             for(int row=arr.length-1; row>=0; row--){
                System.out.println(arr[row][col]);
            }             
         }
     }
 }
 
 /*
 public static void wavedisplay(int[][] arr){
     int elems = arr.length*arr[0].length;
     boolean goingdown = true;
     
     int count=0;
     int i=0,j=0;
     
     while(count<=elems){
         if(goingdown){
             for(i=0; i<arr.length; i++){
                 System.out.println(arr[i][j]);
                 count++;
             }
             j++;
             goingdown = false;
         }else{
             for(i=arr.length-1; i>=0; i--){
                 System.out.println(arr[i][j]);
                 count++;
             }
             j++;
             goingdown = true;
         }
     }
 }
 */

}