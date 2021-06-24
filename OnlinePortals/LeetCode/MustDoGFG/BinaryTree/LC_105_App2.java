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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(inorder[i], i);
        }
        
        return buildTreeHelper(preorder, 0, n - 1, inorder, 0, n - 1, map);
    }
    
    private TreeNode buildTreeHelper(int[] preorder, int psi, int pei, int[] inorder, int isi, int iei, HashMap<Integer, Integer> map){
        if(isi > iei || psi > pei){
            return null;
        }
        
        int idx = map.get(preorder[psi]); // now idx = rootIndex
        
        int colse = idx - isi; // count of left subtree elements
        
        TreeNode node = new TreeNode(preorder[psi]);
        
        node.left = buildTreeHelper(preorder, psi + 1, psi + colse, inorder, isi, idx - 1, map);
        node.right = buildTreeHelper(preorder, psi + colse + 1, pei, inorder, idx + 1, iei, map);
        
        return node;
    }
}