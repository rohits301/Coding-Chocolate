/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode temp = node.next;
        
        // swap val
        int tval = node.val;
        node.val = temp.val;
        temp.val = tval;
        
        // new links
        node.next = temp.next;
        
        temp.next = null; // removed
    }
}