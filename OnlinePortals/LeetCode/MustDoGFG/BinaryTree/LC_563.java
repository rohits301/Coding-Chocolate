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
    
    public int findTilt(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        tPair p = findTiltHelper(root);
        return p.tilt;
    }
    private tPair findTiltHelper(TreeNode root){
        if(root == null){
            tPair bp = new tPair();
            bp.sum = 0;
            bp.tilt = 0;
            return bp;
        }
        
        tPair lp = findTiltHelper(root.left);
        tPair rp = findTiltHelper(root.right);
        
        tPair mp = new tPair();
        mp.sum = lp.sum + rp.sum + root.val;
        mp.tilt = lp.tilt + rp.tilt + Math.abs(lp.sum - rp.sum);
        
        return mp;
    }
    private class tPair {
        int sum;
        int tilt;
    }
}