
class Solution {
    // T: O(n), S: O(n)
    // expln by PEP
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null)
            return res;

        dfs(root, targetSum, res, new ArrayList<Integer>());

        return res;
    }

    private void dfs(TreeNode root, int target, List<List<Integer>> res, List<Integer> path) {

        if (root == null)
            return;

        // leaf node
        if (root.left == null && root.right == null) {
            if (target - root.val == 0) {
                List<Integer> base = new ArrayList<>(path);
                base.add(root.val);

                res.add(base);
            }
            return;
        }

        path.add(root.val);

        dfs(root.left, target - root.val, res, path);
        dfs(root.right, target - root.val, res, path);

        path.remove(path.size() - 1);
    }
}