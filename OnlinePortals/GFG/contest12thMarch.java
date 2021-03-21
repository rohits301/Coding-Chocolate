/****************** VIRUS INFECTION *************/

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
    int count = 0;

    int virusInfection(String s, int K) {
        // code here
        boolean[] visited = new boolean[s.length()];
        count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1' && visited[i] == false) {
                visited[i] = true;
                count += 1;
                infect(s, i, K, visited);
            }
        }
        return count;
    }

    void infect(String s, int oidx, int k, boolean[] visited) {

        // left
        for (int i = 1; i <= k; i++) {
            int idx = oidx - i;
            if (idx >= 0 && idx < s.length() && s.charAt(idx) == '0' && visited[idx] == false) {
                visited[idx] = true;
                count += 1;
            }
        }

        // right

        for (int i = 1; i <= k; i++) {
            int idx = oidx + i;
            if (idx >= 0 && idx < s.length() && s.charAt(idx) == '0' && visited[idx] == false) {
                visited[idx] = true;
                count += 1;
            }
        }
    }
}

// CORRECT SOLUTION
// HINT 1 : Use the concept of multi-source breadth first search.
//Java
class Pair {
    public int first, second;
    Pair(int x, int y) {
        first = x;
        second = y;
    }
}
class Solution {
    int virusInfection(String s, int K) {
        int n = s.length();
        boolean vis[] = new boolean[n + 1];
        Arrays.fill(vis, false);
        Deque < Pair > q = new LinkedList < Pair > ();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                q.addLast(new Pair(i, 0));
                vis[i] = true;
                ans++;
            }
        }
        while (q.size() > 0) {
            Pair f = q.getFirst();
            q.removeFirst();
            if (f.second < K) {
                if (f.first - 1 >= 0) {
                    if (vis[f.first - 1] == false) {
                        q.addLast(new Pair(f.first - 1, f.second + 1));
                        vis[f.first - 1] = true;
                        ans++;
                    }
                }
                if (f.first + 1 < n) {
                    if (vis[f.first + 1] == false) {
                        q.addLast(new Pair(f.first + 1, f.second + 1));
                        vis[f.first + 1] = true;
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}

/****************** Count Configurations *************/
// HINT 1 : Try using Dynamic Programming to solve the problem.
// HINT 2 : Convert the circle into a line, 
// and fix the configuration of first person to find out total configurations of the last person

class Solution {
    public int countConfigurations(String S) {
        S += S.charAt(0);

        int n = S.length();
        long total = 0;
        int mod = 1000000007;
        for (int k = 0; k < 2; k++) {

            long dp[][] = new long[n][2];
            for (int i = 0; i < n; i++)
                Arrays.fill(dp[i], 0);
            dp[0][k] = 1;
            for (int i = 1; i < n; i++) {
                if (S.charAt(i) == 'R') {
                    if (S.charAt(i - 1) == 'L') {
                        dp[i][0] = dp[i - 1][1];
                    }
                } else {
                    dp[i][0] = dp[i - 1][0];
                }

                if (S.charAt(i - 1) == 'L') {
                    dp[i][1] = dp[i - 1][0];
                } else {
                    dp[i][1] = (dp[i - 1][1] + dp[i - 1][0]) % mod;
                }

            }
            total = (total + dp[n - 1][k]) % mod;
        }

        return (int) total;
    }
}

/****************** Most and Least Tasty *************/
// HINT 1 : It is necessary to include all the chocolates in one partition or another, 
// There will be a partition starting at 0 and one partition ending at N-1 position.
class Solution {
    public long diffInTaste(int N, int K, int Arr[]) {
        long max, min;
        max = min = Arr[0] + Arr[N - 1];
        PriorityQueue < Integer > q1 = new PriorityQueue < Integer > ();
        PriorityQueue < Integer > q2 = new PriorityQueue < Integer > ();

        for (int i = 0; i < N - 1; i++) {
            q1.add(-(Arr[i] + Arr[i + 1]));
            q2.add(Arr[i] + Arr[i + 1]);
        }
        for (int i = 0; i < K - 1; i++) {
            max -= q1.poll();
            min += q2.poll();
        }
        return max - min;
    }
}

/****************** Label Tree *************/

class Solution {
    ArrayList < Integer > treeHelper(ArrayList < ArrayList < Integer >> al, int currIdx) {
        ArrayList < Integer > ans = new ArrayList < Integer > ();
        ArrayList < Integer > temp;

        if (al.get(currIdx).size() == 0) {
            ans.add(currIdx);
            return ans;
        }

        for (int i = 0; i < al.get(currIdx).size(); i++) {
            // call
            temp = treeHelper(al, al.get(currIdx).get(i));

            for (int j = 0; j < temp.size(); j++)
                ans.add(temp.get(j));
        }

        ans.add(ans.size() / 2, currIdx);

        return ans;
    }
    ArrayList < Integer > labelTree(int N, int p[]) {
        ArrayList < ArrayList < Integer >> al = new ArrayList < ArrayList < Integer >> ();
        for (int i = 0; i < N; i++) {
            al.add(new ArrayList < Integer > ());
        }
        for (int i = 1; i < N; i++) {
            al.get(p[i]).add(i);
        }

        ArrayList < Integer > temp = treeHelper(al, 0);
        ArrayList < Integer > res = new ArrayList < > ();

        for (int i = 0; i < N; i++)
            res.add(0);
        for (int i = 0; i < N; i++) {
            int idx = temp.get(i);
            res.set(idx, i + 1);
        }
        return res;
    }
}

/****************** Odd Triplets *************/
// HINT 1 : Iterate all possible j then try to count the triplets.
//Java          X ≤ j - i and X ≤ k - j
class Solution {
    long countTriplet(int N, int A[], int X) {
        long ans = 0, p = 0, q = 0;
        for (int k = X; k < N; k++) {
            if (A[k] % 2 == 1)
                q++;
        }

        for (int j = 0; j < N; j++) {

            if (j - X >= 0 && A[j - X] % 2 == 1)
                p++;

            if (A[j] % 2 == 1)
                ans += p * q;

            if (j + X < N && A[j + X] % 2 == 1)
                q--;
        }
        return ans;
    }
}