import java.io.*;
import java.util.*;

public class Main {

    public static void generatepw(int currChar, int totalLengthForRecursionCall, HashMap<Character, Integer> fmap,
            Character oddc, String asf) {

        if (currChar > totalLengthForRecursionCall) {
            StringBuilder sb = new StringBuilder(asf);

            System.out.println(asf + (oddc == null ? "" : oddc) + (sb.reverse()).toString());
            return;
        }

        for (Character ch : fmap.keySet()) {
            int freq = fmap.get(ch);
            if (freq > 0) {
                fmap.put(ch, freq - 1);
                generatepw(currChar + 1, totalLengthForRecursionCall, fmap, oddc, asf + ch);
                fmap.put(ch, fmap.get(ch) + 1); // put with current frequency + 1
            }
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        HashMap<Character, Integer> fmap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            fmap.put(ch, fmap.getOrDefault(ch, 0) + 1);
        }

        // write your code here

        Character oddc = null;
        int odds = 0;

        int totalLengthForRecursionCall = 0;

        for (Character ch : fmap.keySet()) { // ch is key
            int freq = fmap.get(ch);

            if (freq % 2 == 1) {
                oddc = ch;
                odds++;
            }

            fmap.put(ch, freq / 2);
            totalLengthForRecursionCall += freq / 2;
        }

        if (odds > 1) {
            System.out.println(-1);
            return;
        }

        generatepw(1, totalLengthForRecursionCall, fmap, oddc, "");
    }

}