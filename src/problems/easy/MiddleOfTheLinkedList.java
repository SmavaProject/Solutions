package problems.easy;

public class MiddleOfTheLinkedList {
    /**
     * #876. Middle of the Linked List
     * https://leetcode.com/problems/middle-of-the-linked-list/
     */

    //#1 - fast and slow pointer
    public ListNode middleNode1(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast!=null && fast.next!=null){ //когда fast доберется до конца slow будет как раз на середине
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }



    // #2
    public ListNode middleNode(ListNode head) {
        int len = 0;
        ListNode node = head;

        while(node!=null){
            node = node.next;
            len++;
        }

        int midd = len/2;

        while(midd>0){
            head = head.next;
            midd--;
        }
        return head;
    }
}
