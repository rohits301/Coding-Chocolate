
class Solution {
    // T: O(n*logk), n operations in pq of size k, S: O(n) for the array
    static int[] kthLargest(int k, int[] arr, int n) {
        // code here
        
        int[] ans = new int[n];
        
        PriorityQueue<Integer> minpq = new PriorityQueue<>(); // min Heap
        
        for(int i = 0; i < n; i++){
            
            if(minpq.size() < k){
                minpq.add(arr[i]);
            } else {
                if(arr[i] > minpq.peek()){
                    minpq.poll();
                    minpq.add(arr[i]);
                }
            }
            
            if(minpq.size() < k){
                ans[i] = -1;
            } else {
                ans[i] = minpq.peek();
            }
        }
        
        return ans;
    }
};