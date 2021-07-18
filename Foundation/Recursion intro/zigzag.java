import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        pzz(n);
    }

    public static void pzz(int n){
        if(n == 0){                 //base case
            return;
        }
        
        System.out.print(n + " ");  //Pre
        pzz(n - 1);                 //left call
        System.out.print(n + " ");  //In
        pzz(n - 1);                 //right call
        System.out.print(n + " ");  //Post
        
    }

}