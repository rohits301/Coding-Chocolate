import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        
        int ans = countABC(str);
        System.out.println(ans);
    }
    private static int countABC(String str){
        
        int countA = 0;
        int countAB = 0;
        int countABC = 0;
        
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            
            if(ch == 'a'){
                countA = 2 * countA + 1;
            } else if(ch == 'b'){
                countAB = 2 * countAB + countA;
            } else {
                countABC = 2 * countABC + countAB;
            }
        }
        return countABC;
    }
}