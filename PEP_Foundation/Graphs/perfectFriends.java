import java.io.*;
import java.util.*;

public class Main {

    public static class Edge {
        int v;
        int nbr;

        Edge(int v, int nbr) {
            this.v = v;
            this.nbr = nbr;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        // write your code here

        ArrayList<Edge>[] graph = new ArrayList[n]; // an array of ArrayList type
        // further ArrayList is of Edge type

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        // k edges
        for (int e = 0; e < k; e++) {
            String line = br.readLine();
            String[] parts = line.split("\\s"); // split on space

            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);

            graph[v1].add(new Edge(v1, v2));
            graph[v2].add(new Edge(v2, v1));
        }

        // graph constructed

        boolean[] visited = new boolean[n];
        ArrayList<ArrayList<Integer>> comps = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                ArrayList<Integer> al = new ArrayList<>();
                gcc(graph, i, al, visited);
                comps.add(al);
            }
        }

        // gcc done

        int count = 0;
        for (int i = 0; i < comps.size(); i++) {
            for (int j = i + 1; j < comps.size(); j++) {
                count += comps.get(i).size() * comps.get(j).size();
            }
        }
        System.out.println(count);

        // perfect friends pairs done
    }

    private static void gcc(ArrayList<Edge>[] graph, int src, ArrayList<Integer> al, boolean[] visited) {
        visited[src] = true;
        al.add(src);

        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i); // arraylist in graph[src]

            if (visited[e.nbr] == false) {
                gcc(graph, e.nbr, al, visited);
            }
        }
    }

}