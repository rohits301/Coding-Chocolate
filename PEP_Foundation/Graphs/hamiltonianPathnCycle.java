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

        int src = Integer.parseInt(br.readLine());

        // write all your codes here

        // ArrayList<Edge> al = graph[6];
        // for(int i = 0; i < al.size(); i++){
        // Edge e = al.get(i);
        // System.out.println(e.src + "->" + e.nbr + " @ " + e.wt);
        // }

        HashSet<Integer> visited = new HashSet<>(); // better than boolean array since 
                                                    // loop not require to check all elements visited

        hamiltonian(graph, src, visited, src + "", src); // last is originalsource

    }

    private static void hamiltonian(ArrayList<Edge>[] graph, int src, HashSet<Integer> visited, String psf, int osrc) {

        // similar to print all paths

        if (visited.size() == graph.length - 1) {
            System.out.print(psf);

            boolean closingEdgeFound = false;

            for (Edge e : graph[src]) { // src is the last vertex visited
                if (e.nbr == osrc) {
                    closingEdgeFound = true;
                    break;
                }
            }

            if (closingEdgeFound == true) {
                System.out.println("*"); // cycle
            } else {
                System.out.println("."); // path
            }
            return;
        }

        visited.add(src);
        for (Edge e : graph[src]) {
            if (visited.contains(e.nbr) == false) {
                hamiltonian(graph, e.nbr, visited, psf + e.nbr, osrc);
            }
        }
        visited.remove(src); // unvisit
    }

}