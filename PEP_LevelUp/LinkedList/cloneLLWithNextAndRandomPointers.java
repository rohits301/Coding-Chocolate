import java.util.*;

class Main {
    public static class ListNode {
        int val = 0;
        ListNode next = null;
        ListNode random = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode copyRandomList(ListNode head) {
        // my code
        HashMap<ListNode, ListNode> map = new HashMap<>();
        
        ListNode curr = head;
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        
        while(curr != null){
            ListNode node = new ListNode(curr.val);
            prev.next = node;
            map.put(curr, node);
            
            prev = prev.next;
            curr = curr.next;
        }
        
        curr = head;
        ListNode copyNode = dummy.next;
        
        while(curr != null){
            copyNode.random = (curr.random != null)? map.get(curr.random) : null;
            
            copyNode = copyNode.next;
            curr = curr.next;
        }
        
        return dummy.next;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        ListNode[] arr = new ListNode[n];
        ListNode prev = null;

        for (int i = 0; i < n; i++) {
            arr[i] = new ListNode(0);
            if (prev != null)
                prev.next = arr[i];
            prev = arr[i];
        }

        for (int i = 0; i < n; i++) {
            int val = scn.nextInt();
            int idx = scn.nextInt();

            arr[i].val = val;
            if(idx != -1) arr[i].random = arr[idx];
        }

        ListNode head = copyRandomList(arr[0]);
        while (head != null) {
            System.out.print("(" + head.val + ", " + (head.random != null ? head.random.val : -1) + ") ");
            head = head.next;
        }
    }
}