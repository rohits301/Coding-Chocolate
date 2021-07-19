import java.util.*;

public class Main {

    // ~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~

    // T: O(n), S: O(n) - for right Array
    public static int[] productExceptSelf(int[] arr) {
        // write your code here
        int n = arr.length;

        // 1. Make right array
        int[] right = new int[n];
        int prod = 1;
        for (int i = n - 1; i >= 0; i--) {
            prod *= arr[i];
            right[i] = prod;
        }

        // 2. Initialise left product
        int leftProduct = 1;

        // 3. Fill the result array
        int[] res = new int[n];
        for (int i = 0; i < n - 1; i++) {
            res[i] = leftProduct * right[i + 1];

            leftProduct *= arr[i]; // update left Product
        }

        res[n - 1] = leftProduct;
        return res;
    }

    // ~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int[] res = productExceptSelf(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}