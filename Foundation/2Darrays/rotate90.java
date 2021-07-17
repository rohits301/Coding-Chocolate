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
                arr[i][j]=s.nextInt();    
            }
        }
        
        rotate(arr);
        display(arr);
    }
    
    public static void rotate(int[][] arr){
        transpose(arr);
        
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr.length/2; j++){
                int temp = arr[i][j];
                arr[i][j]=arr[i][arr.length-1-j];
                arr[i][arr.length-1-j]=temp;
            }
        }
    }
    
    public static void transpose(int[][] arr){
        for(int i=0; i<arr.length; i++){
            for(int j=i; j<arr[0].length; j++){ //j starts from i else same arr results! only transpose upper triangle
                int temp = arr[i][j];   //DON'T JUST DO ARR[I][J] = ARR[J][I] LIKE AN IDIOT.
                arr[i][j]=arr[j][i];
                arr[j][i]=temp;
            }
        }
    }

    public static void display(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}