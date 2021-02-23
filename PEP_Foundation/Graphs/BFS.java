import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int src;
        int nbr;

        Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
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
            graph[v1].add(new Edge(v1, v2));
            graph[v2].add(new Edge(v2, v1));
        }

        int src = Integer.parseInt(br.readLine());

        // write your code here
        boolean[] visited = new boolean[vtces];
        BFS(graph, src, visited);
    }

    public static class Pair {
        int v;
        String psf;

        Pair(int v, String psf) {
            this.v = v;
            this.psf = psf;
        }
    }

    public static void BFS(ArrayList<Edge>[] graph, int src, boolean[] visited) {
        ArrayDeque<Pair> que = new ArrayDeque<>(); // java.util.Arrays

        que.add(new Pair(src, src + ""));

        // r m* w a*
        while (que.size() > 0) {
            Pair rpair = que.remove();

            if (visited[rpair.v] == true) {
                continue;
            }
            visited[rpair.v] = true;

            System.out.println(rpair.v + "@" + rpair.psf);

            for (Edge e : graph[rpair.v]) {
                if (visited[e.nbr] == false) {
                    que.add(new Pair(e.nbr, rpair.psf + e.nbr));
                }
            }
        }
    }

}