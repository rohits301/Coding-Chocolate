import java.util.*;

class Main {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode midNode(ListNode head){
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
    
    public static ListNode reverse(ListNode head){
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
    
    public static boolean isPalindrome(ListNode head) {
        // list of size : 0, 1 are palindrome
        if(head == null || head.next == null){
            return true;
        }
    
        ListNode mid = midNode(head);
        ListNode newHead = mid.next; 
        mid.next = null; // **V. Important**
        
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

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        System.out.println(isPalindrome(dummy.next));
    }
}