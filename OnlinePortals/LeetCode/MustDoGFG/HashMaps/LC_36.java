class Solution {
    // T: O(N^2), S: O(N^2), N = 9 here
    public boolean isValidSudoku(char[][] board) {
        
        HashSet<Character>[] row = new HashSet[9];
        HashSet<Character>[] col = new HashSet[9];
        HashSet<Character>[] subBox = new HashSet[9];
        
        for(int i = 0; i < 9; i++){
            row[i] = new HashSet<Character>();
            col[i] = new HashSet<Character>();
            subBox[i] = new HashSet<Character>();
        }
        
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                char ch = board[i][j];
                
                if(ch == '.'){
                    continue;
                }
                
                int idx = (i/3) * 3 + j / 3;
                
                if(!row[i].add(ch) || 
                   !col[j].add(ch) ||
                   !subBox[idx].add(ch)){
                    return false;
                }
            }
        }
        
        return true;
    }
}