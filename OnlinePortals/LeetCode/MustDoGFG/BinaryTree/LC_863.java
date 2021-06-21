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
    /*
    1. The given tree is non-empty.
    2. Each node in the tree has unique values
    3. The target node is a node in the tree.
    4. 0 <= k <= 1000.
    */
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        map.put(root, null);
        mapNodeWithParent(root, null, map);
        
        Queue<TreeNode> que = new ArrayDeque<>();
        int level = 0;
        que.add(target);
        
        HashSet<TreeNode> hs = new HashSet<>();
        hs.add(target);
        
        while(que.size() > 0){
            int size = que.size();
            while(size-- > 0){
                // r,w,a
                TreeNode rnode = que.remove();
                
                if(level == k){
                    ans.add(rnode.val);
                }
                
                // add to que, hs
                if(rnode.left != null && !hs.contains(rnode.left)){   
                    que.add(rnode.left);
                    hs.add(rnode.left);
                }
                if(rnode.right != null && !hs.contains(rnode.right)){   
                    que.add(rnode.right);
                    hs.add(rnode.right);
                }
                TreeNode parent = map.get(rnode);
                if(parent != null && !hs.contains(parent)){
                    que.add(parent);
                    hs.add(parent);
                }
            }
            level++;
        }
        
        return ans;
    }
    
    private void mapNodeWithParent(TreeNode node, TreeNode parent, HashMap<TreeNode, TreeNode> map) {
        if(node == null){
            return;
        }
        
        if(parent != null){
            map.putIfAbsent(node, parent);
        }
        
        mapNodeWithParent(node.left, node, map);
        mapNodeWithParent(node.right, node, map);
    }
}