class Solution {
    int longSubarrWthSumDivByK(int arr[], int n, int k) {
        // Complete the function
        int ans = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            int rem = sum % k;

            if (rem < 0)
                rem = rem + k;

            if (map.containsKey(rem)) {
                int len = i - map.get(rem);
                if (len > ans) {
                    ans = len;
                }
            } else {
                map.put(rem, i);
            }
        }

        return ans;
    }

}