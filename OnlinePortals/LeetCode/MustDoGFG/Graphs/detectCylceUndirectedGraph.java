
class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> graph) {
        // Code here
        
        // 2 ways to reach the same destination => cycle
        boolean[] vis = new boolean[V];
        
        for(int i = 0; i < V; i++){
            if(vis[i] == false){
                boolean hasCycle = isCyclic(graph, i, vis);
                if(hasCycle == true){
                    return true;
                }
            }
        }
        return false;
        
    }
    public boolean isCyclic(ArrayList<ArrayList<Integer>> graph, int src, boolean[] vis){
        
        LinkedList<Integer> q = new LinkedList<>();
        q.add(src);
        
        while(q.size() > 0){
            // r,m*,a,w*
            
            int rv = q.removeFirst();
            
            if(vis[rv] == true){
                return true; // has cycle
            }
            vis[rv] = true;
            
            for(int i = 0; i < graph.get(rv).size(); i++){
                int nbr = graph.get(rv).get(i);
                if(vis[nbr] == false){
                    q.addLast(nbr);
                }
            }
        }
        return false;
    }
}