class Solution {
    // T: O(3*n) = O(n)
    // S: O(1)
    // vid by Code with Alisha
    public int findUnsortedSubarray(int[] arr) {

        if (arr.length == 1) return 0;

        int min = (int) 1e6;
        int max = (int) -1e6;

        // Approach-
        // Intuition- If array is sorted in asc. order
        // it would be a straight line, increasing or constant
        // but if otherwise, there would be a mountain, that is some ups, some downs
        // -> find the minimum element in array which is not in its correct position,
        // coz that would be a dip
        // similarly find the maximum element in array which is not in its correct
        // position

        // NOW, find the index where they should have been
        // the minimum length is the gap between the correct indices,
        // that is, the whole subarray in between needs to be sorted in order to sort the
        // array
        int n = arr.length;
        for (int i = 0; i < n; i++) {

            // the first element case
            if (i == 0) {
                if (arr[i] > arr[i + 1]) {
                    min = Math.min(min, arr[i]);
                    max = Math.max(max, arr[i]);
                }
                continue;
            }
            // the last element case
            if (i == n - 1) {
                if (arr[i] < arr[i - 1]) {
                    min = Math.min(min, arr[i]);
                    max = Math.max(max, arr[i]);
                }
                continue;
            }

            // everything in the middle
            // finding position for dip
            if (arr[i] < arr[i - 1] || arr[i] > arr[i + 1]) {
                min = Math.min(min, arr[i]);
                max = Math.max(max, arr[i]);
            }
        }

        // NOW finding index where min and max would be in a
        // sorted array
        int i = 0, j = n - 1;
        for (; i < n && min >= arr[i]; i++);

        for (; j >= 0 && max <= arr[j]; j--);

        // if array is already sorted, then min and max won't update
        // hence return 0 in that case
        // else the length is j-i+1
        return (i > j) ? 0 : (j - i + 1);
    }
}