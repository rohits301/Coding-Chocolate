
class Solution {
    int getMinDiff(int[] arr, int n, int k) {
        // code here
        Arrays.sort(arr);

        int ans = arr[n - 1] - arr[0]; // current max difference

        int smallest = arr[0] + k;
        int largest = arr[n - 1] - k;

        int cmin = 0, cmax = 0; // current min max
        for (int i = 0; i < n - 1; i++) {
            cmin = Math.min(smallest, arr[i + 1] - k);
            cmax = Math.max(largest, arr[i] + k);

            ans = Math.min(ans, cmax - cmin);
        }

        return ans;
    }
}