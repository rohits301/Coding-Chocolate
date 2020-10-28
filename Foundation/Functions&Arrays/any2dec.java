import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int b = scn.nextInt();
      int d = getValueIndecimal(n, b);
      System.out.println(d);
   }
  
   public static int getValueIndecimal(int n, int b){
      // write your code here
      int res = 0;
      
      int temp = n;
      int pow = 1;
      
      while(temp != 0) {
          int q = temp / 10;
          int r = temp % 10;
          
          res += r*pow;
          
          pow*=b;
          temp = q;
      }
      
      return res;
   }
  }