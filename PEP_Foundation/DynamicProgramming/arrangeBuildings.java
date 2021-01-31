import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        
        // Very similar to countBinaryStrings
        // just apply the same on both sides
        // hence total^2 is the answer
        
        long count = arrangeBuildings(n);
        System.out.println(count);
    }
    public static long arrangeBuildings(int n){
        if(n == 0){
            return 0;
        }
        
        // for n = 1, no need for loop
        
        int countBuildings = 1; // consecutive buildings not allowed, like 0
        int countSpaces = 1; // like 1
        
        for(int i = 2; i <= n; i++){
            int temp = countBuildings;
            countBuildings = countSpaces;
            countSpaces = temp + countSpaces;
        }
        
        long ans = countBuildings + countSpaces; // since, 45th fib number is v.large but in range of int, however, it's square is not in range, so take long for ans
        
        return ans*ans;
    }   
}