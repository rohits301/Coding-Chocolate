// Question Link: https://practice.geeksforgeeks.org/problems/-rearrange-array-alternately-1587115620/1#

class Solution{
    
    // temp: input array
    // n: size of array
    //Function to rearrange  the array elements alternately.
    public static void rearrange(int arr[], int n){
        
        /* ALGO.
        i -> Even
            arr[i] = arr[i] + ((arr[maxIdx]) % maxP1) * maxP1;
            maxIdx--;
        i -> Odd
            arr[i] = arr[i] + ((arr[minIdx]) % maxP1) * maxP1;
            minIdx++;
        */
        
        int maxP1 = arr[n - 1] + 1; // maxElement in arr + 1
        int maxIdx = n - 1;
        int minIdx = 0;
        
        for(int i = 0; i < n; i++){
            if(i % 2 == 0){ // Even
                arr[i] = arr[i] + ((arr[maxIdx]) % maxP1) * maxP1;
                maxIdx--;
            } else { // Odd
                arr[i] = arr[i] + ((arr[minIdx]) % maxP1) * maxP1;
                minIdx++;
            }
        }
        
        // recovering new array
        for(int i = 0; i < n; i++){
            arr[i] = arr[i] / maxP1;
        }
    }
    
}

