import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner s = new Scanner(System.in);
    int n1 = s.nextInt();
    int m1 = s.nextInt();
    int[][] arr1 = new int[n1][m1];
    
    for(int i=0; i<n1; i++){
        for(int j=0; j<m1; j++){
            arr1[i][j]=s.nextInt();
        }
    }
    
    int n2 = s.nextInt();
    int m2 = s.nextInt();
    int[][] arr2 = new int[n2][m2];
    
    for(int i=0; i<n2; i++){
        for(int j=0; j<m2; j++){
            arr2[i][j]=s.nextInt();
        }
    }
    
    if(arr1[0].length != arr2.length){
         System.out.println("Invalid input");
     }else{
        display(matrixmult(arr1, arr2));
     }
 }
 
 public static int[][] matrixmult(int[][] arr1, int[][] arr2){
     int[][] prod = new int[arr1.length][arr2[0].length];
     
     for(int i=0; i<arr1.length; i++){ //rows of a1
         for(int k=0; k<arr2[0].length; k++){ //cols of a2
             for(int j=0; j<arr1[0].length; j++){ //common dimension
                 prod[i][k]+=arr1[i][j]*arr2[j][k];
             }
         }
     }
     
     return prod;
 }
 
 public static void display(int[][] arr){
     for(int i=0; i<arr.length; i++){
         for(int j=0; j<arr[0].length; j++){
             System.out.print(arr[i][j]+" ");
         }
         System.out.println();
     }
 }

}