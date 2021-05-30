/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    
    public int length(ListNode head){
        ListNode curr = head;
        int len = 0;
        
        while(curr != null){
            len++;
            curr = curr.next;
        }
        return len;
    }
    
    ListNode th = null;
    ListNode tt = null;
    
    public void addFirstNode(ListNode node){
        if(th == null){
            th = node;
            tt = node;
        } else {
            node.next = th;
            th = node;
        }
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        
        if(head == null || head.next == null || k == 0){
            return head;
        }
        
        int len = length(head);
        ListNode oh = null;
        ListNode ot = null;
        
        ListNode curr = head;
        
        while(len >= k){
            int temp = k;
            while(temp-- > 0){
                ListNode forw = curr.next;
                
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
        
        ot.next = curr;
        return oh;
    }

}