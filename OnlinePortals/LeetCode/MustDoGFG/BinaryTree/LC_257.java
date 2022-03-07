
class Solution {
    // T: O(n), S: O(n)
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();

        if (root == null)
            return paths;

        dfs(root, paths, "");
        return paths;
    }

    private void dfs(TreeNode root, List<String> paths, String path) {
        if (root == null)
            return;

        path += root.val;

        // leaf check is the base case
        if (root.left == null && root.right == null) {
            paths.add(path);
            return;
        }

        dfs(root.left, paths, path + "->");
        dfs(root.right, paths, path + "->");
    }
}