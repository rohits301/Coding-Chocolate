import java.util.*;

public class Main{

public static void main(String[] args) {
  // write your code here  
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    inverse(n);
 }
 
 public static void inverse(int n){
     int inv = 0;
     int temp = n;
     int pos = 1;
     
     while(temp!=0){
         int dig = temp % 10;
         
         inv = inv + (pos * (int)Math.pow(10, dig - 1));
         
         pos++;
         temp /= 10;
     }
     
     System.out.println(inv);
 }
}