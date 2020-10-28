import java.util.*;
   
   public class Main{
   
   public static void main(String[] args) {
     // write your code here  
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        
        System.out.println(rotate(n,k));
    }
    
    public static int rotate(int n, int k) {
        int nod = nod(n);
        if(k==0 || k==nod){
            return n;
        }
        
        k = k % nod;
        
        int res = 0, q=0, r=0;
        int divisor=0, multiplier=0;
        if(k < 0){
            k += nod;
        }
        
        
        divisor = (int)Math.pow(10, k);
        multiplier = (int)Math.pow(10, nod - k);
        q = n / divisor;
        r = n % divisor;
        
        res = r * multiplier + q;
        return res;
    }
   
   public static int nod(int n){    //no of digs
       int temp = n;
       int nod = 0;
       
       while(temp != 0) {
           temp /= 10;
           nod++;
       }
       
       return nod;
   }
    
}