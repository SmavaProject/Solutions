package problems.easy;

public class ReverseLinkedList {
    /***
     * # 206. Reverse Linked List
     * https://leetcode.com/problems/reverse-linked-list/
     *
     */
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode previous = null;
        ListNode current = head;
        while(current!=null){
            ListNode tmp = current.next; //<-- inside of loop!
            current.next = previous;
            previous = current;
            current = tmp;

        }
        return previous;
    }

}
