class Solution {
    static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static String max;

    // T: O(n! / (n-k)!), S: O(n)
    
    // Function to find the largest number after k swaps.
    public static String findMaximumNum(String str, int k) {
        // code here
        max = str;
        findMaxHelper(str.toCharArray(), k);
        return max;

    }

    static void findMaxHelper(char[] arr, int k) {

        String s = new String(arr);
        if (max.compareTo(s) < 0) {
            max = s;
        }
        // System.out.println(max);

        if (k == 0)
            return;

        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {

                if (arr[j] > arr[i]) {

                    swap(arr, i, j);
                    findMaxHelper(arr, k - 1);
                    swap(arr, i, j);
                }
            }
        }
    }
}