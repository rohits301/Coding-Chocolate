/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    // T: O(n), S: O(n) -> to construct the bst
    // expln by Coding Decoded
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        return constructBST(nums, 0, n - 1);
    }

    private TreeNode constructBST(int[] nums, int start, int end) {
        if (start > end) return null;

        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(nums[mid]);

        node.left = constructBST(nums, start, mid - 1);
        node.right = constructBST(nums, mid + 1, end);

        return node;
    }
}