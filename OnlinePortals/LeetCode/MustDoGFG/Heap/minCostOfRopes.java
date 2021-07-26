
class Solution
{
    //Function to return the minimum cost of connecting the ropes.
    long minCost(long arr[], int n) 
    {
        // your code here
    
        PriorityQueue<Long> minpq = new PriorityQueue<>(); // min heap
        
        // adding n elements => O(nlogn)
        for(int i = 0; i < arr.length; i++){
            minpq.add(arr[i]);   
        }
        
        long cost = 0;
        while(minpq.size() >= 2){
            long first = minpq.poll();
            long second = minpq.poll();
            
            long val = first + second;
            cost += val;
            
            minpq.add(val);
        }
        return cost;
    }
}