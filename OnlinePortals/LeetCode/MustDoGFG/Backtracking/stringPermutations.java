
class Solution {
    // T: O(n! * n), S: O(1)????
    public ArrayList<String> permutation(String S) {
        // Your code here
        ArrayList<String> ans = new ArrayList<>();

        // Sorting string -> only for GFG test cases
        char tempArray[] = S.toCharArray();
        // Sorting temp array using
        Arrays.sort(tempArray);
        // Returning new sorted string
        String str = new String(tempArray);

        solve(str, ans, "");
        return ans;
    }

    void solve(String str, ArrayList<String> ans, String asf) {
        if (str.length() == 0) {
            ans.add(asf);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            String lpart = str.substring(0, i);
            String rpart = str.substring(i + 1);

            String roq = lpart + rpart;

            solve(roq, ans, asf + ch);
        }
    }

}