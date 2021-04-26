import java.io.*;
import java.util.*;

public class Main {

    public static void queensCombinations(int qpsf, int tq, int row, int col, String asf){
        // tq => (chess[0].length == chess.length)
        
        if(row == tq){
            if(qpsf == tq){
                System.out.println(asf);
            }
            return;
        }
        
        int nr = 0;
        int nc = 0;
        
        String yes = asf;
        String no = asf;
        
        if(col == (tq - 1)){
            nr = row + 1;
            nc = 0;
            yes += "q\n";
            no += "-\n";
        } else {
            nr = row;
            nc = col + 1;
            yes += "q";
            no += "-";
        }
        
        queensCombinations(qpsf + 1, tq, nr, nc, yes); // yes 
        queensCombinations(qpsf, tq, nr, nc, no); // no 
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        queensCombinations(0, n, 0, 0, "");
    }
}