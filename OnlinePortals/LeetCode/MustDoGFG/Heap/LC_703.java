class KthLargest {
    
    int k;
    PriorityQueue<Integer> minpq;
    
    // nums[] contains the kth largest elements in stream till now
    
    public KthLargest(int k, int[] nums) {
        this.k = k;
        minpq = new PriorityQueue<>(k);
        
        for(int num : nums){
            add(num); // using add func. below
        }
    }
    // peek is in O(1)
    public int add(int val) {
        if(minpq.size() < k){
            minpq.add(val);
        } else {
            if(val > minpq.peek()){
                minpq.poll();
                minpq.add(val);
            }
        }
        
        return minpq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */