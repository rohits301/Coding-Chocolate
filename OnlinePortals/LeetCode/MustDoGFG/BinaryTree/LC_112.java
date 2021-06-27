/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        
        if(root == null){
            return false;
        }
        
        // leaf, check if target has been achieved
        if(root.left == null && root.right == null){
            if(targetSum - root.val == 0){
                return true;
            }
        }
        
        boolean res = false;
        // prevents useless calls
        res = res || hasPathSum(root.left, targetSum - root.val);
        res = res || hasPathSum(root.right, targetSum - root.val);
        
        return res;
    }
}