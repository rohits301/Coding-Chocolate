//User function Template for Java

/* class Node
class Node
{
	Node left, right;
	int data;
	
	Node(int d)
	{
		data = d;
		left = right = null;
	}
	
}*/

//This function should return head to the DLL

class Solution {
    // Function to convert binary tree to doubly linked list and return it.
    Node head = null;
    Node tail = null;

    Node bToDLL(Node root) {
        // Your code here
        convert(root);
        return head;
    }

    void convert(Node root) {
        if (root == null) {
            return;
        }

        convert(root.left);

        if (head == null) {
            head = root;
            tail = root;
        } else {
            root.left = tail;
            tail.right = root;
            tail = root;
        }

        convert(root.right);
    }
}