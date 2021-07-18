import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
    // write your code here  
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        benjaminbulbs(n);
   }
   
   public static void benjaminbulbs(int n){
       //all perf sqs :O
       for(int i=1; i*i <= n; i++){
           System.out.println(i*i);
       }
   }
  }