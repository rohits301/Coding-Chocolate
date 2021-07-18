import java.util.*;

public class Main {

    public static void main(String[] args) {
        // Write your code here
        int n = 5;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i==0 || i==n-1){
                    System.out.print("*");
                } else {
                    while(j<n-i-1){
                        System.out.print(" ");
                        j++;
                    }
                    System.out.print("*");
                    break;
                }
            }
            System.out.println();
        }
    }
}