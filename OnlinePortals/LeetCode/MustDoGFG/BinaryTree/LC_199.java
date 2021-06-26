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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        
        LinkedList<TreeNode> que = new LinkedList<>();
        que.addLast(root);
        
        while(que.size() > 0){
            int size = que.size();
            
            ans.add(que.getFirst().val);
            while(size-- > 0){
                // r w a
                TreeNode rn = que.removeFirst();
                
                if(rn.right != null) que.addLast(rn.right);
                if(rn.left != null) que.addLast(rn.left);
            }
        }
        return ans;
    }
}