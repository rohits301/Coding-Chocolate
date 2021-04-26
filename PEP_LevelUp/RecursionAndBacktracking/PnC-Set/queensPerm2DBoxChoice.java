import java.io.*;
import java.util.*;

public class Main {

    public static void queensPermutations(int qpsf, int tq, int row, int col, String asf, boolean[] queens) {
        
        if(row == tq){
            if(qpsf == tq){
                System.out.println(asf);
                System.out.println();
            }
            return;
        }
        
        int nr = 0;
        int nc = 0;
        String specialChar = "";
        
        if(col == (tq - 1)){
            nr = row + 1;
            nc = 0;
            specialChar = "\n";
        } else {
            nr = row;
            nc = col + 1;
            specialChar = "\t";
        }
        
        String yes = "";
        String no = "";
        
        for(int q = 0; q < tq; q++){
            if(queens[q] == false){
                queens[q] = true;
                yes = asf + "q" + (q + 1) + specialChar;
                queensPermutations(qpsf + 1, tq, nr, nc, yes, queens);
                yes = "";
                queens[q] = false;
            }
        }
        no = asf + "-" + specialChar;
        queensPermutations(qpsf, tq, nr, nc, no, queens);
        
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] queens = new boolean[n];

        queensPermutations(0, n, 0, 0, "", queens);
    }
}