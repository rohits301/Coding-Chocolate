class Solution {
    public String minWindow(String s, String t) {

        // s1 => s
        // s2 => t
        String ans = "";
        HashMap<Character, Integer> map2 = new HashMap<>();

        // frequency map for t
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        }

        int matchCount = 0;
        int desiredMatchCount = t.length();
        int i = -1; // index acquired till now
        int j = -1; // index released till now

        // freq. map for ans
        HashMap<Character, Integer> map1 = new HashMap<>();

        while (true) {
            boolean f1 = false;
            boolean f2 = false;

            // acquire
            while (i < s.length() - 1 && matchCount < desiredMatchCount) {
                i++;
                char ch = s.charAt(i);
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
                String temp = s.substring(j + 1, i + 1);

                if (ans.length() == 0 || temp.length() < ans.length()) {
                    ans = temp; // smallest till now
                }

                // release
                j++;
                char ch = s.charAt(j);
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
}