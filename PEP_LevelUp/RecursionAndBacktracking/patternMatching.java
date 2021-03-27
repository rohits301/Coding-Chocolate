import java.io.*;
import java.util.*;

//?: the above code fails for "dog dog dog dog" map to "abba", WHY??

public class Main {

    static boolean flag = true;

    public static void solution(String str, String pattern, HashMap<Character, String> map, String op) {
        // write your code here

        if (pattern.length() == 0) {
            if (str.length() == 0) {
                HashSet<Character> alreadyPrinted = new HashSet<>();

                for (int i = 0; i < op.length(); i++) {
                    char ch = op.charAt(i);
                    if (!alreadyPrinted.contains(ch)) {
                        System.out.print(ch + " -> " + map.get(ch) + ", ");
                        alreadyPrinted.add(ch);
                    }

                }
                System.out.println(".");
            }
            return;
        }

        char ch = pattern.charAt(0);
        String rop = pattern.substring(1);

        if (map.containsKey(ch)) {
            String previousMapping = map.get(ch);

            if (str.length() >= previousMapping.length()) {

                String leftHalf = str.substring(0, previousMapping.length()); // mapped part
                String rightHalf = str.substring(previousMapping.length()); // unmapped part

                if (previousMapping.equals(leftHalf)) {
                    solution(rightHalf, rop, map, op);
                } else {
                    flag = false;
                    return;
                }
            }

        } else {
            for (int i = 0; i < str.length(); i++) {
                String leftHalf = str.substring(0, i + 1);
                String rightHalf = str.substring(i + 1);

                map.put(ch, leftHalf);
                solution(rightHalf, rop, map, op);
                map.remove(ch);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        String pattern = scn.next();
        HashMap<Character, String> map = new HashMap<>();
        solution(str, pattern, map, pattern);

        // if(flag == false){
        // System.out.println(false);
        // }
    }
}