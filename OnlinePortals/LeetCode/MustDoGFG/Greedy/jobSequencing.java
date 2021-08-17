class Solution {
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n) {
        // Your code here
        Arrays.sort(arr, (a,b) -> (b.profit - a.profit));
        
        int maxd = 0;
        
        for(int i = 0; i < n; i++){
            if(arr[i].deadline > maxd){
                maxd = arr[i].deadline; // finding the max deadline
            }
        }
        
        int[] res = new int[maxd + 1];
        
        Arrays.fill(res, -1);
        
        int countJobs = 0;
        int jobProfit = 0;
        
        for(int i = 0; i<n; i++){
            for(int j=arr[i].deadline; j>0; j--){
                // can do the job
                if(res[j] == -1){
                    res[j] = i;
                    countJobs++;
                    jobProfit += arr[i].profit;
                    break;
                }
            }
        }
        
        int[] ans = new int[2];
        ans[0] = countJobs;
        ans[1] = jobProfit;
        return ans;
    }
    
}