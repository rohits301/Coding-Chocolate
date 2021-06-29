class Solution{
    static int minJumps(int[] arr){
        // your code here
        
        int n = arr.length;
        // already at destination, so 0 moves
        if(n == 1){
            return 0;
        }
        // no jumps possible
        if(arr[0] == 0){
            return -1;
        }
        
        int jump = 1;
        int step = arr[0];
        int maxReachable = arr[0]; // maxReachabe index
        
        for(int i = 1; i < n; i++){
            if(i == n - 1){ // reached destination
                return jump;
            }
            
            // update max jump size possible from i
            maxReachable = Math.max(maxReachable, i + arr[i]);
            step--; // taking a step, hence step--
            
            if(step == 0){
                jump++; //=> now we have to jump, no more steps possible
                if(i >= maxReachable){
                    return -1; // 'i' is out of reach of maxReachable, so -1
                }
                step = maxReachable - i; // taking steps of size mR - i
            }
        }
        return -1;
    }
}