import java.util.*;

public class Main{
    public static void main(String[] args) {
        // write your code here
        Scanner s = new Scanner(System.in);
        int n1 = s.nextInt();
        int n2 = s.nextInt();
        
        primesToN(n1,n2);
        
    }
    
    public static void primesToN(int n1, int n2){
        for(int i=n1; i<=n2; i++){  //O(no of nums n1 to n2)
            if(isprime(i)){     //O(sqrt i)
                System.out.println(i);
            }
        }
    }
    
    public static boolean isprime(int n){ //O(sqroot n)
        for(int i=2; i*i <= n; i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}