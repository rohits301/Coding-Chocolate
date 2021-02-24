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
        int t = Integer.parseInt(br.readLine());

        // write your code here
        boolean[] visited = new boolean[vtces];

        int ans = spreadOfInfection(graph, src, t, visited);
        System.out.println(ans);
    }

    static class Pair {
        int v;
        int time;

        Pair(int v, int time) {
            this.v = v;
            this.time = time;
        }
    }


    /*
    public static int spreadOfInfection(ArrayList<Edge>[] graph, int src, int t, boolean[] visited) {
        ArrayDeque<Pair> que = new ArrayDeque<>();
        int count = 0;

        //* r m* w a*
        que.add(new Pair(src, 1));

        while (que.size() > 0) {
            Pair rpair = que.remove();

            if (visited[rpair.v] == true) {
                continue;
            }
            visited[rpair.v] = true;

            if (rpair.time > t) { //* no need to go ahead
                break; //* will move control out of while loop, since it is in while loop
                //* return count;
            }

            //* System.out.println(rpair.v + " at time = " + rpair.time);
            count++; // w

            for (Edge e : graph[rpair.v]) {
                if (visited[e.nbr] == false) {
                    que.add(new Pair(e.nbr, rpair.time + 1));
                }
            }
        }
        return count;
    }
    */
    // * BETTER CODE, USING VISITED of int
    
    public static int spreadOfInfection(ArrayList<Edge>[] graph, int src, int t, int[] visited) {
        ArrayDeque<Pair> que = new ArrayDeque<>();
        int count = 0;

        // r m* w a*
        que.add(new Pair(src, 1));

        while (que.size() > 0) {
            Pair rpair = que.remove();

            if (visited[rpair.v] > 0) {
                continue;
            }
            visited[rpair.v] = rpair.time;

            if (rpair.time > t) { // no need to go ahead
                break; // will move control out of while loop, since it is in while loop
            }

            // System.out.println(rpair.v + " at time = " + rpair.time);
            count++; // w

            for (Edge e : graph[rpair.v]) {
                if (visited[e.nbr] == 0) {
                    que.add(new Pair(e.nbr, rpair.time + 1));
                }
            }
        }
        return count;
    }
}}