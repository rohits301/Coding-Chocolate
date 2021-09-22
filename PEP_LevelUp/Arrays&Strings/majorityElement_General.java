import java.util.*;

public class Main {

    // ~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~
    // T: O(n), S: O(n), passed on GFG
    public static ArrayList<Integer> majorityElement(int[] arr, int k) {
        // write yout code here

        int n = arr.length;

        // Step-1
        HashMap<Integer, Integer> fmap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            fmap.put(arr[i], fmap.getOrDefault(arr[i], 0) + 1);
        }

        // Step-2
        ArrayList<Integer> res = new ArrayList<>();

        for (int key : fmap.keySet()) {
            if (fmap.get(key) > n / k) {
                res.add(key);
            }
        }
        // Step-3 (this is only requirement of Pep's question, otherwise not required)
        Collections.sort(res);
        return res;
    }

    // ~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        ArrayList<Integer> res = majorityElement(arr, k);
        System.out.println(res);
    }
}