class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        
        // 1. frequency map
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        // 2. min heap of size k
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        for(int key : map.keySet()){
            int freq = map.get(key);
            
            if(pq.size() < k){
                pq.add(new Pair(freq, key));
            } else {
                if(freq > pq.peek().freq){
                    pq.poll(); // removes least freq. element
                    pq.add(new Pair(freq, key));
                }
            }
        }
        
        // 3. fill ans
        int i = 0;
        while(pq.size() > 0){
            ans[i] = pq.poll().val;
            i++;
        }
        return ans;
    }
    
    private class Pair implements Comparable<Pair> {
        int freq;
        int val;
        
        Pair(){}
        
        Pair(int freq, int val){
            this.freq = freq;
            this.val = val;
        }
        
        public int compareTo(Pair o){
            return this.freq - o.freq;
        }
    }
}