class Solution {
    // T: O(8^(m*n)), S: O(m*n)
    // The code below return strings in lexicographical order for an unexplained reason
    // If multiple occurences of a word exist in the board, the below code will print all
    // TechDose and Gfg-24mins for reference
    public String[] wordBoggle(char board[][], String[] dictionary) {
        // Write your code here

        ArrayList<String> ans = new ArrayList<>();

        for (String word : dictionary) {
            if (doesExist(board, word)) {
                ans.add(word);
            }
        }

        return ans.toArray(new String[ans.size()]); // nai cheez, convt to String[]
    }

    private boolean doesExist(char board[][], String word) {

        int m = board.length;
        int n = board[0].length;
        boolean[][] vis = new boolean[m][n];

        int idx = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, vis, i, j, idx)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char board[][], String word, boolean[][] vis,
        int r, int c, int idx) {

        if (idx == word.length()) {
            return true;
        }

        if (r >= 0 && r < board.length && c >= 0 && c < board[0].length &&
            vis[r][c] == false && board[r][c] == word.charAt(idx)) {

            vis[r][c] = true;
            // 8-dir
            if (dfs(board, word, vis, r - 1, c, idx + 1) ||
                dfs(board, word, vis, r - 1, c + 1, idx + 1) ||
                dfs(board, word, vis, r, c + 1, idx + 1) ||
                dfs(board, word, vis, r + 1, c + 1, idx + 1) ||
                dfs(board, word, vis, r + 1, c, idx + 1) ||
                dfs(board, word, vis, r + 1, c - 1, idx + 1) ||
                dfs(board, word, vis, r, c - 1, idx + 1) ||
                dfs(board, word, vis, r - 1, c - 1, idx + 1)) {

                return true;
            }

            vis[r][c] = false;
        }

        return false;
    }
}