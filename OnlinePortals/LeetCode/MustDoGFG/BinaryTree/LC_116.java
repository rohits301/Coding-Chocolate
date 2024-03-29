/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null){
            return root;
        }
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while(q.size() > 0){
            int size = q.size();
            Node prev = null;
            
            while(size-- > 0){
                // r
                Node rnode = q.remove();
                
                // w
                if(prev != null){
                    prev.next = rnode;
                }
                prev = rnode;
                
                //a 
                if(rnode.left != null){
                    q.add(rnode.left);
                }
                if(rnode.right != null){
                    q.add(rnode.right);
                }
            }
        }
        return root;
    }
}