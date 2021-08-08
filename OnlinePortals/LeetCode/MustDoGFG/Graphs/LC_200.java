class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1' && vis[i][j] == false){
                    gcc(grid, vis, i, j);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    void gcc(char[][] grid, boolean[][] vis, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || 
           grid[i][j] == '0' || vis[i][j] == true){
            return;
        }
        
        vis[i][j] = true;
        
        gcc(grid, vis, i - 1, j);
        gcc(grid, vis, i, j + 1);
        gcc(grid, vis, i + 1, j);
        gcc(grid, vis, i, j - 1);
    }
}