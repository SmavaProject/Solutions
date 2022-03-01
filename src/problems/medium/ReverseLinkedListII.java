package problems.medium;

import problems.easy.ListNode;

public class ReverseLinkedListII {
    /***
     * #92. Reverse Linked List II - MEDIUM
     * https://leetcode.com/problems/reverse-linked-list-ii/
     * Solution:
     * https://www.educative.io/courses/grokking-the-coding-interview/qVANqMonoB2
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null || head.next ==null){
            return head;
        }
        ListNode current = head;
        ListNode previous = null;
        int counter = 1;
        while(counter<left){ //find the last node that we dont need to reverse
            previous = current;
            current = current.next;
            counter++;
        }

        ListNode leftNotReversed = previous;
        ListNode leftReversed =current;
        ListNode dummy = null;
        while(counter <= right && current!=null){
            dummy = current.next;
            current.next = previous;
            previous = current;
            current = dummy;
            counter++;
        }

        if(leftNotReversed!=null){
            leftNotReversed.next = previous; //connect the first part
        }else{
            head = previous;
        }
        leftReversed.next = current; //connect the last part

        return head;

    }
}
