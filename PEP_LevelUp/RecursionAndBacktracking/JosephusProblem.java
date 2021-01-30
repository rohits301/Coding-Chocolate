// ******************************** Recursive Solution ****************************
/*
import java.io.*;
import java.util.*;

public class Main {

    public static int solution(int n, int k) {
        //write your code here
        
        if(n == 1){
            return 0;
        }
        
        int x = solution(n - 1, k);
        int y = (x + k) % n;
        //* System.out.println("n is " + n + ", x is " + x + ", y is " + y );
        
        return y;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        System.out.println(solution(n, k));
    }
}
*/
import java.io.*;
import java.util.*;

public class Main {

    public static int solution(int n, int k) {
        //write your code here

        // WORKS FOR CASES HAVING k > n ALSO

        // ******************************** Iterative Solution ****************************
        int indexOfPersonAlive = 0; // n = 1, return 0 (BASE CASE)

        // i = changing value of n in recursion
        // k = no. of people to be skipped

        for (int i = 2; i <= n; i++) {
            indexOfPersonAlive = (indexOfPersonAlive + k) % i; // index at next level, i.e., y = (x + k) % n;
        }

        // int position = indexOfPersonAlive + 1; // y + 1 is the final answer acc. to this question at GFG

        return indexOfPersonAlive;

    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        System.out.println(solution(n, k));
    }
}

