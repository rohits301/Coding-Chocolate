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
    class Pair {
        TreeNode node;
        int state;
        
        Pair(TreeNode node, int state){
            this.node = node;
            this.state = state;
        }
    }
    
    public List<Integer> preorderTraversal(TreeNode root) {
        
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root, 1));
        
        while(st.size() > 0){
            Pair top = st.peek();
            
            if(top.state == 1){
                // pre, s++, left
                res.add(top.node.val);
                top.state++;
                
                if(top.node.left != null){
                    TreeNode ln = top.node.left;
                    st.push(new Pair(ln, 1));
                }
            } else if(top.state == 2){
                // in, s++, right
                top.state++;
                
                if(top.node.right != null){
                    TreeNode rn = top.node.right;
                    st.push(new Pair(rn, 1));
                }
            } else {
                // post, pop
                st.pop();
            }
        }
        return res;
    }
}