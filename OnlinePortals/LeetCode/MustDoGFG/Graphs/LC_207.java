class Solution {
    // T: O(n + m), S: O(n + m)
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        
        // ======================Create Graph=========================
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // edge from bi to ai
        for (int i = 0; i < prerequisites.length; i++) {
            int ai = prerequisites[i][0];
            int bi = prerequisites[i][1];

            graph.get(bi).add(ai);
        }
        
        // ======================Kahn's Algo=========================
        
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
        
        int count = 0;
        while (q.size() > 0) {
            int rem = q.removeFirst();
            
            count++;

            for (int i = 0; i < graph.get(rem).size(); i++) {
                int nbr = graph.get(rem).get(i);
                indegree[nbr]--;

                if (indegree[nbr] == 0) {
                    q.addLast(nbr);
                }
            }
        }

        return count == n;
    }
}