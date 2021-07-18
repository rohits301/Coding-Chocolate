import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code hereScanner s = new Scanner(System.in);
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int[][] arr = new int[n][m];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                arr[i][j]=s.nextInt();
            }
        }
        
        exitpoint(arr);
    }
    
    public static void exitpoint(int[][] arr){
        boolean goingright=true;
        boolean goingdown=false;
        boolean goingleft=false;
        boolean goingup=false;
        int row=0, col=0;
        
        while(row>=0 && row<arr.length && col>=0 && col<arr[0].length){
            while(goingright){
                col++;
                if(col==arr[0].length){
                    System.out.println(row);
                    System.out.println(col-1);
                    return;
                }
                
                if(arr[row][col]==1){
                    goingright=false;
                    goingdown=true;
                    break;
                }
            }
            
            while(goingdown){
                row++;
                if(row==arr.length){
                    System.out.println(row-1);
                    System.out.println(col);
                    return;
                }
                
                if(arr[row][col]==1){
                    goingdown=false;
                    goingleft=true;
                    break;
                }
            }
            
            while(goingleft){
                col--;
                if(col==-1){
                    System.out.println(row);
                    System.out.println(col+1);
                    return;
                }
                
                if(arr[row][col]==1){
                    goingleft=false;
                    goingup=true;
                    break;
                }
            }
            
            while(goingup){
                row--;
                if(row==-1){
                    System.out.println(row+1);
                    System.out.println(col);
                    return;
                }
                
                if(arr[row][col]==1){
                    goingup=false;
                    goingright=true;
                    break;
                }
            }
        }
    }

}