import java.util.*;
import java.io.*;

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

        int edges = Integer.parseInt(br.readLine());

        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        for (int i = 0; i < edges; i++) {
            String parts = br.readLine();
            int v1 = Integer.parseInt(parts.split(" ")[0]);
            int v2 = Integer.parseInt(parts.split(" ")[1]);

            graph[v1].add(new Edge(v1, v2));
        }

        boolean[] visited = new boolean[vtces];
        Stack<Integer> st = new Stack<>();

        for (int v = 0; v < vtces; v++) {
            if (visited[v] == false) {
                topoSort(graph, v, visited, st);
            }
        }
        while (st.size() > 0) {
            System.out.println(st.pop());
        }
    }

    private static void topoSort(ArrayList<Edge>[] graph, int src, boolean[] visited, Stack<Integer> st) {
        visited[src] = true;

        for (Edge e : graph[src]) {
            if (visited[e.nbr] == false) {
                topoSort(graph, e.nbr, visited, st);
            }
        }
        st.push(src); // push in post order
    }

}
