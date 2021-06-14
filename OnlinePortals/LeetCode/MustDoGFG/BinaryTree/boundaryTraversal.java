//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 

//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }

class Solution {
    ArrayList<Integer> printBoundary(Node node) {

        ArrayList<Integer> al = new ArrayList<>();

        if (node == null) {
            return al;
        }

        al.add(node.data); // root node

        // check if it's the only node
        if (node.left == null && node.right == null) {
            return al;
        }

        leftBoundary(node.left, al);
        leafNodes(node, al);
        rightBoundary(node.right, al);

        return al;
    }

    private void leftBoundary(Node node, ArrayList<Integer> al) {
        if (node == null) {
            return;
        }

        // non-leaf node
        if (node.left != null || node.right != null) {
            al.add(node.data);
            if (node.left != null) {
                leftBoundary(node.left, al);
            } else if (node.right != null) {
                leftBoundary(node.right, al);
            }
        }
    }

    private void rightBoundary(Node node, ArrayList<Integer> al) {
        if (node == null) {
            return;
        }

        if (node.right != null) {
            rightBoundary(node.right, al);
        } else if (node.left != null) {
            rightBoundary(node.left, al);
        }
        // add only non-leaf nodes
        if (node.left != null || node.right != null) {
            al.add(node.data);
        }
    }

    private void leafNodes(Node node, ArrayList<Integer> al) {
        if (node == null) {
            return;
        }

        // any tree traversal (here I take preorder) and then check for leaf
        if (node.left == null && node.right == null) {
            al.add(node.data);
        }

        leafNodes(node.left, al);
        leafNodes(node.right, al);
    }
}
