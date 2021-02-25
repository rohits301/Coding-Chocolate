import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vtces = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList<>();
        }

        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }

        // write your code here

        int[] visited = new int[vtces];
        Arrays.fill(visited, -1); // eqv. to boolean false

        boolean isCompBipartite = false;
        for (int i = 0; i < vtces; i++) {
            if (visited[i] == -1) {
                isCompBipartite = compBipartite(graph, i, visited);
                if (isCompBipartite == false) {
                    break;
                }
            }
        }
        System.out.println(isCompBipartite);
    }

    static class Pair {
        int v;
        String psf;
        int level;

        Pair(int v, String psf, int level) {
            this.v = v;
            this.psf = psf;
            this.level = level;
        }
    }

    private static boolean compBipartite(ArrayList<Edge>[] graph, int src, int[] visited) {

        ArrayDeque<Pair> que = new ArrayDeque<>();

        que.add(new Pair(src, src + "", 0));

        // r m* w a*

        while (que.size() > 0) {
            Pair rpair = que.remove();

            if (visited[rpair.v] != -1) { // has been visited before
                int currLevel = rpair.level;
                int previousLevel = visited[rpair.v];

                if (currLevel != previousLevel) {
                    return false; // odd-length-cycle, not bipartite
                } else {
                    continue;
                }

                // currLevel != previousLevel? return false : continue;, cannot write this,
                // illegal expression

            } else {
                visited[rpair.v] = rpair.level;
            }

            for (Edge e : graph[rpair.v]) {
                if (visited[e.nbr] == -1) {
                    que.add(new Pair(e.nbr, rpair.psf + e.nbr, rpair.level + 1));
                }
            }
        }
        return true;
    }

}