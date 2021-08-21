
class Solution
{
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[])
    {
        // Code here
        int n = nums.length;
        
        Pair[] arr = new Pair[n];
        for(int i = 0; i < n; i++){
            arr[i] = new Pair(nums[i], i);
        }
        
        Arrays.sort(arr, new Comparator<Pair>(){
           public int compare(Pair a, Pair b){
               
               if(a.val < b.val) return -1;
               else if(a.val > b.val) return 1;
               else return 0;
           } 
           
        });
        
        int ans=0;
        boolean[] vis = new boolean[n];
        for(int i=0; i<n; i++){
            
            if(vis[i] == true || arr[i].idx == i){
                continue;
            }
            
            int clen = 0;//cycle length
            int j = i;
            while(vis[j] == false){
                vis[j] = true;
                clen += 1;
                j = arr[j].idx;
            }
            
            ans += clen-1;
        }
        
        return ans;
    }
    class Pair {
        int val;
        int idx;
        
        Pair(int val, int idx){
            this.val = val;
            this.idx = idx;
        }
    }
}