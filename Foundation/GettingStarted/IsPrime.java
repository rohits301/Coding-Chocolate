import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
  
       // write ur code here
       int t = scn.nextInt();
       
       while(t-- > 0){
            int n = scn.nextInt();
            boolean isp = isprime(n);
            if(isp){
                System.out.println("prime");
            }else{
                System.out.println("not prime");
            }
       }
       
   }
   
   public static boolean isprime(int n){
       boolean isp = false;
       
       for(int i=2; i<=Math.sqrt(n); i++){
           if(n%i==0){
               return false;
           }
       }
       return true;
   }
  }