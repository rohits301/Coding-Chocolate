/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null) {
            return root;
        }
        
        // if any one matches, return root
        if(root.val == p.val ||
           root.val == q.val){
            return root;
        }
        
        TreeNode lsr = lowestCommonAncestor(root.left, p, q); // left search result
        TreeNode rsr = lowestCommonAncestor(root.right, p, q); // right search result
        
        if(lsr != null && rsr != null){
            return root;
        } else if(lsr != null){
            return lsr;
        } else if(rsr != null){
            return rsr;
        } else {
            return null;
        }
    }
}