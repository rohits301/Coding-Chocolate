class Solution {
    // T: O(n!) and S: O(n^2)
    static ArrayList<ArrayList<Integer>> al;

    static ArrayList<ArrayList<Integer>> nQueen(int n) {
        // code here

        boolean[][] grid = new boolean[n][n];

        boolean[] cols = new boolean[n];
        boolean[] normalDiag = new boolean[2 * n - 1];
        boolean[] otherDiag = new boolean[2 * n - 1];

        al = new ArrayList<>(); // could keep ans arrayList as static globl
        // else could also pass in nqueensHelper()

        ArrayList<Integer> list = new ArrayList<>();
        nQueensHelper(grid, 0, cols, normalDiag, otherDiag, list);

        return al;
    }

    // USING BRANCH N BOUND
    static void nQueensHelper(boolean[][] grid, int row, boolean[] cols,
            boolean[] nd, boolean[] od, ArrayList<Integer> list) {

        if (row == grid.length) {

            al.add(new ArrayList<>(list));
            // this is IMPORTANT
            // since the ArrayList "list" will be changing in every call
            // hence we create its copy and add to ArrayList
            return;
        }

        for (int col = 0; col < grid[0].length; col++) {

            if (grid[row][col] == false &&
                cols[col] == false &&
                nd[row + col] == false &&
                od[row - col + grid.length - 1] == false) {

                grid[row][col] = true;
                cols[col] = true;
                nd[row + col] = true;
                od[row - col + grid.length - 1] = true;
                list.add(col + 1); // acc. to ques, we want col+1

                nQueensHelper(grid, row + 1, cols, nd, od, list);

                grid[row][col] = false;
                cols[col] = false;
                nd[row + col] = false;
                od[row - col + grid.length - 1] = false;
                list.remove(list.size() - 1); // * remove the last value
                // since backtracking is from end
            }
        }
    }
}