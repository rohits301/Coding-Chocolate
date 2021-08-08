
class Solution {
    public int helpaterp(int[][] arr) {
        // code here

        // BFS -> r m* w a*

        boolean[][] vis = new boolean[arr.length][arr[0].length];

        Queue<CPair> q = new LinkedList<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 2) {
                    q.add(new CPair(i, j, 0));
                }
                if (arr[i][j] == 0) {
                    vis[i][j] = true;
                    ;
                }
            }
        }

        int time = 0;

        int[] xdir = { -1, 0, 1, 0 };
        int[] ydir = { 0, 1, 0, -1 };

        while (q.size() > 0) {
            CPair rp = q.remove();

            if (vis[rp.i][rp.j]) {
                continue;
            }
            // System.out.println(rp);
            vis[rp.i][rp.j] = true;

            time = rp.t; // w

            for (int d = 0; d < 4; d++) {
                int x = rp.i + xdir[d];
                int y = rp.j + ydir[d];
                // System.out.println(x + "-" + y);

                if (x < 0 || y < 0 || x >= arr.length || y >= arr[0].length || vis[x][y] == true) {
                    continue;
                }

                q.add(new CPair(x, y, rp.t + 1));
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (vis[i][j] == false) {
                    return -1;
                }
            }
        }

        return time;
    }

    class CPair {
        int i;
        int j;
        int t;

        CPair(int i, int j, int t) {
            this.i = i;
            this.j = j;
            this.t = t;
        }

        public String toString() {
            return "x = " + this.i + ", y = " + this.j + ", t = " + this.t;
        }
    }
}