
class Solution {
    static int toyCount(int N, int k, int arr[]) {
        // code here
        Arrays.sort(arr);

        int sum = 0;
        int count = 0;

        for (int val : arr) {
            sum += val;
            count++;
            if (sum > k) {
                sum = sum - val;
                count--;
                break;
            }
        }
        return count;
    }
}