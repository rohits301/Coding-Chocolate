import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int b = scn.nextInt();
      int dn = getValueInBase(n, b);
      System.out.println(dn);
   }
  
   public static int getValueInBase(int n, int b){
       // write code here
       int res = 0;
       int temp = n;
       int tenp = 1;
       
       while(temp != 0) {
           int q = temp / b;
           int r = temp % b;
           res += r*tenp;
           
           temp = q;
           tenp*=10;
       }
       
       return res;
   }
  }