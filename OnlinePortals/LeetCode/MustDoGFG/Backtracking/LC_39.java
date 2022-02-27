class Solution {
    // T: O(2^t * k), S: O(k*x) + O(2^t)(recursive-space)
    // t-> avg. number of times an element is picked/not-picked
    // k-> avg. length of combination
    // x-> no. of combinations
    // vid by Striver bhai
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        csHelper(candidates, 0, target, new ArrayList<>(), ans);

        return ans;
    }

    void csHelper(int[] arr, int i, int tar, List<Integer> temp, List<List<Integer>> ans) {

        if (i == arr.length) {
            if (tar == 0) {
                ans.add(new ArrayList(temp));
            }
            return;
        }

        // pick
        if (tar - arr[i] >= 0) {
            temp.add(arr[i]);
            csHelper(arr, i, tar - arr[i], temp, ans);
            temp.remove(temp.size() - 1);
        }
        // not-pick
        csHelper(arr, i + 1, tar, temp, ans);
    }

}