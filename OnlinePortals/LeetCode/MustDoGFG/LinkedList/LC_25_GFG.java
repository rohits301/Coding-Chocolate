/*node class of the linked list

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

*/

class Solution
{
    public static int length(Node head){
        Node curr = head;
        int len = 0;
        
        while(curr != null){
            len++;
            curr = curr.next;
        }
        return len;
    }
    
    private static Node th = null;
    private static Node tt = null;
    
    public static void addFirstNode(Node node){
        if(th == null){
            th = node;
            tt = node;
        } else {
            node.next = th;
            th = node;
        }
    }
    
    public static Node reverse(Node head, int k) {
        
        if(head == null || head.next == null || k == 0){
            return head;
        }
        
        int len = length(head);
        Node oh = null;
        Node ot = null;
        
        Node curr = head;
        
        while(len >= k){
            int temp = k;
            while(temp-- > 0){
                Node forw = curr.next;
                
                curr.next = null;
                addFirstNode(curr);
                curr = forw;
            }
            
            if(oh == null){
                oh = th;
                ot = tt;
            } else {
                ot.next = th;
                ot = tt;
            }
            
            th = null;
            tt = null;
            len -= k;
        }
        
        // ot.next = curr;
        // subtle changes
        Node prev = null;
        while(len != 0){
            Node forw = curr.next;
            
            curr.next = prev;
            
            prev = curr;
            curr = forw;
            
            len--;
        }
        // Now, nHead = prev
        ot.next = prev;
        
        return oh;
    }
}