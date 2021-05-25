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
    // Follow up
    
    public ListNode midNode(ListNode head){
        // case: size = 0, 1
        if(head == null || head.next == null){
            return head;
        } 
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    public ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode curr = head;
        ListNode forw = null;
        ListNode prev = null;
        
        while(curr != null){
            forw = curr.next;
            
            curr.next = prev;
            
            prev = curr;
            curr = forw;
        }
        return prev; // new head
    }
    
    public boolean isPalindrome(ListNode head) {
        // list of size : 0, 1 are palindrome
        if(head == null || head.next == null){
            return true;
        }
    
        ListNode mid = midNode(head);
        ListNode newHead = mid.next; 
        
        // reversing second half of list
        newHead = reverse(newHead);
        
        ListNode c1 = head;
        ListNode c2 = newHead;
        
        boolean flag = true;
        while(c2 != null){
            if(c1.val != c2.val){
                flag = false;
                break;
            }
            
            c1 = c1.next;
            c2 = c2.next;
        }
        
        // get back original list
        newHead = reverse(newHead);
        mid.next = newHead;
        
        return flag;
    }
}