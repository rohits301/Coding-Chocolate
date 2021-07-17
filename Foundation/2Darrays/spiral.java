import java.io.*;
import java.util.*;

public class Main {

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
        
        spiral(arr);
    }
    
    //ref to sir's code, it's cleaner than this one
    
    public static void spiral(int[][] arr){
        int elems = arr.length * arr[0].length;
        
        int count = 0;
        int startrow=0,startcol=0;
        int endrow=arr.length-1,endcol=arr[0].length-1;
        int row = startrow, col = startcol;
        
        boolean goingdown=true;
        boolean goingright=true;
        
        while(count < elems) {  // <, NOT lessthan equalto (IMPORTANT!!)
            //< bec at < it will go inside & print the last elem.
            //if it goes in at "count = elems" then will print extra(bec at c=elems all have been printed. beyond this duplicates will be printed)
            if(goingdown){
                row=startrow;
                while(row<=endrow && count<elems){
                    // if(count>elems){
                    //     return;
                    // }
                    System.out.println(arr[row][col]);
                    count++;
                    row++;
                }
                row=endrow; //reset
                startcol++;
                goingright=true;
            }else{
                row=endrow;
                while(row>=startrow && count<elems){
                    // if(count>elems){
                    //     return;
                    // }
                    System.out.println(arr[row][col]);
                    count++;
                    row--;
                }
                row=startrow; //reset
                endcol--;
                goingright=false;
            }
            
            if(goingright){
                col=startcol;
                while(col<=endcol && count<elems){
                    // if(count>elems){
                    //     return;
                    // }
                    System.out.println(arr[row][col]);
                    count++;
                    col++;
                }
                col=endcol; //reset
                endrow--;
                goingdown=false;
            }else{
                col=endcol;
                while(col>=startcol && count<elems){
                    // if(count>elems){
                    //     return;
                    // }
                    System.out.println(arr[row][col]);
                    count++;
                    col--;
                }
                col=startcol; //reset
                startrow++;
                goingdown=true;
            }
        }
        
    }

}