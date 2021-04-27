import java.io.*;
import java.util.*;

public class Main {
    private static void kLengthWords2(String ustr, int currentSpot, int totalSpots, HashSet<Character> used, String asf){
        
        if(currentSpot == totalSpots){
            System.out.println(asf);
            return;
        }

        for(int i = 0; i < ustr.length(); i++){
            char ch = ustr.charAt(i);
            if(!used.contains(ch)){
                used.add(ch);
                kLengthWords2(ustr, currentSpot + 1, totalSpots, used, asf + ch);
                used.remove(ch);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int k = Integer.parseInt(br.readLine());

        HashSet<Character> unique = new HashSet<>();
        String ustr = "";
        for (char ch : str.toCharArray()) {
            if (unique.contains(ch) == false) {
                unique.add(ch);
                ustr += ch;
            }
        }

        kLengthWords2(ustr, 0, k, new HashSet<Character>(), "");
    }

}