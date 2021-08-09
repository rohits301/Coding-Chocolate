import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s1 = br.readLine().split(" ");
        int n = Integer.parseInt(s1[0]); // vertices
        int m = Integer.parseInt(s1[1]); // edges

        int[][] preRequisites = new int[m][2];
        for (int i = 0; i < m; i++) {
            String[] s2 = br.readLine().split(" ");

            preRequisites[i][0] = Integer.parseInt(s2[0]); // ai
            preRequisites[i][1] = Integer.parseInt(s2[1]); // bi
        }

        // ======================Create Graph=========================
        ArrayList<ArrayList<Integer>> graph = createGraph(preRequisites, n, m);

        int[] order = KahnAlgo(n, graph);

        for (int val : order) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
    
    // ======================Kahn's Algo=========================
    private static int[] KahnAlgo(int n, ArrayList<ArrayList<Integer>> graph) {

        int[] ans = new int[n];
        int idx = 0;

        // O(n + m) to cal. indegree
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < graph.get(i).size(); j++) {
                int nbr = graph.get(i).get(j);
                indegree[nbr]++;
            }
        }
        
        // queue
        LinkedList<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.addLast(i);
            }
        }
        
        while (q.size() > 0) {
            int rem = q.removeFirst();
            
            ans[idx] = rem;
            idx++;

            for (int i = 0; i < graph.get(rem).size(); i++) {
                int nbr = graph.get(rem).get(i);
                indegree[nbr]--;

                if (indegree[nbr] == 0) {
                    q.addLast(nbr);
                }
            }
        }

        if (idx == n) {
            return ans;
        } else {
            return new int[] { -1 };
        }
    }

    private static ArrayList<ArrayList<Integer>> createGraph(int[][] preRequisites, int n, int m) {
        // ai depends on bi, [ai, bi]
        // HENCE, edge from bi to ai

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // m = preRequisites.length
        for (int i = 0; i < m; i++) {
            int ai = preRequisites[i][0];
            int bi = preRequisites[i][1];

            graph.get(bi).add(ai);
        }
        
        // for(ArrayList<Integer> al : graph){
        //     System.out.println(al);
        // }
        return graph;
    }
}
