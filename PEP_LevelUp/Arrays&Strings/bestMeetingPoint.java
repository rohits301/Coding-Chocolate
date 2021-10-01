import java.util.*;

public class Main {

    // ~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~
    // T: O(n^2), S: O(n), n= grid.length, locked on LeetCode
    public static int minTotalDistance(int[][] grid) {
        // Write your code here
        // 1. Get x-coordinate -> row wise
        ArrayList<Integer> xcord = new ArrayList<>();

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    xcord.add(r);
                }
            }
        }

        // 2. Get y-coordinate -> col wise
        ArrayList<Integer> ycord = new ArrayList<>();

        for (int c = 0; c < grid[0].length; c++) {
            for (int r = 0; r < grid.length; r++) {
                if (grid[r][c] == 1) {
                    ycord.add(c);
                }
            }
        }
        // 3. Get mid -> best meeting point
        int midx = xcord.get(xcord.size() / 2);
        int midy = ycord.get(ycord.size() / 2);

        // 4. Calculate distance -> min distance (because of median)
        int dist = 0;
        for (int xval : xcord) {
            dist += Math.abs(midx - xval);
        }
        for (int yval : ycord) {
            dist += Math.abs(midy - yval);
        }

        // 5. return ans
        return dist;
    }

    // ~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        int[][] grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = scn.nextInt();
            }
        }

        int dist = minTotalDistance(grid);
        System.out.println(dist);
    }
}