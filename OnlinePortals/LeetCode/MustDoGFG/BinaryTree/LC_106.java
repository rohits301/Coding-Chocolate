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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        
        TreeNode root = buildTree(postorder, 0, n - 1, inorder, 0, n - 1);
        return root;
    }
    public TreeNode buildTree(int[] postorder, int psi, int pei, int[] inorder, int isi, int iei) {
        if(isi > iei){
            return null;
        }
        
        TreeNode node = new TreeNode(postorder[pei]);
        
        int idx = isi;
        while(inorder[idx] != postorder[pei]){
            idx++;
        }
        
        int tnel = idx - isi;//total no of elements on left
        
        node.left = buildTree(postorder, psi, psi + tnel - 1, inorder, isi, idx - 1);
        node.right = buildTree(postorder, psi + tnel, pei - 1, inorder, idx + 1, iei);
        
        return node;
    }
}