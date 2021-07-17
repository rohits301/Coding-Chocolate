
class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        int ans = -1;

        HashMap<Character, Integer> map = new HashMap<>();

        int i = -1;
        int j = -1;

        while (true) {
            boolean f1 = false;
            boolean f2 = false;

            // acquire
            while (i < s.length() - 1) {
                f1 = true;

                i++;
                char ch = s.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);

                if (map.size() < k) {
                    continue;
                } else if (map.size() == k) {
                    int len = i - j; // length of string till now
                    if (ans < len) {
                        ans = len;
                    }
                } else {
                    break;
                }
            }

            // release
            while (j < i) {
                f2 = true;

                j++;
                char ch = s.charAt(j);

                if (map.get(ch) == 1) {
                    map.remove(ch);
                } else {
                    map.put(ch, map.get(ch) - 1);
                }

                if (map.size() > k) {
                    continue;
                } else if (map.size() == k) {
                    int len = i - j; // length of string till now
                    if (ans < len) {
                        ans = len;
                    }
                    break;
                }
            }

            // if none of the loops visited, break from main loop
            if (f1 == false && f2 == false) {
                break;
            }
        }

        return ans;
    }
}