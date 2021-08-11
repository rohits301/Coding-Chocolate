class Solution {
    public int minStoneSum(int[] piles, int k) {
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<>() {
            public int compare(Integer a, Integer b){
                if(a > b) return -1; // for max heap
                else if(a < b) return 1;
                else return 0;
            }
        });
        
        int sum = 0;
        for(int val : piles){
            maxHeap.add(val);
            sum += val;
        }
        
        while(k-- > 0){
            int val = maxHeap.poll();
            int rval = (int)Math.floor(val/2); //remove val
            
            maxHeap.add(val - rval);
            sum -= rval; // removing the same amount from total sum
        }
        
        return sum;
    }
}