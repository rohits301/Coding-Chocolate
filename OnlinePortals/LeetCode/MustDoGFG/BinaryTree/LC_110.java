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
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        
        Pair ans = check(root);
        return ans.isBal;
    }
    
    class Pair {
        int ht;
        boolean isBal;
        
        Pair() { }
        
        Pair(int ht, boolean isBal){
            this.ht = ht;
            this.isBal = isBal;
        }
    }
    
    private Pair check(TreeNode node){
        if(node == null){
            Pair base = new Pair(-1, true);
            return base;
        }
        
        Pair lp = check(node.left);
        Pair rp = check(node.right);
        
        Pair mp = new Pair();
        mp.ht = Math.max(lp.ht, rp.ht) + 1;
        
        // check node and subtrees for balance
        mp.isBal = (Math.abs(lp.ht - rp.ht) <= 1) &&
                    lp.isBal && 
                    rp.isBal;
        
        return mp;
    }
}