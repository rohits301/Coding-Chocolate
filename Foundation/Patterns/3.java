import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n = scn.nextInt();
        
        int nsp = n-1;    //no of spaces
        int j=0;
        
        for(int i=0; i<n; i++){
            j=0;
            while(j<nsp){
                System.out.print("	");
                j++;
            }
            nsp--;
            while(j<n){
                System.out.print("*	");
                j++;
            }
            
            System.out.println();
        }

    }
}