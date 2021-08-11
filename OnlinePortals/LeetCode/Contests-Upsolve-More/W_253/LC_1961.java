class Solution {
    public boolean isPrefixString(String s, String[] words) {
        int n = s.length();

        boolean flag = false;
        int len = 0;
        int count = 0;

        for (int i = 0; i < words.length; i++) {
            len += words[i].length();
            count++;
            if (len == n) {
                flag = true;
                break;
            }
        }

        if (flag == true) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < words.length && i < count; i++) {
                sb.append(words[i]);
            }

            String str = sb.toString();
            if (str.equals(s)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}