import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        String str = s.next();
        
        System.out.println(gss(str));
    }

    public static ArrayList<String> gss(String str) {
        if(str.length() == 0) {
            ArrayList<String> baseresult = new ArrayList<>();
            baseresult.add("");
            return baseresult;
        }
        
        char ch = str.charAt(0);
        String ros = str.substring(1);
        
        ArrayList<String> recresult = gss(ros);
        ArrayList<String> myresult = new ArrayList<>();
        
        /*
        for(int i=0; i < recresult.size(); i++) {
            String recstr = recresult.get(i);
            myresult.add("" + recstr);
            myresult.add(ch + recstr);
        }
        */  //correct code but order differs from expected output
        //so, to match output, run 2 loops. one where blank added to all, other where character added to all recstrs:
        
        for(int i=0; i < recresult.size(); i++) {
            String recstr = recresult.get(i);
            myresult.add("" + recstr);
        }
        
        for(int i=0; i < recresult.size(); i++) {
            String recstr = recresult.get(i);
            myresult.add(ch + recstr);
        }
        
        return myresult;
    }

}