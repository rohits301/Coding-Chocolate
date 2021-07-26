
class Solution
{
    //Function to find if there exists a triplet in the 
    //array arr[] which sums up to target.
    public static boolean find3Numbers(int arr[], int n, int target) { 
        
        // Hashing way
        // T:O(n^2), S: O(n)
        
        if(n < 3) return false;
        
        for(int i = 0; i <= n - 3; i++){
            int val = arr[i];
            
            HashSet<Integer> set = new HashSet<>();
            int pairSum = target - val;
            
            // checking if pair having sum = target-val exists 
            for(int j = i + 1; j < n; j++){
                
                if(set.contains(pairSum - arr[j])){
                    return true;
                }
                
                set.add(arr[j]);
            }
        }
        return false;
    }
}