import java.util.*;
    
    public class Main{
    
    public static void main(String[] args) {
      // write your code here  
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        
        printdigs(n);
     }
    
    public static void printdigs(int n){
        int digs = numdigs(n);
        int temp = n;
        int tenpow = (int)Math.pow(10, digs - 1);
        
        while(digs != 0){
            int q = temp / tenpow;
            System.out.println(q);
            temp = temp % tenpow;
            tenpow /= 10;
            digs--;
        }
    }
    
    public static int numdigs(int n){
        int temp = n;
        int count = 0;
        while(temp!=0){
            temp=temp/10;
            count++;
        }
        
        return count;
    }
}