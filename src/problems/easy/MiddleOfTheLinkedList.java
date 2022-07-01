package problems.easy;

public class MiddleOfTheLinkedList {
    /**
     * #876. Middle of the Linked List
     * https://leetcode.com/problems/middle-of-the-linked-list/
     */
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
