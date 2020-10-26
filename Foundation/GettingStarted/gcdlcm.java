import java.util.*;
    
    public class Main{
    
    public static void main(String[] args) {
      // write your code here 
      Scanner s = new Scanner(System.in);
      int n1 = s.nextInt();
      int n2 = s.nextInt();
      
      gcd(n1,n2);
     }
     
     public static void gcd(int n1, int n2){
         int divd = n1, divs = n2; //doesn't matter who's bigger
         int rem = -1;
         while(rem != 0){
             rem = divd % divs;
             
             divd = divs;
             divs = rem;
         }
         
         int gcd = divd; //now the item in divd is reqd gcd. 
                      //divs is set to 0 bec rem=0 pe loop break
                      
         int lcm = (n1*n2)/gcd; 
         
         System.out.println(gcd);
         System.out.println(lcm);
     }
    }