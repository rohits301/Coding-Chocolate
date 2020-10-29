import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner s = new Scanner(System.in);
        int x = s.nextInt();
        int n = s.nextInt();
        
        System.out.println(power(x,n));
    }

    public static int power(int x, int n){
        if(n==0){
            return 1;   //x^0=1
        }
        
        int p = power(x, n/2);
        int xn = p*p;
        //x^n = x^n/2 * x^n/2
        
        if(n%2==1){
            xn*=x;
        }
        
        return xn;
    }

}