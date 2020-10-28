import java.util.*;
  
  public class Main{
  //65784383
  public static void main(String[] args) {
    // write your code here  
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        
        System.out.println(numdigits(n));
   }
   
   public static int numdigits(int n){ //no of digs = no of times it can be div by 10
       int count = 0;
       int temp = n;
       while(temp!=0){
           temp = temp/10;
           count++;
       }
       
       return count;
   }
  }