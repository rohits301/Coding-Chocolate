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
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0; // in terms of nodes
        }
        
        int ld = minDepth(root.left); // left depth
        int rd = minDepth(root.right); // right depth
        
        if(ld == 0 || rd == 0){ // skewed tree
            return Math.max(ld, rd) + 1;
        }
        
        return Math.min(ld, rd) + 1;
    }
}