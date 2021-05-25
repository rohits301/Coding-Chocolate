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
    public ListNode oddEvenList(ListNode head) {
        // size = 0
        if(head == null){
            return head;
        }
        
        ListNode oh = head; // odd head
        ListNode ot = head; // odd tail
        ListNode eh = head.next; // even head
        ListNode et = head.next; // even tail
        
        while(et != null && et.next != null){
            ot.next = et.next;
            ot = ot.next;
            et.next = ot.next;
            et = et.next;
        }
        
        ot.next = eh;
        return oh;
    }
}