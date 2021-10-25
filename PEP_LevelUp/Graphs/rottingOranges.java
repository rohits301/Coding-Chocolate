import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] st = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        int m = Integer.parseInt(st[1]);

        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st[j]);
            }
        }

        System.out.println(orangesRotting(arr));

    }

    public static class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }

    }

    // T: O(m*n), S: O(1), passed LC.994
    public static int orangesRotting(int[][] grid) {
        // BFS

        // 0-empty, 1-fresh, 2-rotten

        int m = grid.length;
        int n = grid[0].length;

        Queue<Pair> que = new LinkedList<>();

        // 1. Add all rotten oranges in the queue initially
        // And count initial fresh oranges

        // 2. grid[i][j] = 0 => true, to mark true, put 0 there

        int fresh = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1) {
                    fresh++;
                } else if (grid[i][j] == 2) {
                    que.add(new Pair(i, j));
                }
            }
        }

        if (fresh == 0)
            return 0; // no fresh orange found

        int[] xdir = { 0, -1, 0, 1 }; // tldr
        int[] ydir = { -1, 0, 1, 0 }; // tldr

        // 3. ALGO(thoda hatke) -> r,m*(maintained in grid), w(level, i.e, time++), a*(4
        // directions, add in range fresh orange corrd.

        int time = -1; // level count intially
        while (que.size() > 0) {

            time++;
            int size = que.size();
            while (size-- > 0) {

                Pair rp = que.remove();

                for (int d = 0; d < 4; d++) {
                    int x = rp.row + xdir[d];
                    int y = rp.col + ydir[d];

                    if (x >= 0 && y >= 0 && x < m && y < n && grid[x][y] == 1) {
                        que.add(new Pair(x, y));
                        grid[x][y] = 0; // like mark true
                        fresh--;
                    }
                }
            }
        }

        if (fresh == 0) {
            return time;
        } else {
            return -1;
        }
    }
}