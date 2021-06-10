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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }   
        
        Pair ans = diameter(root);
        return ans.dia;
    }
    
    class Pair {
        int ht;
        int dia;
    }
    
    private Pair diameter(TreeNode node){
        if(node == null){
            Pair bp = new Pair();
            bp.ht = -1;
            bp.dia = 0;
            
            return bp;
        }
        
        Pair lp = diameter(node.left);
        Pair rp = diameter(node.right);
        
        Pair mp = new Pair();
        mp.ht = Math.max(lp.ht, rp.ht) + 1;
        
        int factor = lp.ht + rp.ht + 2;
        mp.dia = Math.max(Math.max(lp.dia, rp.dia), factor);
        
        return mp;
    }
}