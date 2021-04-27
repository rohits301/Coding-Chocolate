import java.io.*;
import java.util.*;

public class Main {

    private static void kLengthWords1(String ustr, int currentIndex, int selectionSoFar, int totalSelections,
            Character[] spots) {

        if (currentIndex == ustr.length()) {
            if (selectionSoFar == totalSelections) {
                for (char val : spots) {
                    System.out.print(val);
                }
                System.out.println();
            }
            return;
        }

        char ch = ustr.charAt(currentIndex);
        // yes.
        for (int i = 0; i < spots.length; i++) {
            if (spots[i] == null) {
                spots[i] = ch;
                kLengthWords1(ustr, currentIndex + 1, selectionSoFar + 1, totalSelections, spots);
                spots[i] = null;
            }
        }

        // no.
        kLengthWords1(ustr, currentIndex + 1, selectionSoFar, totalSelections, spots);

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

        kLengthWords1(ustr, 0, 0, k, new Character[k]);
    }
}