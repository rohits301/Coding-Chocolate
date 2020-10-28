import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
    // write your code here  
    Scanner s = new Scanner(System.in);
    int a = s.nextInt();
    int b = s.nextInt();
    int c = s.nextInt();
   
    int largest = a;
    if(b > largest){
        largest=b;
    }
    if(c>largest){
        largest=c;
    }
    
    if(largest==a){
        if(b*b + c*c == a*a){ //NOT Math.sqrt
            System.out.println(true);
        }else{
            System.out.println(false);
        }
    }else if(largest==b){
        if(a*a + c*c == b*b){
            System.out.println(true);
        }else{
            System.out.println(false);
        }
    }else{
        if(b*b + a*a == c*c){
            System.out.println(true);
        }else{
            System.out.println(false);
        }
    }
    
  }
  }