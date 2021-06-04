//User function Template for Java

/*
    Note: Use StringBuilder/StringBuffer class for String concatenation(if any).
    While using String class, on each concatenation a new copy of the string is created, so that 
    the overall complexity is O(n^2) . Fortunately in Java we could solve this with a StringBuffer/StringBuffer, 
    which has O(1) complexity for each append.
*/

class Solution {
    static class Pair {
        char ch;
        int count;

        Pair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }

    public static String reduced_String(int k, String s) {
        if (k == 1) {
            return "";
        }

        Stack<Pair> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (st.isEmpty()) {
                st.push(new Pair(c, 1));
            } else {
                if (c == st.peek().ch) {

                    int freq = st.peek().count + 1;
                    st.push(new Pair(c, freq));

                    if (st.peek().count == k) {
                        int temp = k;
                        while (temp-- > 0) {
                            st.pop();
                        }
                    }
                } else {
                    st.push(new Pair(c, 1));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            char c = st.pop().ch;
            sb.append(c);
        }

        return sb.reverse().toString();
    }
}