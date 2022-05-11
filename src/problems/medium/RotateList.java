package problems.medium;

import problems.easy.ListNode;

public class RotateList {
    /***
     * # 61. Rotate List
     * https://leetcode.com/problems/rotate-list/
     */

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        ListNode headCopy = head;
        int len = 1;// <--------------- because we iterate till headCopy.next!=null
        //Step1: create circular ListNode
        while(headCopy.next!=null){
            len++;
            headCopy = headCopy.next;
        }
        if(k % len==0) return head; //we dont need to rotate
        headCopy.next = head;

        //Step2: find new head and new tail
        //(new head = len - k % len )
        int newTail =  len - k % len - 1; // <---------- (!!!!)


        //Step2: break circular ListNode at the point of newHead/newTail
        while(newTail>0){
            head = head.next;
            newTail--;
        }
        ListNode newHeadToReturn = head.next;
        head.next = null;
        return newHeadToReturn;
    }

}
