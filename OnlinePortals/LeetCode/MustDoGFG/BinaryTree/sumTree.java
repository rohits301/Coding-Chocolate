/* A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/
class Solution {
	boolean isSumTree(Node root) {
	    if(root == null){
	        return true;
	    }
	    
	    Pair ans = calSum(root);
	    return ans.flag;
	}
	static class Pair {
	    int sum;
	    boolean flag;
	}
	Pair calSum(Node node){
	    if(node == null){
	        Pair bp = new Pair();
	        bp.sum = 0;
	        bp.flag = true;
	        return bp;
	    }
	    
	    // leaf node
	    if(node.left == null && node.right == null){
	        Pair p = new Pair();
	        p.sum = node.data;
	        p.flag = true;
	        return p;
	    }
	    
	    Pair lp = calSum(node.left);
        Pair rp = calSum(node.right);
	    
	    Pair mp = new Pair();
	    mp.sum = node.data + lp.sum + rp.sum;
	    mp.flag = (node.data == (lp.sum + rp.sum)) &&
	               lp.flag &&
	               rp.flag;
	    
	    return mp;
	}
}
