import java.io.*;
import java.util.*;

public class Main {

    private static void wordsKSelection1(char[] charray, int currentBox, int totalBoxes, int selectionSoFar,
            int totalSelections, String asf) {
            
            if(currentBox == totalBoxes){
                if(selectionSoFar == totalSelections){
                    System.out.println(asf);
                }
                return;
            }
            
            wordsKSelection1(charray, currentBox + 1, totalBoxes, selectionSoFar + 1, totalSelections, asf + charray[currentBox]); // yes.
            wordsKSelection1(charray, currentBox + 1, totalBoxes, selectionSoFar, totalSelections, asf); // no.
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        String str = scn.nextLine();
        int k = Integer.parseInt(scn.nextLine());

        HashSet<Character> hs = new HashSet<>();

        for (char ch : str.toCharArray()) {
            hs.add(ch);
        }
        // System.out.println(hs);

        char[] charray = new char[hs.size()];
        int i = 0;
        for (Character ele : hs) {
            charray[i] = ele;
            i++;
        }
        wordsKSelection1(charray, 0, charray.length, 0, k, "");
    }

}