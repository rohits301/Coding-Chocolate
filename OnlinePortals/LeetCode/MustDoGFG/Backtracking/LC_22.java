class Solution {
    // Backtracking, taking StringBuilder (improved TC)
    // T: O(2^n) - every place has 2 choices,
    // S: O(n)
    // Vid by Aditya Verma - Bohot badiya expln.
    public List<String> generateParenthesis(int n) {

        List<String> ans = new ArrayList<>();
        int open = n, close = n;

        solve(open, close, new StringBuilder(), ans);
        return ans;
    }

    void solve(int open, int close, StringBuilder output, List<String> ans) {

        if (open == 0 && close == 0) {
            ans.add(output.toString());
            return;
        }

        if (open != 0) {
            output.append("(");
            solve(open - 1, close, output, ans);
            output.deleteCharAt(output.length() - 1);
        }

        if (open < close) {
            output.append(")");
            solve(open, close - 1, output, ans);
            output.deleteCharAt(output.length() - 1);
        }

    }
}