import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        String str = s.next();
        
        System.out.println(getKPC(str));
    }

    public static ArrayList<String> getKPC(String str) {
        if(str.length() == 0) {
            ArrayList<String> baseresult = new ArrayList<>();
            baseresult.add("");
            return baseresult;
        }
        
        char ch = str.charAt(0);
        String ros = str.substring(1);
        
        String code = getcode(ch-'0');  //imp: subtract '0'! change to int else ascii passed to array idx and out of bounds exception
        
        ArrayList<String> recresult = getKPC(ros);
        ArrayList<String> myresult = new ArrayList<>();
        
        for(int i=0; i < code.length(); i++){   //loop order changed(i.e. first code loop then arrlist) to match output)
            char c = code.charAt(i);
            for(int j=0; j < recresult.size(); j++){
                String recstr = recresult.get(j);
                myresult.add(c + recstr);
            }
        }
        
        return myresult;
        
    }
    
    public static String getcode(int ch){
        String[] codes = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};
        return codes[ch];
    }

}