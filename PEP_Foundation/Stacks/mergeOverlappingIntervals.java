import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            arr[j][0] = Integer.parseInt(line.split(" ")[0]);
            arr[j][1] = Integer.parseInt(line.split(" ")[1]);
        }

        mergeOverlappingIntervals(arr);
    }
    
    /* IMPORTANT - solution video badiya hai */
    /* HADD TODU CODE */
    
    public static void mergeOverlappingIntervals(int[][] arr) {
        // merge overlapping intervals and print in increasing order of start time
        
        Pair[] p = new Pair[arr.length];
        
        for(int i = 0; i < arr.length; i++) {
            p[i] = new Pair(arr[i][0], arr[i][1]);
        }
        
        Arrays.sort(p);
        
        Stack<Pair> s = new Stack<>();
        s.push(p[0]);
        
        // st-start time, et-end time
        
        for(int i = 1; i < arr.length; i++) {
            Pair top = s.peek();
            if(top.et >= p[i].st) {
                // merge
                top.et = Math.max(top.et, p[i].et);
            } else {
                s.push(p[i]);
            }
        }
        
        // shift elements to result stack
        Stack<Pair> rs = new Stack<>();
        while(s.size() > 0) {
            rs.push(s.pop());
        }
        
        // display 
        while(rs.size() > 0){
            Pair rpair = rs.pop();
            System.out.println(rpair.st + " " + rpair.et);
        }
    }
    
    public static class Pair implements Comparable<Pair> {
        int st;
        int et;
        
        Pair() {
            
        }
        Pair(int st, int et) {
            this.st = st;
            this.et = et;
        }
        
        /*
        this > other => return +ve
        this = other => return 0
        this < other => return -ve
        */
        public int compareTo(Pair other) {
            if(this.st != other.st) {
                return this.st - other.st;
            } else {
                return this.et - other.et;
            }
        }
    }

}