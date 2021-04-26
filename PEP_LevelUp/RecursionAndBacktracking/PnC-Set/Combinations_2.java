import java.io.*;
import java.util.*;

public class Main {

    public static void combinations(int[] boxes, int ci, int ti, int lb){
        // write your code here
        
        if(ci > ti){
            for(int val : boxes){
                if(val == 1){
                    System.out.print("i");
                } else {
                    System.out.print("-");
                }
            }
            System.out.println();
            return;
        }
        
        for(int b = lb + 1; b < boxes.length; b++){
            if(boxes[b] == 0){
                boxes[b] = 1;
                combinations(boxes, ci + 1, ti, b);
                boxes[b] = 0;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nboxes = Integer.parseInt(br.readLine());
        int ritems = Integer.parseInt(br.readLine());
        combinations(new int[nboxes], 1, ritems, -1);
    }

}