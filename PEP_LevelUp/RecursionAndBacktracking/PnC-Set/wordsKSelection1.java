import java.io.*;
import java.util.*;

public class Main {

    private static void wordsKSelection1(String str, int currentBox, int totalBoxes, int selectionSoFar,
            int totalSelections, String asf) {

        if (currentBox == str.length()) {
            if (selectionSoFar == totalSelections) {
                System.out.println(asf);
            }
            return;
        }

        char ch = str.charAt(currentBox);

        wordsKSelection1(str, currentBox + 1, totalBoxes, selectionSoFar + 1, totalSelections, asf + ch); // yes.
        wordsKSelection1(str, currentBox + 1, totalBoxes, selectionSoFar, totalSelections, asf); // no.
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        String str = scn.nextLine();
        int k = Integer.parseInt(scn.nextLine());

        HashSet<Character> hs = new HashSet<>();

        StringBuilder sb = new StringBuilder();
        for (char ch : str.toCharArray()) {
            if (!hs.contains(ch)) {
                hs.add(ch);
                sb.append(ch);
            }
        }
        // System.out.println(hs);

        // * Array method gives answer but the string is different
        // * i.e. the order is different hence, better to use String

        /*
         * char[] charray = new char[hs.size()]; 
         * int i = 0; 
         * for (Character ele : hs) {
         *  charray[i] = ele; i++; 
         * }
         */
        wordsKSelection1(sb.toString(), 0, sb.length(), 0, k, "");
    }

}