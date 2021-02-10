import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        
        int ans = paintFence(n, k);
        System.out.println(ans);
    }
    private static int paintFence(int n, int k){
        int same = k * 1;
        int diff = k * (k - 1);
        
        int total = same + diff;
        
        for(int i = 3; i <= n; i++){
            same = diff * 1;
            diff = total * (k - 1);
            total = same + diff;
        }
        
        return total;
    }
}