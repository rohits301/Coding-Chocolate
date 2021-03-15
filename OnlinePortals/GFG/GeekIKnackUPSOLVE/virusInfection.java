
// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String S = read.readLine().trim();
            int K = Integer.parseInt(read.readLine().trim());

            Solution ob = new Solution();
            int ans = ob.virusInfection(S, K);
            System.out.println(ans);
        }
    }
} // } Driver Code Ends

// User function Template for Java
class Solution {
    class Pair {
        int idx; // idx of 1
        int roi; // reach of infection

        Pair(int idx, int roi) {
            this.idx = idx;
            this.roi = roi;
        }
    }

    int virusInfection(String s, int K) {
        // code here
        ArrayDeque<Pair> que = new ArrayDeque<>();
        boolean[] visited = new boolean[s.length()];

        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                que.add(new Pair(i, 0));
            }
        }

        while (que.size() > 0) {
            // r m* w a*

            Pair rpair = que.remove();

            if (visited[rpair.idx] == true) {
                continue;
            }
            visited[rpair.idx] = true;

            ans++;
            // System.out.println(rpair.idx + " with roi as " + rpair.roi);

            if (rpair.roi < K) {
                int newIdx = rpair.idx - 1;
                int newROI = rpair.roi + 1;

                if (newIdx >= 0 && visited[newIdx] == false) {
                    que.add(new Pair(newIdx, newROI));
                }

                newIdx = rpair.idx + 1;
                if (newIdx < s.length() && visited[newIdx] == false) {
                    que.add(new Pair(newIdx, newROI));
                }
            }
        }
        return ans;
    }
}