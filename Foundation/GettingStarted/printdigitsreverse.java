import java.util.*;
   
   public class Main{
   
   public static void main(String[] args) {
     // write your code here  
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        
        printdigsrev(n);
    }
    
    public static void printdigsrev(int n){
        int temp = n;
        
        while(temp!=0){
            int r = temp%10;
            System.out.println(r);
            temp/=10;
        }
    }
   }