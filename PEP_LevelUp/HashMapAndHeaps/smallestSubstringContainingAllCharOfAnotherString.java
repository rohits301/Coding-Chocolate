import java.util.*;

public class Main {

    public static String solution(String s1, String s2) {
        // write your code here

        String ans = "";
        HashMap<Character, Integer> map2 = new HashMap<>();

        // frequency map for s2
        for (int i = 0; i < s2.length(); i++) {
            char ch = s2.charAt(i);
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        }

        int matchCount = 0;
        int desiredMatchCount = s2.length();
        int i = -1; // index acquired till now
        int j = -1; // index released till now

        // freq. map for ans
        HashMap<Character, Integer> map1 = new HashMap<>();

        while (true) {
            boolean f1 = false;
            boolean f2 = false;

            // acquire
            while (i < s1.length() - 1 && matchCount < desiredMatchCount) {
                i++;
                char ch = s1.charAt(i);
                map1.put(ch, map1.getOrDefault(ch, 0) + 1);

                // if freq. after acquiring ch <= required
                // then inc. count
                if (map1.get(ch) <= map2.getOrDefault(ch, 0)) {
                    matchCount++;
                }
                f1 = true;
            }

            // release and build ans
            while (j < i && matchCount == desiredMatchCount) {
                String temp = s1.substring(j + 1, i + 1);

                if (ans.length() == 0 || temp.length() < ans.length()) {
                    ans = temp; // smallest till now
                }

                // release
                j++;
                char ch = s1.charAt(j);
                if (map1.get(ch) == 1) {
                    map1.remove(ch);
                } else {
                    map1.put(ch, map1.get(ch) - 1);
                }

                // if useful character is released
                // dec. the match count
                if (map1.getOrDefault(ch, 0) < map2.getOrDefault(ch, 0)) {
                    matchCount--;
                }

                f2 = true;
            }

            // if no loop has been visited, then break
            if (f1 == false && f2 == false) {
                break;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.next();
        String s2 = scn.next();
        System.out.println(solution(s1, s2));
    }

}
