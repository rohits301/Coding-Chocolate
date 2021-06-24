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
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            map.put(inorder[i], i);
        }
        
        TreeNode root = buildTree(postorder, 0, n - 1, inorder, 0, n - 1, map);
        return root;
    }
    public TreeNode buildTree(int[] postorder, int psi, int pei, int[] inorder, int isi, int iei, HashMap<Integer, Integer> map) {
        if(isi > iei){
            return null;
        }
        
        TreeNode node = new TreeNode(postorder[pei]);
        
        int idx = map.get(postorder[pei]);
        
        int tnel = idx - isi;//total no of elements on left
        
        node.left = buildTree(postorder, psi, psi + tnel - 1, inorder, isi, idx - 1, map);
        node.right = buildTree(postorder, psi + tnel, pei - 1, inorder, idx + 1, iei, map);
        
        return node;
    }
}