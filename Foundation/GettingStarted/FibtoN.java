import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
      // write your code here
      Scanner s = new Scanner(System.in);
      int n = s.nextInt();
      printFib(n);
   }
  
  public static void printFib(int n){
      int f1 = 0;
      int f2 = 1;
      System.out.println(f1);
      System.out.println(f2);
      
      int count = 2;
      
      while(count < n){ //at c=9, enter loop, 10th fib printed
          int f3 = f1 + f2;
          System.out.println(f3);
          f1 = f2;
          f2 = f3;
          count++;
      }
  }
  
  }