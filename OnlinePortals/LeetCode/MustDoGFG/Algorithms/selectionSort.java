
class Solution {
    // selects min in each iteration
    int select(int arr[], int i) {
        // code here such that selectionSort() sorts arr[]
        int n = arr.length;

        int min = i;
        for (int j = i + 1; j < n; j++) {

            if (arr[j] < arr[min]) {
                min = j;
            }
        }
        return min;
    }

    void selectionSort(int arr[], int n) {
        // code here
        for (int i = 0; i < n - 1; i++) {

            int min = select(arr, i);
            // swap min and i
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }
}