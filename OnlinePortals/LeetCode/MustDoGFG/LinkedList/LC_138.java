/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    // optimal T: O(n), S: O(1)
    public Node copyRandomList(Node head) {
        Node curr = head;
        
        // 1. make copy nodes
        
        while(curr != null){
            Node forw = curr.next;
            
            Node copyNode = new Node(curr.val);
            curr.next = copyNode;
            copyNode.next = forw;
            
            curr = forw;
        }
        
        // 2. assigning the random ptrs to copy nodes
        
        curr = head;
        while(curr != null){
            curr.next.random = (curr.random != null)? curr.random.next : null;
            
            curr = curr.next.next;
        }
        
        // 3. separating both lists
        
        curr = head;
        Node dummy = new Node(-1);
        Node copy = dummy;
        
        while(curr != null){
            Node forw = curr.next.next;
            
            // for copy list
            copy.next = curr.next;
            copy = copy.next;
            
            // for original list
            curr.next = forw;
            curr = forw;
        }
        
        return dummy.next;
    }
}