class Solution {
    // T: O(4^n) -> vaise 3 options but in 2 cases, 4 options at every level
    // S: O(3^n) -> each number corresp. to string of length 3
    public List<String> letterCombinations(String digits) {

        if (digits.length() == 0) {
            return new ArrayList<String>();
        }

        String[] mapping = new String[] { ".", ".", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

        List<String> ans = solve(digits, mapping, 0);
        return ans;
    }

    List<String> solve(String digits, String[] mapping, int i) {

        if (i == digits.length()) {
            List<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        List<String> res = solve(digits, mapping, i + 1);

        List<String> myres = new ArrayList<>();

        // get corresp. string for number
        String str = mapping[digits.charAt(i) - '0'];

        for (int idx = 0; idx < str.length(); idx++) {
            char ch = str.charAt(idx);

            for (String s : res) {
                myres.add(ch + s);
            }
        }

        return myres;
    }
}