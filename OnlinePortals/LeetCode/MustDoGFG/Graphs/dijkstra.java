class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int vtcs, ArrayList<ArrayList<ArrayList<Integer>>> adj, int src)
    {
        // Write your code here
        int[] dist = new int[vtcs];
        
        int idx = 0;
        boolean[] vis = new boolean[vtcs];
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        pq.add(new Pair(src, 0));
        
        // r,m*,w,a*
        // * => only unvisited nbrs
        while(pq.size() > 0){
            Pair rem = pq.remove();
            
            if(vis[rem.v] == true){
                continue;
            }
            vis[rem.v] = true;
            
            dist[rem.v] = rem.wsf; //work
            
            for(int i = 0; i < adj.get(rem.v).size(); i++){
                for(int j = 0; j < adj.get(rem.v).get(i).size(); j++){
                    
                    ArrayList<Integer> list = adj.get(rem.v).get(i);
                    
                    pq.add(new Pair(list.get(0), rem.wsf + list.get(1))); // 0-vtc, 1-wt
                }
            }
        }
        
        return dist;
    }
    static class Pair implements Comparable<Pair>{
        int v;
        int wsf;
        
        Pair(int v, int wsf){
            this.v = v;
            this.wsf = wsf;
        }
        
        public int compareTo(Pair o){
            return this.wsf - o.wsf;
        }
    }
}