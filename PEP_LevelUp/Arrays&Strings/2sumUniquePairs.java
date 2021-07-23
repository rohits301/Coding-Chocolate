import java.util.*;

public class Main {

    // ~~~~~~~~~~~~User Section~~~~~~~~~~~~
    public static List<List<Integer>> twoSum(int[] arr, int target) {
        // write your code here

        int left = 0;
        int right = arr.length - 1;
        Arrays.sort(arr);

        List<List<Integer>> res = new ArrayList<>();
        int sum = 0;

        while (left < right) {

            sum = arr[left] + arr[right];

            // for unique pairs
            if (left != 0 && arr[left] == arr[left - 1]) {
                left++;
                continue;
            }

            if (sum == target) {
                // found pair
                List<Integer> targetPair = new ArrayList<>();
                targetPair.add(arr[left]);
                targetPair.add(arr[right]);
                res.add(targetPair); // add to result

                left++;
                right--;
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return res;
    }

    // ~~~~~~~~~~Input Management~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int target = scn.nextInt();
        List<List<Integer>> res = twoSum(arr, target);
        ArrayList<String> finalResult = new ArrayList<>();
        for (List<Integer> list : res) {
            Collections.sort(list);
            String ans = "";
            for (int val : list) {
                ans += val + " ";
            }
            finalResult.add(ans);
        }
        Collections.sort(finalResult);
        for (String str : finalResult) {
            System.out.println(str);
        }
    }
}