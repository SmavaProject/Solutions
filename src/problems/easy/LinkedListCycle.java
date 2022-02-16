package problems.easy;

public class LinkedListCycle {
    /**
     * #141. Linked List Cycle - EASY
     * https://leetcode.com/problems/linked-list-cycle/
     * LinkedList Cycle (easy):
     * https://www.educative.io/courses/grokking-the-coding-interview/N7rwVyAZl6D
     */
    public boolean hasCycle(ListNode head) {
        if(head== null){
            return false;
        }
        ListNode next = head;
        ListNode nextNext = head.next;

        while(next!=nextNext){
            if(next == null || nextNext == null || nextNext.next== null){
                return false;
            }

            next = next.next;
            nextNext = nextNext.next.next;

        }
        return true;
    }
}
