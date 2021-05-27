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
    
    public ListNode midNode(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
    public ListNode merge2SortedLL(ListNode l1, ListNode l2){
        if(l1 == null || l2 == null){
            return l1 == null? l2 : l1;
        }
        
        ListNode c1 = l1;
        ListNode c2 = l2;
        
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        
        while(c1 != null && c2 != null){
            if(c1.val < c2.val){
                prev.next = c1;
                c1 = c1.next;
            } else {
                prev.next = c2;
                c2 = c2.next;
            }
            prev = prev.next;
        }
        
        prev.next = c1 == null? c2 : c1;
        
        return dummy.next; // newHead
    }
    
    public ListNode sortList(ListNode head) {
        // size 0, 1
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode mid = midNode(head);
        ListNode nHead = mid.next;
        mid.next = null;
        
        ListNode fl = sortList(head); // first list
        ListNode sl = sortList(nHead); // second list
        
        return merge2SortedLL(fl, sl);
    }
}