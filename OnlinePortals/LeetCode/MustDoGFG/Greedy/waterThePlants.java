class Solution
{
    int min_sprinklers(int gallery[], int n)
    {
        // code here
        
        int[] temp = new int[n];
        Arrays.fill(temp, -1);
        
        for(int i=0; i<n; i++){
            if(gallery[i] == 0){
                temp[i] = Math.max(temp[i], i);
                continue;
            }
            
            if(gallery[i] != -1){
                int leftLimit = Math.max(0, i - gallery[i]);
                int rightLimit = Math.min(n - 1, i + gallery[i]);
                int val = i + gallery[i];
                
                for(int itr = leftLimit; itr <= rightLimit; itr++){
                    temp[itr] = Math.max(temp[itr], val);
                }
            }
        }
        
        // check
        
        int count = 0;
        for(int i=0; i<n; ){
            
            if(i == -1 || temp[i] == -1) return -1;
            
            count++;
            i = temp[i]+1; // jump to temp[i] + 1
        }
        
        return count;
    }
}