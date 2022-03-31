class Solution {
    // Function to find minimum number of pages.
    // T: O(N * log (sum)), S: O(1) - n=arr.length, sum = sigma(arr)
    // Expln by PEPCODING
    public static int findPages(int[] A, int N, int M) {
        // Your code here

        int max = -1;
        int sum = 0;

        for (int val : A) {
            sum += val;
            max = Math.max(max, val);
        }

        int lo = max, hi = sum;
        int ans = -1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (isPossible(A, mid, M)) {
                ans = mid;

                // reduce mid in greed of finding a better answer
                hi = mid - 1;
            } else {
                lo = mid + 1; // students zyada lag rhe hain, load badhana hoga, i.e, increase mid
            }
        }

        return ans;
    }

    static boolean isPossible(int[] arr, int mid, int m) {

        int students = 1, sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum > mid) {
                sum = arr[i];
                students++;
            }
        }

        return students <= m;
    }
};