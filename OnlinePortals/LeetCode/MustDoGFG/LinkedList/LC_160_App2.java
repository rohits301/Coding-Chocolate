/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    //optimal approach, difference method but smarter
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        
        // dummy nodes
        ListNode a = headA;
        ListNode b = headB;
        
        while(a != b){
            a = (a == null)? headB : a.next; 
            b = (b == null)? headA : b.next;
        }
        
        return a;
    }

}