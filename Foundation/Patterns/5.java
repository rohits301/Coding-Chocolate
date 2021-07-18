import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n = scn.nextInt();
        
        int nsp = n/2;
        int nst = 1;
        int i=0;
        
        while(i < n/2){
            int j=0;
            while(j < nsp){
                System.out.print("	");
                j++;
            }
            j=0;
            while(j < nst){
                System.out.print("*	");
                j++;
            }
        
            i++;
            nsp--;
            nst += 2;
            System.out.println();
        }
        
        while(i < n){
            int j=0;
            while(j < nsp){
                System.out.print("	");
                j++;
            }
            j=0;
            while(j < nst){
                System.out.print("*	");
                j++;
            }
        
            i++;
            nsp++;
            nst -= 2;
            System.out.println();
        }
    }
}