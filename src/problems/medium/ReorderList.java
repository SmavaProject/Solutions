package problems.medium;

import problems.easy.ListNode;

public class ReorderList {
    /***
     * #143. Reorder List
     * https://leetcode.com/problems/reorder-list/
     */

    public void reorderList(ListNode head) {
        ListNode tmpHead = head;
        int len = 0;

        while(tmpHead!=null){//find the length of the ListNode
            len++;
            tmpHead= tmpHead.next;
        }
        int leftIndex = 0;
        int rightIndex = len-1;
        while(leftIndex<rightIndex){
            ListNode tmpNode = head.next;

            ListNode last = head;
            ListNode prev = null;
            for(int i = leftIndex; i<rightIndex; i++){ //move pointer to the rightIndex position
                prev = last;
                last = last.next;
            }

            if(tmpNode != last){//for [1,2] etc.
                prev.next = null;
                head.next = last;
                last.next = tmpNode;
            }

            leftIndex = leftIndex+2;
            rightIndex = rightIndex--;
            head = head.next;
            head = head.next;

        }
    }
}
