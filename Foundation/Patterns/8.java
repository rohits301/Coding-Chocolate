import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n = scn.nextInt();
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n-i; j++){   //n-i -> impt
                if(j==n-i-1){
                    System.out.println("*	");
                }else{
                    System.out.print("	");
                }
            }
        }

    }
}