import java.util.*;
  
  public class Main {
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int sourceBase = scn.nextInt();
      int destBase= scn.nextInt();
      int res = any2any(n, sourceBase, destBase);
      System.out.println(res);
  }   
   
   public static int any2any(int n, int sb, int db){
       //any2dec -> dec2any
       int dec = getValueIndecimal(n,sb);
       int res = getValueInBase(dec, db);
       return res;
   }
   
   public static int getValueIndecimal(int n, int b){
      // write your code here
      int res = 0;
      
      int temp = n;
      int pow = 1;
      
      while(temp != 0) {
          int q = temp / 10; //jisme jana h uss se divide
          int r = temp % 10;
          
          res += r*pow;
          
          pow*=b;
          temp = q;
      }
      
      return res;
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
           tenp*=10; //jiska hai usse power multiply
       }
       
       return res;
   }
  }