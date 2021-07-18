import java.util.*;

public class Main{

public static void main(String[] args) {
    
  Scanner s = new Scanner(System.in);
  int n = s.nextInt();
  
  primefac(n);
 }
 
 public static void primefac(int n) {
     for(int i=2; i*i < n; i++) {    //bec prime factors
         while(n % i == 0) { //keep dividing if it divides & keep printing the divisor
             n = n / i;
             System.out.print(i + " ");
         }
     }
     
     if(n != 1) { //if the divisor isn't 1 in the end, then its value is the only factor we have left. so print it
         System.out.print(n);
     }
 }
}