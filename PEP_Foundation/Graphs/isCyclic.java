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

        boolean[] visited = new boolean[vtces];
        boolean cycle = false;

        for (int i = 0; i < vtces; i++) {
            if (visited[i] == false) {
                cycle = isCyclic(graph, i, visited);
                if (cycle == true) {
                    break;
                }
            }
        }
        System.out.println(cycle);
    }

    private static class Pair {
        int v;
        String psf;

        Pair(int v, String psf) {
            this.v = v;
            this.psf = psf;
        }
    }

    public static boolean isCyclic(ArrayList<Edge>[] graph, int src, boolean[] visited) {
        ArrayDeque<Pair> que = new ArrayDeque<Pair>();
        // r m* w a*

        que.add(new Pair(src, src + ""));

        while (que.size() > 0) {
            Pair rpair = que.remove();

            if (visited[rpair.v] == true) {
                return true; // cycle exists
            }
            visited[rpair.v] = true;

            for (Edge e : graph[rpair.v]) {
                if (visited[e.nbr] == false) {
                    que.add(new Pair(e.nbr, rpair.psf + e.nbr));
                }
            }
        }
        return false;
    }
}