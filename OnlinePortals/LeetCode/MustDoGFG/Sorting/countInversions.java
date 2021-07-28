class Solution
{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    static long inversionCount(long arr[], long N)
    {
        // Your Code Here
        int n = (int)N; // convt to int
        count = 0;
        mergeSort(arr, 0, n - 1);
        return count;
    }
    static long count = 0;
    
    static long[] mergeSort(long[] arr, int lo, int hi){
        
        if(lo == hi){
            long[] base = new long[1];
            base[0] = arr[lo];
            return base;
        }
        
        int mid = lo + (hi - lo) / 2;
        
        long[] left = mergeSort(arr, lo, mid);
        long[] right = mergeSort(arr, mid + 1, hi);
        long[] merged = merge2SortedArrays(left, right);
        
        return merged;
    }
    
    static long[] merge2SortedArrays(long[] left, long[] right){
        int i = 0;
        int j = 0;
        int k = 0;
        
        long[] merged = new long[left.length + right.length];
        
        while(i < left.length && j < right.length){
            if(left[i] <= right[j]){
                merged[k++] = left[i++];
            } else {
                count += (left.length - i);
                merged[k++] = right[j++];
            }
        }
        
        while(i < left.length){
            merged[k++] = left[i++];
        }
        
        while(j < right.length){
            merged[k++] = right[j++];
        }
        
        return merged;
    }
}