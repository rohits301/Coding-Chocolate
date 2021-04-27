import java.io.*;
import java.util.*;

public class Main {

    private static void wordsKSelection2(String s, int currentSelection, int totalSelections, int lastLevelBox,
            String asf) {

        if (currentSelection > totalSelections) {
            System.out.println(asf);
            return;
        }

        for (int b = lastLevelBox + 1; b < s.length(); b++) {
            wordsKSelection2(s, currentSelection + 1, totalSelections, b, asf + s.charAt(b));
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        String str = scn.nextLine();
        int k = Integer.parseInt(scn.nextLine());

        HashSet<Character> hs = new HashSet<>();

        StringBuilder sb = new StringBuilder();
        for (char ch : str.toCharArray()) {
            if (hs.contains(ch) == false) {
                hs.add(ch);
                sb.append(ch);
            }
        }
        // System.out.println(hs);

        wordsKSelection2(sb.toString(), 1, k, -1, "");
    }

}