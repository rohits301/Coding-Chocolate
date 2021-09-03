class Solution {
    // Function to sort the array using bubble sort algorithm.
    public static void bubbleSort(int arr[], int n) {
        // code here
        for (int i = 1; i <= n - 1; i++) {
            for (int j = 0; j < n - i; j++) {
                // if isSmaller
                if (arr[j + 1] < arr[j]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}