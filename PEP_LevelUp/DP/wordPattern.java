import java.util.*;

public class Main {

    public static boolean wordPattern(String pattern, String str) {
        // write your code here

        String[] words = str.split(" ");

        HashMap<Character, String> map = new HashMap<>();
        HashMap<String, Boolean> mark = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);

            if (map.containsKey(ch) == false) {

                if (mark.containsKey(words[i]) == true) {
                    return false;
                } else {
                    mark.put(words[i], true);
                    map.put(ch, words[i]);
                }
            } else {
                String prevMapping = map.get(ch);
                if (prevMapping.equals(words[i]) == false) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String pattern = scn.nextLine();
        String words = scn.nextLine();
        System.out.println(wordPattern(pattern, words));
    }

}
