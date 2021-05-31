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
    public ListNode partition(ListNode head, int x) {
        // not needed, already handled thru code
        // if(head == null || head.next == null) {
        //     return head;
        // }
        
        ListNode d1 = new ListNode(-1);
        ListNode smaller = d1;
        ListNode d2 = new ListNode(-1);
        ListNode greater = d2;
        
        while(head != null){
            if(head.val < x){
                smaller.next = head;
                smaller = smaller.next;
            } else {
                greater.next = head;
                greater = greater.next;
            }
            head = head.next;
        }
        
        greater.next = null; // to break cycle
        
        smaller.next = d2.next;
        return d1.next;
    }
}