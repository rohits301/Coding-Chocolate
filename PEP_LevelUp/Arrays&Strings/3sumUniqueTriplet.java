import java.util.*;

public class Main {

    // ~~~~~~~~~~~~User Section~~~~~~~~~~~~

    public static List<List<Integer>> twoSum(int[] nums, int si, int ei, int target) {
        int left = si;
        int right = ei;

        List<List<Integer>> ans = new ArrayList<>();

        while (left < right) {
            int sum = nums[left] + nums[right];

            if (left != si && nums[left] == nums[left - 1]) {
                left++;
                continue;
            }

            if (sum == target) {
                List<Integer> al = new ArrayList<>();
                al.add(nums[left]);
                al.add(nums[right]);
                ans.add(al);

                left++;
                right--;
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return ans;
    }

    public static List<List<Integer>> threeSum(int[] nums, int target) {
        // write your code here

        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        if (n < 3) {
            return res;
        }
        Arrays.sort(nums);

        for (int i = 0; i <= n - 3; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int val1 = nums[i];
            List<List<Integer>> subRes = twoSum(nums, i + 1, n - 1, target - val1);

            for (List<Integer> list : subRes) {
                list.add(val1);
                res.add(list);
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
        List<List<Integer>> res = threeSum(arr, target);
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