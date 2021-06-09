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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        
        if(root == null){
            return res;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 1;
        
        while(q.size() > 0){
            
            int size = q.size();
            LinkedList<Integer> temp = new LinkedList<>();
            while(size-- > 0){
                TreeNode node = q.poll();
                
                if(level % 2 == 1){
                    temp.add(node.val);
                } else {
                    temp.addFirst(node.val); // addFirst() is O(1)
                }
                
                if(node.left != null){
                    q.add(node.left);
                }
                if(node.right != null){
                    q.add(node.right);
                }
            }
            level++;
            res.add(temp);
        }
        
        return res;
    }
}