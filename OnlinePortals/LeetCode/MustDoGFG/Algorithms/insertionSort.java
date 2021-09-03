class Solution {
    // insert location and insert there
    static void insert(int arr[], int i) {
        // Your code here
        for (int j = i - 1; j >= 0; j--) {
            if (arr[j] > arr[j + 1]) {
                // swap
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            } else {
                break;
            }
        }
    }

    // Function to sort the array using insertion sort algorithm.
    public void insertionSort(int arr[], int n) {
        // code here
        for (int i = 1; i < n; i++) {
            insert(arr, i);
        }
    }
}