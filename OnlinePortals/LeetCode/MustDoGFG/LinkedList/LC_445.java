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
    public ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode curr = head;
        ListNode forw = curr.next;
        ListNode prev = null;
        
        while(curr != null){
            forw = curr.next;
            
            curr.next = prev;
            
            prev = curr;
            curr = forw;
        }
        return prev;
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode c1 = reverse(l1);
        ListNode c2 = reverse(l2);
        
        int carry = 0;
        
        ListNode head = new ListNode(-1);
        ListNode itr = head;
        
        while(c1 != null || c2 != null || carry != 0){
            int sum = carry + (c1 != null? c1.val : 0) + (c2 != null? c2.val : 0);
            int digit = sum % 10;
            carry = sum / 10;
            
            itr.next = new ListNode(digit);
            itr = itr.next;
            
            if(c1 != null){
                c1 = c1.next;
            }
            if(c2 != null){
                c2 = c2.next;
            }
        }
        
        //head of new list
        ListNode nhead = reverse(head.next);
        return nhead;
    }
}